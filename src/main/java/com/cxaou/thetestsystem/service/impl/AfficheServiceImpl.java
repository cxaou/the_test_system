package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.mapper.TeacherStudentMapper;
import com.cxaou.thetestsystem.pojo.Affiche;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.AfficheService;
import com.cxaou.thetestsystem.mapper.AfficheMapper;
import com.cxaou.thetestsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 *
 */
@Transactional
@Service
public class AfficheServiceImpl extends ServiceImpl<AfficheMapper, Affiche>
    implements AfficheService{

    @Autowired
    private UserService userService;

    @Autowired
    private AfficheMapper afficheMapper;

    @Autowired
    private AfficheService afficheService;

    @Autowired
    private TeacherStudentMapper teacherStudentMapper;

    /**
     *  @param currentId 当前用户的id
     * @param affiche 公告
     * @return
     */
    @Override
    public boolean addAffiche(Long currentId, Affiche affiche) {
        // 根据当前用户ID，查询账号信息，辨别身份
        User currentUser = userService.getById(currentId);
        Integer identity = currentUser.getIdentity();
        if (identity == 2){
            return false;
        }
        //设置发布者的id
        affiche.setCreateId(currentId);
        //设置发布时间
        affiche.setCreateTime(LocalDate.now());
        //设置修改者的id
        affiche.setUpdateId(currentId);
        //设置修改的时间
        affiche.setUpdateTime(LocalDate.now());
        //设置公告类型, 1 教师公告 0 系统公告
        affiche.setType(identity);
        // 设置公告的状态
        affiche.setAfficheStatic(0);
        // 把当前用户之前发布的公告状态修改成1
        LambdaQueryWrapper<Affiche> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Affiche::getCreateId,currentId)
                .eq(Affiche::getAfficheStatic,0);
        Affiche formerAffiche = afficheService.getOne(queryWrapper);
        formerAffiche.setAfficheStatic(1);
        afficheService.saveOrUpdate(formerAffiche);
        return this.save(affiche);


    }

    @Override
    public List<Affiche> getTeacherAffiche(Long currentId) {
        // 根据当前用户ID，查询账号信息，辨别身份
        User currentUser = userService.getById(currentId);
        if (currentUser.getIdentity() != 2){
            return null;
        }
        // 学生上线，想要看到公告，首先看自己的老师有没有发公告
        //1. 查询出学生对应的教师id
        List<Long> thacherIds = teacherStudentMapper.selectThacherIdByStudentId(currentId);
        // 在用教师的id在公告表中找到最新的公告
        return afficheMapper.getNeWTeacherAffiche(thacherIds,1);
    }
}




