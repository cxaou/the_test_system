package com.cxaou.thetestsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.vo.StudentAndTeacherVo;

/**
 *
 */
public interface StudentService extends IService<Student> {



    R<String> addStudent(Long currentUserId, StudentAndTeacherVo studentAndTeacherVo);


}
