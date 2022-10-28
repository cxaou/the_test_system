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

    List<Long> searchStudentIdByThacherId(@Param("ThacherId") Long ThacherId);
}




