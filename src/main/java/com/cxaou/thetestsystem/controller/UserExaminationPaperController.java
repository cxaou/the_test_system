package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.mapper.TeacherStudentMapper;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import com.cxaou.thetestsystem.service.TeacherStudentService;
import com.cxaou.thetestsystem.service.UserExaminationPaperService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.VerifyUserExaminationPaperVoUtils;
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
    @ApiOperation(value = "给单个学生(或者批量添加)添加考试",notes = "参数实例:\n{\n" +
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
        if (result != null){
            return result;
        }

        if (currentUser.getIdentity() == 2) { // 学生没有该接口的权限
            return R.error("权限不够");
        }
        // 如果是教师需要判断这id中有没有不是自己的学生
        List<Long> userIds = userExaminationPaperVo.getUserIds();
        if (userIds.size() == 0){
            return R.error("没有学生");
        }
        if (currentUser.getIdentity() == 1){
            List<Long> students = teacherStudentMapper.selectStudentIdByThacherId(currentUserId);
            // 查出老师的所有学生求交集
            students.retainAll(userIds);
            if (students.size() != userIds.size()){
                return R.error("权限不够");
            }
        }
        // 管理员直接添加
        for (Long userId : userIds) {
            User user = userService.getById(userId);
            if (user == null){
                return R.error("用户不存在");
            }
        }
        userExaminationPaperService.addUserExaminationPaper(userExaminationPaperVo,userIds);
        return R.error("添加成功");
    }



    // TODO 查询用户要参加考试的试卷 创建DTO要能看到试卷的详细信息，教师可以查看自己的学生的，admin可以查看所有学生的，学生只能查看自己的
    @GetMapping
    @ApiOperation("查看我的考试")
    public List<R<UserExaminationPaper>> getUserExaminationPaper() {

        return null;
    }


    // TODO 开始考试

    // TODO 修改考试信息 教师 跟 admin 有权限

    // TODO 删除考试信息

    // TODO 提交考试，并评分,记录到成绩表中


}
