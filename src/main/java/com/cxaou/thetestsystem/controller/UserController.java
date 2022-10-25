package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.MD5Util;
import com.cxaou.thetestsystem.utils.MsmConstantUtils;
import com.cxaou.thetestsystem.utils.PhoneUtils;
import com.cxaou.thetestsystem.utils.TokenUtil;
import com.cxaou.thetestsystem.vo.LogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Slf4j
@Api(tags = "用户操作接口")
@RequestMapping("/user")
@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${SSM.StartSSM: false}")
    private  Boolean StartSSM;

    @ApiParam("/hello")
    @GetMapping()
    public R<String> hello() {
        return R.success("成功");
    }

    @PostMapping("/login")
    @ApiParam("登录用的接口")
    public R<User> login(@RequestBody LogVo user) {

        String code = user.getCode();

        Integer type = user.getType();

        if (type == null) {
            return R.error("登录方式为空");
        }
        String phone = null;
        if (type == 0) {
            phone = user.getPhone();
            if (!PhoneUtils.verifyPhone(phone)){
                return R.error("手机号不合法");
            }
            String codeRedis = (String) redisTemplate.opsForValue().get(phone);
            if (codeRedis == null){
                return R.error("请先获取验证码");
            }
            if (!codeRedis.equals(code)){
                return R.error("验证码错误");
            }

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
        redisTemplate.opsForValue().set(token, userOne.getId(),3,TimeUnit.DAYS);
        userOne.setToken(token);
        // 用户登录成功,删除redis 的验证码
        if (phone != null){
            redisTemplate.delete(phone);
        }

        return R.success(userOne);
    }

    @ApiParam(hidden = true)
    @GetMapping("index")
    public R<String> index(HttpServletRequest request, HttpServletResponse response) {
        return R.error(request.getAttribute("msg").toString());
    }

    @ApiParam("发送手机验证码")
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody LogVo logUser) {
        // 获取手机号
        String phone = logUser.getPhone();

        // 手机号校验
        if (!PhoneUtils.verifyPhone(phone)) {
            return R.error("手机号不合法");
        }

        String phoneRedis = (String) redisTemplate.opsForValue().get(phone);
        if (phoneRedis != null) { // 不等于null ，证明获取过验证码
            return R.error("请不要重复获取验证码");
        }
        String code = MsmConstantUtils.generateValidateCode(6);
        log.info(code);

        if (StartSSM){
            MsmConstantUtils.sendPhone(code, phone);
        }
        // 设置验证码时效为一分钟
        redisTemplate.opsForValue().set(phone, code, 1, TimeUnit.MINUTES);
        return R.success("手机验证码发送成功");
    }

}
