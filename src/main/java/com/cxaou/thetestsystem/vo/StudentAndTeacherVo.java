package com.cxaou.thetestsystem.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("添加学生用的vo")
@Data
public class StudentAndTeacherVo {

    @ApiModelProperty(value = "学生的id",required = true)
    private Long StudentId;

    @ApiModelProperty(value = "教师的id")
    private Long TeacherId;
}
