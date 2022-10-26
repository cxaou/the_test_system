package com.cxaou.thetestsystem.service;

import com.cxaou.thetestsystem.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxaou.thetestsystem.vo.LogVo;

/**
 *
 */
public interface UserService extends IService<User> {

    User login(LogVo user);

    void signIn(LogVo user);
}
