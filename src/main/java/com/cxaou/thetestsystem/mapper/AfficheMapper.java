package com.cxaou.thetestsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxaou.thetestsystem.pojo.Affiche;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity com.cxaou.thetestsystem.pojo.Affiche
 */
@Repository
public interface AfficheMapper extends BaseMapper<Affiche> {

    /**
     * 查询最新的公告
     * @param type 公告的类型，0系统公告，1 教师公告
     * @return 返回最新的公告
     */
    Affiche getNewSystemAffiche(@Param("type") Integer type);


    /**
     * 查询学生对应的教师公告
     * @param teacherList 教师的id列表
     * @return 对应的公告
     */
    List<Affiche> getNeWTeacherAffiche(@Param("teacherList") List<Long> teacherList,@Param("type") Integer type);

}




