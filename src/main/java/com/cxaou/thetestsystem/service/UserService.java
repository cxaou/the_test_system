package com.cxaou.thetestsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxaou.thetestsystem.vo.LogVo;

/**
 *
 */
public interface UserService extends IService<User> {

    User login(LogVo user);

    void signIn(LogVo user);

    User authenticationByName(String name,int identity);

    void disableUser(User user);

    boolean isUserState(Long id);

    /***
     * 查询分页的对象
     * @param user 登录者
     * @param pageInfo 分页对象
     * @param name 模糊查询
     */
    void getPageUser(User user, Page<User> pageInfo , String name, int identity);
}
