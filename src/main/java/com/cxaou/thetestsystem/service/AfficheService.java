package com.cxaou.thetestsystem.service;

import com.cxaou.thetestsystem.pojo.Affiche;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface AfficheService extends IService<Affiche> {
    /**
     * 添加公告
     *
     * @param currentId 当前用户的id
     * @param affiche   公告
     * @return
     */
    boolean addAffiche(Long currentId, Affiche affiche);

    /**
     * 获取公告
     * @param currentId 当前用户的id
     * @return 查询到的公告
     */
    List<Affiche> getTeacherAffiche(Long currentId);
}
