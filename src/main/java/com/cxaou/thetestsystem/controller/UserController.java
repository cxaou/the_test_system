package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.dto.UserDto;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.MD5Util;
import com.cxaou.thetestsystem.utils.MsmConstantUtils;
import com.cxaou.thetestsystem.utils.TokenUtil;
import com.cxaou.thetestsystem.utils.VerifyUtils;
import com.cxaou.thetestsystem.vo.LogVo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private Boolean StartSSM;


    @PostMapping("/login")
    @ApiOperation("登录用的接口")
    public R<User> login(@RequestBody LogVo user) {

        String code = user.getCode();

        Integer type = user.getType();

        if (type == null) {
            return R.error("登录方式为空");
        }


        String phone = null;
        if (type == 0) {
            if (!StringUtils.hasText(code)) {
                return R.error("验证码为空");
            }
            phone = user.getPhone();

            if (!VerifyUtils.verifyPhone(phone)) {
                return R.error("手机号不合法");
            }

            String codeRedis = (String) redisTemplate.opsForValue().get(phone);
            R<User> r_start = VerifyUtils.verifyPhoneAndCode(phone, codeRedis, code);
            if (r_start != null) {
                return r_start;
            }


        }

        if (!StringUtils.hasText(user.getPassword())) {
            return R.error("密码为空");
        }

        User userOne = userService.login(user);
        if (userOne == null) {
            return R.error("账号不存在");
        }
        // 判断账号状态
        if (userOne.getUserState() == 1) {
            return R.error("该账号已经被禁用了");
        }
        String password = MD5Util.getMD5Str(user.getPassword());
        if (!password.equals(userOne.getPassword())) {
            return R.error("账号或密码错误");
        }
        //把查询出来的密码置空
        userOne.setPassword("");
        String token = TokenUtil.sign(userOne.getId());
        log.info("token: " + token);
        // 设置过期时间为3天
        redisTemplate.opsForValue().set(token, userOne.getId(), 3, TimeUnit.DAYS);
        UserDto userDto = new UserDto();
        // 拷贝对象
        BeanUtils.copyProperties(userOne, userDto);
        userDto.setToken(token);
        // 用户登录成功,删除redis 的验证码
        if (phone != null) {
            redisTemplate.delete(phone);
        }

        return R.success(userDto);
    }

    /***
     * 身份验证失败的接口，内部接口
     * @param request
     * @return
     */
    @ApiParam(hidden = true)
    @GetMapping("/index")
    public R<String> index(HttpServletRequest request) {
        return R.error(request.getAttribute("msg").toString());
    }

    @ApiOperation("发送手机验证码")
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody LogVo logUser) {
        // 获取手机号
        String phone = logUser.getPhone();

        // 手机号校验
        if (!VerifyUtils.verifyPhone(phone)) {
            return R.error("手机号不合法");
        }

        String phoneRedis = (String) redisTemplate.opsForValue().get(phone);
        if (phoneRedis != null) { // 不等于null ，证明获取过验证码
            return R.error("请不要重复获取验证码");
        }
        String code = MsmConstantUtils.generateValidateCode(6);
        log.info(code);

        if (StartSSM) {
            MsmConstantUtils.sendPhone(code, phone);
        }
        // 设置验证码时效为一分钟
        redisTemplate.opsForValue().set(phone, code, 1, TimeUnit.MINUTES);
        return R.success("手机验证码发送成功");
    }

    @ApiOperation("注册")
    @PostMapping("/signIn")
    public R<String> signIn(@RequestBody LogVo user) {
        String code = user.getCode();

        if (!StringUtils.hasText(code)) {
            return R.error("验证码为空");
        }

        String phone = user.getPhone();
        String codeRedis = (String) redisTemplate.opsForValue().get(phone);
        //校验验证码和手机号
        R<String> r_start = VerifyUtils.verifyPhoneAndCode(phone, codeRedis, code);
        if (r_start != null) {
            return r_start;
        }

        Integer identity = user.getIdentity();
        if (identity == null) {
            return R.error("身份信息为空");
        }
        if (!(identity == 1 || identity == 2)) {
            return R.error("身份不合法");
        }

        //校验密码格式
        String signInPassword = user.getPassword();
        if (!VerifyUtils.verifyPassword(signInPassword)) {
            return R.error("密码不合法");
        }


        // 默认手机号做用户名
        user.setUsername(phone);
        // 默认0 启用
        user.setUserState(0);
        // 设置默认头像
        user.setHeadPortrait("aa.png");
        //保存用户
        user.setPassword(MD5Util.getMD5Str(user.getPassword()));
        // 保存用户的同时，创建一条用户详情的记录
        userService.signIn(user);

        //注册成功 删除验证码
        redisTemplate.delete(phone);
        return R.success("成功");
    }

    @ApiOperation(value = "修改用户名")
    @ApiImplicitParam(value = "要修改的名字", name = "username")
    @PutMapping("/username")
    public R<User> setUsername(HttpServletRequest request, String username) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (!VerifyUtils.isUsername(username)) {
            return R.error("用户名必须是5-20位的数字，字母或者下划线");
        }
        currentUser.setUsername(username);
        boolean isUpdate = userService.saveOrUpdate(currentUser);
        return isUpdate ? R.success(currentUser) : R.error("修改失败");
    }

    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "旧密码密码"),
            @ApiImplicitParam(name = "newPassword", value = "要修改的密码")
    })
    @PutMapping("/password")
    public R<User> setPassword(HttpServletRequest request, String oldPassword, String newPassword) {
        if (!VerifyUtils.verifyPassword(newPassword)) {
            return R.error("密码不合法");
        }
        if (!StringUtils.hasText(oldPassword)) {
            return R.error("密码为空");
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);

        String md5NewPassword = MD5Util.getMD5Str(newPassword);
        String md5OldPassword = MD5Util.getMD5Str(oldPassword);

        User currentUser = userService.getById(currentUserId);

        if (!md5OldPassword.equals(currentUser.getPassword())) {
            return R.error("密码错误");
        }
        if (md5NewPassword.equals(currentUser.getPassword())) {
            return R.error("新密码跟旧密码一样");
        }
        currentUser.setPassword(md5NewPassword);
        boolean isPassword = userService.saveOrUpdate(currentUser);
        return isPassword ? R.success(currentUser) : R.error("修改失败");
    }
}
