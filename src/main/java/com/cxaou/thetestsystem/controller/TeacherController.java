package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
        return studentService.addStudent(currentUserId,studentAndTeacherVo);

    }


    @DeleteMapping
    @ApiOperation("移除学生")
    public R<String> deleteStudent() {
        // 实现功能，将学生从该管理的教师中移除
        //操作教师学生表，删除记录(逻辑删除)

        return null;
    }

    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page",value = "页码",required = true),
                    @ApiImplicitParam(name = "pageSize",value = "每页的条数",required = true),
                    @ApiImplicitParam(name = "name",value = "搜索框，模糊查询")
            }
    )
    @GetMapping
    @ApiOperation("查看学生列表")
    public R<Page<User>> getStudent(HttpServletRequest request,int page,int pageSize,String name) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        Page<User> pageInfo = new Page<>(page,pageSize);
        studentService.getStudentByCurrentUser(currentUserId,pageInfo ,name );
        return R.success(pageInfo);
    }
}
