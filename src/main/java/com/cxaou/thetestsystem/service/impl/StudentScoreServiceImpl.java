package com.cxaou.thetestsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.dto.ScoreDto;
import com.cxaou.thetestsystem.mapper.TeacherStudentMapper;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.StudentScore;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import com.cxaou.thetestsystem.service.ExaminationPaperService;
import com.cxaou.thetestsystem.service.StudentScoreService;
import com.cxaou.thetestsystem.mapper.StudentScoreMapper;
import com.cxaou.thetestsystem.service.UserExaminationPaperService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class StudentScoreServiceImpl extends ServiceImpl<StudentScoreMapper, StudentScore>
    implements StudentScoreService{


    @Autowired
    private StudentScoreService studentScoreService;

    @Autowired
    private ExaminationPaperService examinationPaperService;

    @Autowired
    private TeacherStudentMapper teacherStudentMapper;

    @Autowired
    private UserExaminationPaperService userExaminationPaperService;

    /**
     *
     * @param page page对象
     * @param userId 用户id
     * @return
     */
    @Override
    public Page<ScoreDto> getScoreDto(Page<StudentScore> page, Long userId) {

        LambdaQueryWrapper<StudentScore> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.eq(StudentScore::getStudentId, userId)
                .orderByDesc(StudentScore::getScore);
        studentScoreService.page(page, lambdaQueryWrapper);
        Page<ScoreDto> scoreDtoPage = new Page<>();
        BeanUtils.copyProperties(page,scoreDtoPage,"records");
        List<StudentScore> records = page.getRecords();

        List<ScoreDto> scoreDtoList =
                records.stream().map(studentScore -> {
                    ScoreDto tempStudentScore = new ScoreDto();
                    BeanUtils.copyProperties(studentScore,tempStudentScore);
                    ExaminationPaper examinationPaperServiceById =
                            examinationPaperService.getById(studentScore.getExaminationPaperId());
                    tempStudentScore.setExaminationPaper(examinationPaperServiceById);
                    return tempStudentScore;
                }).collect(Collectors.toList());
        scoreDtoPage.setRecords(scoreDtoList);
        return scoreDtoPage;
    }

    /**
     *
     * @param page
     * @param userId
     * @return
     */
    @Override
    public Page<ScoreDto> getStudentScore(Page<StudentScore> page, Long userId) {
        // 查看自己的学生
        List<Long> longs = teacherStudentMapper.selectStudentIdByThacherId(userId);
        LambdaQueryWrapper<StudentScore> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(StudentScore::getStudentId,longs).
                orderByDesc(StudentScore::getScore);
        studentScoreService.page(page,lambdaQueryWrapper);
        List<StudentScore> records = page.getRecords();

        List<ScoreDto> scoreDtoList = new ArrayList<>();
        for (StudentScore record : records) {
            Long userExaminationPaperId = record.getUserExaminationPaperId();
            UserExaminationPaper examinationPaper = userExaminationPaperService.getById(userExaminationPaperId);
            if (!examinationPaper.getCreateId().equals(userId)){
                continue;
            }
            ScoreDto scoreDto = new ScoreDto();
            BeanUtils.copyProperties(record,scoreDto);
            ExaminationPaper examinationPaperServiceById =
                    examinationPaperService.getById(record.getExaminationPaperId());
            scoreDto.setExaminationPaper(examinationPaperServiceById);
            scoreDtoList.add(scoreDto);
        }
        Page<ScoreDto> scoreDtoPage = new Page<>();
        BeanUtils.copyProperties(page,scoreDtoPage,"records");
        scoreDtoPage.setRecords(scoreDtoList);
        return scoreDtoPage;
    }
}




