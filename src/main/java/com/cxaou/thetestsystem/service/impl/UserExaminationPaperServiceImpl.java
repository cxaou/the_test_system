package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.dto.ExaminationInfoDto;
import com.cxaou.thetestsystem.mapper.TeacherStudentMapper;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import com.cxaou.thetestsystem.service.ExaminationPaperService;
import com.cxaou.thetestsystem.service.UserExaminationPaperService;
import com.cxaou.thetestsystem.mapper.UserExaminationPaperMapper;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.DateUtils;
import com.cxaou.thetestsystem.vo.UserExaminationPaperVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
     * @param currentUserId
     * @return
     */
    @Override
    public boolean addUserExaminationPaper(UserExaminationPaperVo userExaminationPaperVo, List<Long> userIds, Long currentUserId) {

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
        // 公共字段
        if (userExaminationPaperVo.getId() == null){
            userExaminationPaper.setCreateTime(LocalDateTime.now());
            userExaminationPaper.setCreateId(currentUserId);
        }
        userExaminationPaper.setUpdateTime(LocalDateTime.now());
        userExaminationPaper.setUpdateId(currentUserId);

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
                    if (userExaminationPaperVo.getId() != null){
                        temp.setId(userExaminationPaperVo.getId());
                    }
                    return temp;
                }).collect(Collectors.toList());
        this.saveOrUpdateBatch(userExaminationPaperList);
        return true;
    }


    /**
     * @param pageInfo 分页对象
     * @param userId   用户id
     * @param examinationStart
     * @return
     */
    @Override
    public Page<ExaminationInfoDto> getUserExaminationPaper(Page<UserExaminationPaper> pageInfo,
                                                            Long userId, Integer examinationStart) {
        LambdaQueryWrapper<UserExaminationPaper> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserExaminationPaper::getUserId, userId)
                    .eq(examinationStart != null, UserExaminationPaper::getExaminationStart,examinationStart);
        this.page(pageInfo, queryWrapper);
        Page<ExaminationInfoDto> infoDtoPage = new Page<>();
        BeanUtils.copyProperties(pageInfo, infoDtoPage, "records");
        List<UserExaminationPaper> records = pageInfo.getRecords();
        List<ExaminationInfoDto> examinationInfoDtoList = records.stream().map(userExaminationPaper -> {

            if (userExaminationPaper.getExaminationStart() != 2) {
                if (DateUtils.isStare(userExaminationPaper.getStartTime())) {
                    userExaminationPaper.setExaminationStart(0);
                } else {
                    userExaminationPaper.setExaminationStart(1);
                }
                if (DateUtils.isStare(userExaminationPaper.getEndTime())) {
                    userExaminationPaper.setExaminationStart(2);
                }
                // 更新数据库
                this.saveOrUpdate(userExaminationPaper);
            }

            // 查询试卷信息
            ExaminationInfoDto examinationInfoDto = new ExaminationInfoDto();
            BeanUtils.copyProperties(userExaminationPaper, examinationInfoDto);
            ExaminationPaper examination =
                    examinationPaperService.getById(userExaminationPaper.getExamintionPaperId());
            examinationInfoDto.setExaminationPaper(examination);
            return examinationInfoDto;
        }).collect(Collectors.toList());
        infoDtoPage.setRecords(examinationInfoDtoList);
        return infoDtoPage;
    }


}




