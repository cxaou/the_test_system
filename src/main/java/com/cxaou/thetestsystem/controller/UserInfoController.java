package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.UserInfo;
import com.cxaou.thetestsystem.service.UserInfoService;
import com.cxaou.thetestsystem.utils.IDCardUtil;
import com.cxaou.thetestsystem.utils.VerifyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Api(tags = "用户详情")
@RequestMapping("/userInfo")
@RestController
@Slf4j
public class UserInfoController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserInfoService userInfoService;

    // 修改
    @PutMapping()
    @ApiOperation("更新用户信息")
    public R<String> update(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        log.info("生日：{}", userInfo.getBirthday().getClass());
        //拿到token
        String token = request.getHeader("token");
        // 根据token拿到id
        Long userId = (Long) redisTemplate.opsForValue().get(token);
        // 只能修改自己的用户信息
        userInfo.setUserId(userId);
        userInfo.setUpdateTime(LocalDate.now());

        // 校验身份证的和合法性
        if (userInfo.getIdNumber() != null && !IDCardUtil.isIDCard(userInfo.getIdNumber())) {
            return R.error("身份证不合法");
        }
        if (userInfo.getEmail() != null && !VerifyUtils.isEmail(userInfo.getEmail())) {
            return R.error("邮箱不合法");
        }
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserId, userInfo.getUserId());
        userInfoService.update(userInfo, queryWrapper);
        log.info("token:  {}   userId: {} ", token, userId);

        return R.success("更新成功");
    }

    @ApiOperation("查看用户详细信息")
    @GetMapping("/userInfo")
    public R<UserInfo> getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = (Long) redisTemplate.opsForValue().get(token);
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserId, userId);
        UserInfo userInfo = userInfoService.getOne(queryWrapper);
        userInfo.setIdNumber("");
        return R.success(userInfo);
    }
}
