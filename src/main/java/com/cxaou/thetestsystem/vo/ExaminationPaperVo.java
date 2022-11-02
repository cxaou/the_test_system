package com.cxaou.thetestsystem.vo;

import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ApiModel("试卷")
@Data
@ToString(callSuper = true)
public class ExaminationPaperVo extends ExaminationPaper{

    @ApiModelProperty(value = "分数",required = true)
    private List<TestQuestionsDto> testQuestionsDtoList;





}
