package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.pojo.Student;
import com.cxaou.thetestsystem.pojo.Teacher;
import com.cxaou.thetestsystem.pojo.TeacherStudent;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.StudentService;
import com.cxaou.thetestsystem.service.TeacherService;
import com.cxaou.thetestsystem.service.TeacherStudentService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.vo.StudentAndTeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "教师操作的接口")
@RequestMapping("/teacher")
@RestController
@Slf4j
public class TeacherController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherStudentService teacherStudentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ApiOperation("添加学生")
    public R<String> addStudent(@RequestBody StudentAndTeacherVo studentAndTeacherVo, HttpServletRequest request) {
        //拿到 token
        String token = request.getHeader("token");
        // 根据 token 查到 用户信息，进行身份验证
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, currentUserId);
        User currentUser = userService.getOne(queryWrapper);
        Integer identity = currentUser.getIdentity();
        if (identity == 2) {
            return R.error("权限不够");
        }
        // 创建教师学生表的对象
        TeacherStudent teacherStudent = new TeacherStudent();
        Long studentId = studentAndTeacherVo.getStudentId();
        // 查看学生在数据库不
        Student student = studentService.getById(studentId);
        if (student == null){
            return R.error("学生不存在");
        }
        teacherStudent.setStudetId(studentId); // 设置学生的id
        teacherStudent.setThacherId(currentUserId); // 默认教师登录，把当前用户的id 设置成教师id
        if (identity == 0) { // 等于0就是管理员登录
            Long teacherId = studentAndTeacherVo.getTeacherId(); // 拿到教师的id
            if (teacherId == null) { //判断教师的id是不是等于空
                return R.error("教师id为空");
            }
            // 查看数据库看教师存在不
            Teacher teacher = teacherService.getById(teacherId); //获取教师对象
            if (teacher == null) {
                return R.error("教师不存在");
            }
            // 教师 存在 ，设置教师id
            teacherStudent.setThacherId(teacherId);
        }
        // 保存记录
        teacherStudentService.save(teacherStudent);
        return R.success("成功");
    }


    @DeleteMapping
    @ApiOperation("删除学生")
    public R<String> deleteStudent() {
        return null;
    }

    @GetMapping
    @ApiOperation("查看学生列表")
    public R<String> getStudent() {
        return null;
    }
}
