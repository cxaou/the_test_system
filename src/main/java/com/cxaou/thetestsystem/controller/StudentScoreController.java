package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.dto.ScoreDto;
import com.cxaou.thetestsystem.pojo.StudentScore;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.service.StudentScoreService;
import com.cxaou.thetestsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(tags = "成绩接口")
@RequestMapping("/studentScore")
@RestController()
public class StudentScoreController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StudentScoreService studentScoreService;

    @Autowired
    private UserService userService;


    @GetMapping
    @ApiOperation(value = "查看自己的成绩/或者单个用户的成绩", notes = "id 等于 null 就是查自己 不等于null 就是查用户id的")
    public R<Page<ScoreDto>> getScore(HttpServletRequest request, int page, int pageSize, Long id) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        Page<StudentScore> pageInfo = new Page<>(page, pageSize);
        Page<ScoreDto> scoreDto;
        if (id != null) {
            User userServiceById = userService.getById(id);
            if (userServiceById == null) {
                return R.error("用户不存在");
            }
            scoreDto = studentScoreService.getScoreDto(pageInfo, id);
        } else {
            scoreDto = studentScoreService.getScoreDto(pageInfo, currentUserId);
        }

        return R.success(scoreDto);
    }


    @ApiOperation("查看自己学生的成绩")
    @GetMapping("get_student_score")
    public R<Page<ScoreDto>> getStudentScore(HttpServletRequest request, int page, int pageSize) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() == 2) {
            return R.error("没有权限");
        }
        Page<StudentScore> pageInfo = new Page<>(page, pageSize);
        Page<ScoreDto> studentScore = null;
        if (currentUser.getIdentity() == 1) {
            studentScore = studentScoreService.getStudentScore(pageInfo, currentUserId);
        }
        return R.success(studentScore);
    }


    @DeleteMapping
    @ApiOperation("删除学生的成绩,只有管理员有")
    public R<String> delete(HttpServletRequest request, Long id) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0) {
            return R.error("权限不够");
        }
        StudentScore studentScore = studentScoreService.getById(id);
        if (studentScore == null) {
            return R.error("成绩不存在");

        }
        boolean is_remover = studentScoreService.removeById(id);
        return is_remover ? R.success("删除成功") : R.error("删除失败");
    }



    @PutMapping
    @ApiOperation("修改学生的成绩，只有管理员有")
    public R<String> update(HttpServletRequest request, Long id, Double score) {
        String token = request.getHeader("token");
        StudentScore studentScore = studentScoreService.getById(id);
        if (studentScore == null) {
            return R.error("成绩不存在");

        }
        if (score == null) {
            return R.error("参数异常");
        }
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 0) {
            return R.error("权限不够");
        }
        studentScore.setScore(score);
        studentScoreService.saveOrUpdate(studentScore);
        return R.success("修改成功");


    }
}
