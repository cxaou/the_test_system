package com.cxaou.thetestsystem.mapper;

import com.cxaou.thetestsystem.pojo.TeacherStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity com.cxaou.thetestsystem.pojo.TeacherStudent
 */
@Repository
public interface TeacherStudentMapper extends BaseMapper<TeacherStudent> {

    /**
     * 查询出教师对应的学生id
     * @param thacherId 教师id
     * @return 学生id的集合
     */
    List<Long> selectStudentIdByThacherId(@Param("thacherId") Long thacherId);

    /**
     * 查询出学生id对应的教师id
     * @param studentId 学生的id
     * @return 教师id的集合
     */
    List<Long> selectThacherIdByStudentId(@Param("studentId") Long studentId);

}




