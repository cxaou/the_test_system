package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.MD5Util;
import com.cxaou.thetestsystem.utils.TokenUtil;
import com.cxaou.thetestsystem.vo.LogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Api(tags = "用户操作接口")
@RequestMapping("/user")
@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @ApiParam("/hello")
    @GetMapping()
    public R<String> hello() {
        return R.success("成功");
    }

    @PostMapping("/login")
    @ApiParam("登录用的接口")
    public R<User> login(@RequestBody LogVo user) {


        if (user.getType() == null) {
            return R.error("登录方式为空");
        }
        if (!StringUtils.hasText(user.getPassword())) {
            return R.error("密码为空");
        }

        User userOne = userService.login(user);
        if (userOne == null) {
            return R.error("账号不存在");
        }
        String password = MD5Util.getMD5Str(user.getPassword());
        if (!password.equals(userOne.getPassword())) {
            return R.error("账号或密码错误");
        }
        userOne.setPassword("");
        String token = TokenUtil.sign(userOne.getId());
        log.info("token: " + token);
        userOne.setToken(token);
        return R.success(userOne);
    }

    @GetMapping("index")
    public R<String> index(HttpServletRequest request, HttpServletResponse response) {
        return R.error(request.getAttribute("msg").toString());
    }
}
