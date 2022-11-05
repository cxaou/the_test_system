package com.cxaou.thetestsystem.service;

import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxaou.thetestsystem.vo.ExaminationPaperVo;

import java.util.List;

/**
 *
 */
public interface TestQuestionsService extends IService<TestQuestions> {

    /**
     * 根据试卷id，返回试题信息
     * @param examinationPaperId 试卷id
     * @return 试题的Dto
     */
    ExaminationPaperVo getTopic(Long examinationPaperId);

    /**
     *  根据提交上来的dto 对象判分
     * @param testQuestionsDto
     * @return
     */
    Double giveAMark(List<TestQuestionsDto> testQuestionsDto);

    /**
     *  更新试题信息
     *
     * @param testQuestionsDto  试题
     * @param oldScore 旧的分数
     */
    void updateTestQuestionService(TestQuestionsDto testQuestionsDto,Double oldScore);
}
