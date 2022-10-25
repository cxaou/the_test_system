package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.erro.ParameterException;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.mapper.UserMapper;
import com.cxaou.thetestsystem.vo.LogVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

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
}




