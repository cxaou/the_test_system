package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.erro.ParameterException;
import com.cxaou.thetestsystem.mapper.UserMapper;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.pojo.UserInfo;
import com.cxaou.thetestsystem.service.UserInfoService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.vo.LogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

/**
 *
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public User login(LogVo user) {
        try {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            //等于0 手机号登录
            queryWrapper.eq(user.getType() == 0, User::getPhone, user.getPhone())
                    .eq(user.getType() == 1 && StringUtils.hasText(user.getUsername()), User::getUsername, user.getUsername());
            User userOne = this.getOne(queryWrapper);
            return userOne;
        } catch (Exception e) {
            throw new ParameterException("请求参数异常");
        }
    }

    @Override
    public void signIn(LogVo user) {
        this.save(user);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        userInfo.setCreateTime(LocalDate.now());
        userInfo.setUpdateTime(LocalDate.now());
        userInfoService.save(userInfo);
    }
}




