package com.cxaou.thetestsystem.mapper;

import com.cxaou.thetestsystem.pojo.TestQuestions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity com.cxaou.thetestsystem.pojo.TestQuestions
 */
@Repository
public interface TestQuestionsMapper extends BaseMapper<TestQuestions> {


    List<TestQuestions> getAllByExaminationPaperId(@Param("examinationId") Long examinationId);
}




