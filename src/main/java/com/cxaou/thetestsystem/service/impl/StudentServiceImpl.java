package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.mapper.StudentMapper;
import com.cxaou.thetestsystem.pojo.Student;
import com.cxaou.thetestsystem.pojo.TeacherStudent;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.StudentService;
import com.cxaou.thetestsystem.service.TeacherStudentService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.vo.StudentAndTeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Autowired
    private UserService userService;




    @Autowired
    private TeacherStudentService teacherStudentService;


    /**
     * 添加学生
     * @param currentUserId 当前登录用户的id
     * @param studentAndTeacherVo 学生和教师的name
     * @return 响应的结果集
     */
    @Override
    public R<String> addStudent(Long currentUserId, StudentAndTeacherVo studentAndTeacherVo) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, currentUserId);
        User currentUser = userService.getOne(queryWrapper);
        Integer identity = currentUser.getIdentity();
        if (identity == 2) {
            return R.error("权限不够");
        }
        // 创建教师学生表的对象
        TeacherStudent teacherStudent = new TeacherStudent();
        // 获取学生的name
        String studentName = studentAndTeacherVo.getStudentName();
        //校验是不是学生
        User studentUser = userService.authenticationByName(studentName,2);
        if (studentUser == null || studentUser.getUserState() != 0){
            return R.error("学生身份信息不合法");
        }

        teacherStudent.setStudentId(studentUser.getId()); // 设置学生的id
        // 根据 currentUserID查询
        teacherStudent.setThacherId(currentUserId); // 默认教师登录，把当前用户的id 设置成教师id
        if (identity == 0) { // 等于0就是管理员登录
            // 根据username拿到教师信息
            String teacherName = studentAndTeacherVo.getTeacherName();
            User teacherUser = userService.authenticationByName(teacherName, 1);
            if ( teacherUser == null) {
                return R.error("教师身份不合法");
            }
            teacherStudent.setThacherId(teacherUser.getId());
        }
        // 保存记录
        teacherStudentService.save(teacherStudent);
        return R.success("成功");
    }

}




