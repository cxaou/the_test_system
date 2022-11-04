package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.dto.ExaminationInfoDto;
import com.cxaou.thetestsystem.mapper.TeacherStudentMapper;
import com.cxaou.thetestsystem.pojo.TeacherStudent;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import com.cxaou.thetestsystem.service.TeacherStudentService;
import com.cxaou.thetestsystem.service.TestQuestionsService;
import com.cxaou.thetestsystem.service.UserExaminationPaperService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.VerifyUserExaminationPaperVoUtils;
import com.cxaou.thetestsystem.vo.ExaminationPaperVo;
import com.cxaou.thetestsystem.vo.UserExaminationPaperVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user_examinationPaper")
@Api(tags = "用户的考试")
public class UserExaminationPaperController {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private UserExaminationPaperService userExaminationPaperService;

    @Autowired
    private TeacherStudentMapper teacherStudentMapper;

    @Autowired
    private TestQuestionsService testQuestionsService;

    @Autowired
    private TeacherStudentService teacherStudentService;


    @PostMapping(value = "/add_own_student")
    @ApiOperation(value = "给自己所有学生添加考试", notes = "只有教师有操作该权限的资格\n参数示例： \n{\n" +
            "\t\"acceptStartTime\": \"2022-11-3 15:42:00\",\n" +
            "\t\"examinationPaperId\": 1\n" +
            "}")
    public R<String> addOwnStudentExaminationPaper(@RequestBody UserExaminationPaperVo userExaminationPaperVo,
                                                   HttpServletRequest request) {
        R<String> result = VerifyUserExaminationPaperVoUtils.verifyCoreAndShift(userExaminationPaperVo);
        if (result != null) {
            return result;
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);

        User currentUser = userService.getById(currentUserId);
        if (currentUser.getIdentity() != 1) { // 只有教师有该操作的权限
            return R.error("权限不够");
        }
        // 教师该自己的学生发布试卷
        // 查询自己的学生
        List<Long> userIds =
                teacherStudentMapper.selectStudentIdByThacherId(currentUserId);
        userExaminationPaperService.addUserExaminationPaper(userExaminationPaperVo, userIds);

        return R.success("添加成功");
    }


    @PostMapping("/add")
    @ApiOperation(value = "给单个学生(或者批量添加)添加考试", notes = "参数实例:\n{\n" +
            "\t\"acceptStartTime\": \"2022-11-3 17:00:00\",\n" +
            "\t\"examinationPaperId\": 1,\n" +
            "\t\"userIds\": [800258967,479095665]\n" +
            "}")
    public R<String> addOneExaminationPaper(@RequestBody UserExaminationPaperVo userExaminationPaperVo,
                                            HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        R<String> result = VerifyUserExaminationPaperVoUtils.verifyCoreAndShift(userExaminationPaperVo);
        if (result != null) {
            return result;
        }

        if (currentUser.getIdentity() == 2) { // 学生没有该接口的权限
            return R.error("权限不够");
        }
        // 如果是教师需要判断这id中有没有不是自己的学生
        List<Long> userIds = userExaminationPaperVo.getUserIds();
        if (userIds.size() == 0) {
            return R.error("没有学生");
        }
        if (currentUser.getIdentity() == 1) {
            List<Long> students = teacherStudentMapper.selectStudentIdByThacherId(currentUserId);
            // 查出老师的所有学生求交集
            students.retainAll(userIds);
            if (students.size() != userIds.size()) {
                return R.error("权限不够");
            }
        }
        // 管理员直接添加
        for (Long userId : userIds) {
            User user = userService.getById(userId);
            if (user == null) {
                return R.error("用户不存在");
            }
        }
        boolean isAdd = userExaminationPaperService.addUserExaminationPaper(userExaminationPaperVo, userIds);
        return isAdd ? R.success("添加成功") : R.error("添加失败");
    }


    @GetMapping
    @ApiOperation(value = "查看我的考试", notes = "查询用户要参加考试的试卷 创建DTO要能看到试卷的详细信息\n" +
            "examinationStart  条件筛选， 0 开始的考试 1 未开始的考试 2 结束的考试 ")
    public R<Page<ExaminationInfoDto>> getUserExaminationPaper(HttpServletRequest request,
                                                               Integer page, Integer pageSize, Integer examinationStar) {
        // 查看考试功能
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        Page<UserExaminationPaper> pageInfo = new Page<>(page, pageSize);

        Page<ExaminationInfoDto> dtoPage = userExaminationPaperService.getUserExaminationPaper(pageInfo, currentUserId, examinationStar);
        return R.success(dtoPage);
    }


    @GetMapping("/user_examination")
    @ApiOperation(value = "根据id查询考试信息", notes = "教师跟admin有权限\n" +
            "examinationStart  条件筛选， 0 开始的考试 1 未开始的考试 2 结束的考试 ")
    public R<Page<ExaminationInfoDto>> getUserExaminationPaperById(HttpServletRequest request, Long userId,
                                                                   Integer page, Integer pageSize, Integer examinationStart) {
        // 查看考试功能
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        User currentUser = userService.getById(currentUserId);
        User user = userService.getById(userId);
        if (user == null) {
            return R.error("用户不存在");
        }
        if (currentUser.getIdentity() == 2) {
            return R.error("没有权限");
        }
        if (currentUser.getIdentity() == 1) {
            LambdaQueryWrapper<TeacherStudent> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TeacherStudent::getThacherId, currentUserId)
                    .eq(TeacherStudent::getStudentId, userId);
            TeacherStudent one = teacherStudentService.getOne(queryWrapper);
            if (one == null) {
                return R.error("权限不够");
            }
        }
        // admin用户 直接查
        Page<UserExaminationPaper> pageInfo = new Page<>(page, pageSize);
        Page<ExaminationInfoDto> dtoPage = userExaminationPaperService.getUserExaminationPaper(pageInfo, userId, examinationStart);
        return R.success(dtoPage);
    }

    //  TODO 开始考试
    /*
    提交考试id，根据这个字段判断是否开始考试，
    // 然后找到试卷信息
    // 在根据试卷信息，找到试题，返回试题信息 (TestQuestionsDto)
     examinationStart
     */
    @GetMapping("/startTest")
    @ApiOperation("开始考试")
    public R<ExaminationPaperVo> startTest(Long userExaminationPaperId, HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        UserExaminationPaper userExaminationPaper =
                userExaminationPaperService.getById(userExaminationPaperId);
        if (userExaminationPaper == null) {
            return R.error("参数异常");
        }
        if (!userExaminationPaper.getUserId().equals(currentUserId)) {
            return R.error("权限不够");
        }
        if (userExaminationPaper.getExaminationStart() == 1) {
            return R.error("考试未开始");
        }
        if (userExaminationPaper.getExaminationStart() == 2) {
            return R.error("考试已结束");
        }
        ExaminationPaperVo topic = testQuestionsService.getTopic(userExaminationPaper.getExamintionPaperId());
        return R.success(topic);
    }

    // TODO 修改考试信息 教师 跟 admin 有权限
    @PutMapping()
    public R<String> update() {
      // 教师只能修改自己学生的，admin可以修改所有的
        // 查询到自己学生的，
        return R.success("成功");
    }
    // TODO 删除考试信息

    // TODO 提交考试，并评分,记录到成绩表中


}
