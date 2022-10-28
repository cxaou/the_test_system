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

    /***
     * 根据登录id查询到对应的学生id
     * @param currentId 登录者的id
     * @param pageInfo 分页对象
     * @param name 模糊查询
     */
    void getStudentByCurrentUser(Long currentId,Page<User> pageInfo ,String name);

    R<String> addStudent(Long currentUserId, StudentAndTeacherVo studentAndTeacherVo);


}
