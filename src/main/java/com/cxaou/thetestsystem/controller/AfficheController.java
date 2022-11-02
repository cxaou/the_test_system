package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.mapper.AfficheMapper;
import com.cxaou.thetestsystem.pojo.Affiche;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.AfficheService;
import com.cxaou.thetestsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@Api(tags = "公告管理")
@RequestMapping("/affiche")
public class AfficheController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AfficheService afficheService;

    @Autowired
    private AfficheMapper afficheMapper;

    @Autowired
    private UserService userService;


    @PostMapping
    @ApiOperation(value = "发布公告", notes = "管理员用来发布系统公告，教师发布的公告仅学生可见,只需要传入data字段即可")
    public R<String> addAffiche(@RequestBody Affiche affiche, HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentId = (Long) redisTemplate.opsForValue().get(token);
        if (!StringUtils.hasText(affiche.getData())) {
            return R.error("公告内容为空");
        }
        boolean isSuccess = afficheService.addAffiche(currentId, affiche);
        return isSuccess ? R.success("成功") : R.error("权限不够");
    }

    @GetMapping("/system_affiche")
    @ApiOperation("查询系统公告")
    public R<Affiche> getNewAffiche() {
        Affiche newSystemAffiche = afficheMapper.getNewSystemAffiche(0);
        return R.success(newSystemAffiche);
    }

    // 查询教师发布的公告,只有对应的学生能看见
    @GetMapping("/teacher_affiche")
    @ApiOperation(value = "查询教师公告", notes = "查询教师发布的公告,只有对应的学生能看见")
    public R<List<Affiche>> getTeacherAffiche(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        List<Affiche> teacherAffiche = afficheService.getTeacherAffiche(currentUserId);
        return R.success(teacherAffiche);
    }


    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page", value = "页码", required = true),
                    @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true),
                    @ApiImplicitParam(name = "name", value = "搜索框，模糊查询")
            }
    )
    @GetMapping("/this_release")
    @ApiOperation("查看自己发布的公告列表")
    public R<Page<Affiche>> getThisRelease(HttpServletRequest request, int page, int pageSize, String name) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        Page<Affiche> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Affiche> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name != null, Affiche::getData, name)
                .eq(Affiche::getCreateId, currentUserId);
        afficheService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page", value = "页码", required = true),
                    @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true),
                    @ApiImplicitParam(name = "name", value = "搜索框，模糊查询")
            }
    )
    @ApiOperation(value = "查询所有的公告列表", notes = "只有管理员有操作该接口的权限")
    @GetMapping("/all")
    public R<Page<Affiche>> getAllAffiche(HttpServletRequest request, int page, int pageSize, String name) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0) {
            return R.error("权限不够");
        }
        Page<Affiche> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Affiche> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name != null,Affiche::getData, name);
        afficheService.page(pageInfo);
        return R.success(pageInfo);
    }


    @DeleteMapping
    @ApiOperation(value = "删除公告", notes = "只需要传入两个参数：\n{\n" +
            "\t\"createId\": \"1585813386104492034\",\n" +
            "\t\"id\": \"3\"\n" +
            "}")
    public R<String> delete(HttpServletRequest request, @RequestBody Affiche affiche) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        if (affiche.getCreateId() == null || affiche.getId() == null) {
            return R.error("参数错误");
        }
        User currentUser = userService.getById(currentUserId);
        // 自己发布 或者 admin 用户 有权限
        if (!(affiche.getCreateId().equals(currentUserId) || currentUser.getIdentity() == 0)) {
            return R.error("权限不够，无法删除");
        }
        boolean isRemove = afficheService.removeById(affiche.getId());
        return isRemove ? R.success("删除成功") : R.error("删除失败");
    }


    @PutMapping
    @ApiOperation(value = "修改公告",notes = "只需要传入两个参数：\n{\n" +
            "\t\"data\": \"测试PUT方法\",\n" +
            "\t\"id\": 4\n" +
            "}")
    public R<String> update(@RequestBody Affiche affiche,HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        if (affiche.getId() == null || affiche.getData() == null){
            return R.error("参数不合法");
        }
        Affiche afficheSQL  = afficheService.getById(affiche.getId());
        if (afficheSQL == null){
            return R.error("公告不存在");
        }

        User currentUser = userService.getById(currentUserId);
        if (!(afficheSQL.getCreateId().equals(currentUserId)|| currentUser.getIdentity() == 0)){
            return R.error("权限不够");
        }
        afficheSQL.setData(affiche.getData());
        boolean isUpdate = afficheService.saveOrUpdate(afficheSQL);
        return isUpdate ? R.success("成功"):R.error("失败");
    }

}
