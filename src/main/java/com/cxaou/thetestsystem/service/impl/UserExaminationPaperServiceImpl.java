package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.mapper.TeacherStudentMapper;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.User;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import com.cxaou.thetestsystem.service.ExaminationPaperService;
import com.cxaou.thetestsystem.service.TeacherStudentService;
import com.cxaou.thetestsystem.service.UserExaminationPaperService;
import com.cxaou.thetestsystem.mapper.UserExaminationPaperMapper;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.DateUtils;
import com.cxaou.thetestsystem.utils.VerifyUserExaminationPaperVoUtils;
import com.cxaou.thetestsystem.vo.UserExaminationPaperVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Transactional
@Service
public class UserExaminationPaperServiceImpl extends ServiceImpl<UserExaminationPaperMapper, UserExaminationPaper>
        implements UserExaminationPaperService {


    @Autowired
    private UserService userService;

    @Autowired
    private ExaminationPaperService examinationPaperService;

    @Autowired
    private TeacherStudentMapper teacherStudentMapper;

    /**
     * 添加考试
     *
     * @param userExaminationPaperVo 要操作的考试vo对象
     * @param userIds                当前登录用户的id
     * @return
     */
    @Override
    public boolean addUserExaminationPaper(UserExaminationPaperVo userExaminationPaperVo, List<Long> userIds) {

        //查看传过来的试卷是否存在
        ExaminationPaper examinationPaper = examinationPaperService.getById(userExaminationPaperVo.getExaminationPaperId());
        if (examinationPaper == null) { // 试卷不存在
            return false;
        }

        //开始考试时间
        LocalDateTime startTime = userExaminationPaperVo.getStartTime();
        UserExaminationPaper userExaminationPaper = new UserExaminationPaper();
        userExaminationPaper.setStartTime(startTime);
        userExaminationPaper.setExamintionPaperId(examinationPaper.getId());
        userExaminationPaper.setExaminationStart(1);
        LocalTime duration = examinationPaper.getDuration();
        // 结合试卷表判断考试结束时间
        LocalDateTime endTime = DateUtils.calculateEndDateTime(startTime, duration);
        userExaminationPaper.setEndTime(endTime);
        userExaminationPaper.setExaminationTime(LocalTime.of(0, 0, 0));

        List<UserExaminationPaper> userExaminationPaperList =
                userIds.stream().map((userId) -> {
                    UserExaminationPaper temp = new UserExaminationPaper();
                    BeanUtils.copyProperties(userExaminationPaper, temp);
                    temp.setUserId(userId);
                    return temp;
                }).collect(Collectors.toList());
        this.saveBatch(userExaminationPaperList);
        return true;
    }


}




