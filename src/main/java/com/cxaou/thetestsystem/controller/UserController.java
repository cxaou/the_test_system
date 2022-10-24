package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户操作接口")
@RequestMapping("/user")
@RestController()
public class UserController {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", paramType = "from"),
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "from"),
            @ApiImplicitParam(name = "password",value = "密码",paramType = "from",required = true),
            @ApiImplicitParam(name = "type",value = "登录方式 0 手机号登录 1 用户名登录",required = true)
    })
    @PostMapping
    public R<User> login(@RequestBody User user) {

        return null;
    }
}
