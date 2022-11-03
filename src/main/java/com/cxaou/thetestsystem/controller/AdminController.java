package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.StudentService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.MD5Util;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags = "管理员操作的接口")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StudentService studentService;

    // 禁用用户
    @ApiOperation(value = "禁用用户/启用用户", notes = "只用传入用户id跟要修改的状态")
    @PutMapping
    public R<String> disableUser(@RequestBody User user, HttpServletRequest request) {
        Long userId = user.getId();
        if (userId == null) {
            return R.error("用户id为空");
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0) {
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
            @ApiImplicitParam(name = "identity", value = "要查看的身份 0(查看所有管理员) 1(查看所有教师) 2(查看所有学生) 3(查看所有成员·)")
    })
    // 获取到所有用户
    @GetMapping("/allUser")
    public R<Page<User>> getUserAll(int page, int pageSize, String name, int identity, HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        Page<User> pageInfo = new Page<>(page, pageSize);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0) {
            return R.error("权限不够");
        }
        userService.getPageUser(currentUser, pageInfo, name, identity);
        return R.success(pageInfo);
    }


    @ApiOperation(value = "重置用户的密码", notes = "重置用户名密码为000000，admin 才有该操作该接口的权限")
    @PutMapping("/reset_password")
    public R<String> resetPassword(@RequestBody User user, HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0) {
            return R.error("权限不够");
        }
        if (user.getId() == null) {
            return R.error("参数不合法");
        }
        User updateUser = userService.getById(user.getId());
        if (updateUser == null) {
            return R.error("要修改的用户不存在");
        }
        String initialPassword = MD5Util.getMD5Str("000000");
        updateUser.setPassword(initialPassword);
        userService.saveOrUpdate(updateUser);
        return R.success("保存成功");

    }


}
