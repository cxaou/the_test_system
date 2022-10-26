package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PutMapping("/update")
    @ApiOperation("更新用户信息")
    public R<String> update(@RequestBody UserInfo userInfo, HttpServletRequest request){
        //拿到token
        String token = request.getHeader("token");
        // 根据token拿到id
        Long userId = (Long) redisTemplate.opsForValue().get(token);
        // 只能修改自己的用户信息
        userInfo.setUserId(userId);
        userInfo.setUpdateTime(LocalDate.now());
        // 校验身份证的和合法性
        if (!IDCardUtil.isIDCard(userInfo.getIdNumber())){
            return R.error("身份证不合法");
        }
        if (!VerifyUtils.isEmail(userInfo.getEmail())){
            return R.error("邮箱不合法");
        }
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserId,userInfo.getUserId());
        userInfoService.update(userInfo,queryWrapper);
        log.info("token:  {}   userId: {} ",token,userId);

        return R.success("更新成功");
    }
}
