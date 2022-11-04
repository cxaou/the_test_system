package com.cxaou.thetestsystem.dto;

import com.cxaou.thetestsystem.pojo.TestQuestions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * @TableName test_questions
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@ApiModel("试题Dto")
public class TestQuestionsDto extends TestQuestions{

    /**
     * 选项，答案，只有选择题有
     */
    @ApiModelProperty(" 选项，答案，只有选择题有")
    private Map<String,Object> optionsMap;

    @ApiModelProperty("selected")
    private boolean  selected;
}
