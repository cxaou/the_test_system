package com.cxaou.thetestsystem.dto;

import com.cxaou.thetestsystem.pojo.TestQuestions;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @TableName test_questions
 */

@Data
@ApiModel("试题Dto")
public class TestQuestionsDto extends TestQuestions implements Serializable {

    private Map<String,Object> optionsMap;
}
