package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.StudentService;
import com.cxaou.thetestsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags = "管理员操作的接口")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StudentService studentService;

    // 禁用用户
    @ApiOperation(value = "禁用用户/启用用户",notes = "只用传入用户id跟要修改的状态")
    @PutMapping
    public R<String> disableUser(@RequestBody User user, HttpServletRequest request){
        Long userId = user.getId();
        if (userId == null){
            return R.error("用户id为空");
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0){
            return R.error("不是管理员");
        }
        userService.disableUser(user);
        return R.success("成功");
    }

    @ApiOperation("获取所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true),
            @ApiImplicitParam(name = "name", value = "搜索框，模糊查询"),
            @ApiImplicitParam(name = "identity",value = "要查看的身份 0(查看所有管理员) 1(查看所有教师) 2(查看所有学生) 3(查看所有成员)")
    })
    // 获取到所有用户
    @GetMapping("/allUser")
    public R<Page<User>> getUserAll(int page,int pageSize,String name,int identity,HttpServletRequest request){
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        Page<User> pageInfo = new Page<>(page,pageSize);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0){
            return R.error("权限不够");
        }
        userService.getPageUser(currentUser,pageInfo,name,identity);
        return R.success(pageInfo);


    }
}
