package com.cxaou.thetestsystem;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cxaou.thetestsystem.mapper.AfficheMapper;
import com.cxaou.thetestsystem.mapper.TeacherStudentMapper;
import com.cxaou.thetestsystem.pojo.Affiche;
import com.cxaou.thetestsystem.pojo.Student;
import com.cxaou.thetestsystem.pojo.Teacher;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.StudentService;
import com.cxaou.thetestsystem.service.TeacherService;
import com.cxaou.thetestsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private TeacherStudentMapper teacherStudentMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @Autowired
    private AfficheMapper  afficheMapper;

    @Test
    void searchStudentIdByThacherIdTest(){
        List<Long> longs = teacherStudentMapper.selectStudentIdByThacherId(1585544272400187393L);
        longs.forEach(System.out::println);

    }

    @Test
    void insertStudentData(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getIdentity,2);
        List<User> list = userService.list(lambdaQueryWrapper);
        for (int i = 0; i < list.size(); i++) {
            Student student = new Student();
            student.setUserId(list.get(i).getId());
            studentService.save(student);
        }

        list.forEach(System.out::println);
    }

    @Test
    void insertTeacherData(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getIdentity,1);
        List<User> list = userService.list(lambdaQueryWrapper);
        for (int i = 0; i < list.size(); i++) {
            Teacher teacher = new Teacher();
            teacher.setUserId(list.get(i).getId());
            teacherService.save(teacher);
        }
        list.forEach(System.out::println);
    }

    @Test
    public void getNewSystemAffche(){
        Affiche newAffche = afficheMapper.getNewSystemAffiche(0);
        System.out.println("newAffche = " + newAffche);
    }

    @Test
    public void selectThacherIdByStudentIdTest(){
        List<Long> longs = teacherStudentMapper.selectThacherIdByStudentId(1L);
        longs.forEach(System.out::println);
        System.out.println("****************************************************************************");
        List<Affiche> neWTeacherAffiche = afficheMapper.getNeWTeacherAffiche(Collections.singletonList(0L),0);
        neWTeacherAffiche.forEach(System.out::println);
    }
}
