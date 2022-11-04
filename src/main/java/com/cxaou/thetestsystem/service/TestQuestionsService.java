package com.cxaou.thetestsystem.service;

import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxaou.thetestsystem.vo.ExaminationPaperVo;

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
}
