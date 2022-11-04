package com.cxaou.thetestsystem.dto;

import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("考试信息的dto")
public class ExaminationInfoDto extends UserExaminationPaper {

    @ApiModelProperty("试卷信息")
    private ExaminationPaper examinationPaper;
}
