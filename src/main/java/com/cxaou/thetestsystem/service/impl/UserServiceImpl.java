package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.erro.ParameterException;
import com.cxaou.thetestsystem.mapper.UserMapper;
import com.cxaou.thetestsystem.pojo.Student;
import com.cxaou.thetestsystem.pojo.Teacher;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.pojo.UserInfo;
import com.cxaou.thetestsystem.service.StudentService;
import com.cxaou.thetestsystem.service.TeacherService;
import com.cxaou.thetestsystem.service.UserInfoService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.vo.LogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

/**
 *
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Override
    public User login(LogVo user) {
        try {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            //等于0 手机号登录
            queryWrapper.eq(user.getType() == 0, User::getPhone, user.getPhone())
                    .eq(user.getType() == 1 && StringUtils.hasText(user.getUsername()), User::getUsername, user.getUsername());
            User userOne = this.getOne(queryWrapper);
            return userOne;
        } catch (Exception e) {
            throw new ParameterException("请求参数异常");
        }
    }

    @Override
    public void signIn(LogVo user) {
        // 保存 用户信息
        this.save(user);
        // 保存用户详情信息
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        userInfo.setCreateTime(LocalDate.now());
        userInfo.setUpdateTime(LocalDate.now());
        // 识别身份，教师还是学生，往对应的表中插入数据
        Integer identity = user.getIdentity();
        if (identity == 1){ //教师
            Teacher teacher = new Teacher();
            teacher.setUserId(user.getId());
            teacherService.save(teacher);
        }
        if (identity == 2){ //学生
            Student student = new Student();
            student.setUserId(user.getId());
            studentService.save(student);
        }
        userInfoService.save(userInfo);
    }
}




