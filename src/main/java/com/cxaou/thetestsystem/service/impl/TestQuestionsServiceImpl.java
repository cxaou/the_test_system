package com.cxaou.thetestsystem.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.cxaou.thetestsystem.service.ExaminationPaperService;
import com.cxaou.thetestsystem.service.TestQuestionsService;
import com.cxaou.thetestsystem.mapper.TestQuestionsMapper;
import com.cxaou.thetestsystem.vo.ExaminationPaperVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class TestQuestionsServiceImpl extends ServiceImpl<TestQuestionsMapper, TestQuestions>
    implements TestQuestionsService{


    @Autowired
    private ExaminationPaperService examinationPaperService;

    @Autowired
    private TestQuestionsMapper testQuestionsMapper;



    /**
     * 查询试题信息，并封装成dto
     * @param examinationPaperId 试卷id
     * @return
     */
    @Override
    public ExaminationPaperVo getTopic(Long examinationPaperId) {
        // 查询出试卷对象
        ExaminationPaper examinationPaper = examinationPaperService.getById(examinationPaperId);
        ExaminationPaperVo examinationPaperVo = new ExaminationPaperVo();
        BeanUtils.copyProperties(examinationPaper,examinationPaperVo);
        // 查询对应的试题对象
        List<TestQuestions> allByExaminationPaperId =
                testQuestionsMapper.getAllByExaminationPaperId(examinationPaperId);
        // 转成DTO
        List<TestQuestionsDto> testQuestionsDtoList = allByExaminationPaperId.stream().map(testQuestions -> {
            TestQuestionsDto testQuestionsDto = new TestQuestionsDto();
            BeanUtils.copyProperties(testQuestions,testQuestionsDto);
            String options = testQuestions.getOptions();
            Map<String,Object> parse = (Map<String, Object>) JSON.parse(options);
            testQuestionsDto.setOptions(null);
            testQuestionsDto.setOptionsMap(parse);
            return testQuestionsDto;
        }).collect(Collectors.toList());
        examinationPaperVo.setTestQuestionsDtoList(testQuestionsDtoList);
        return examinationPaperVo;
    }
}




