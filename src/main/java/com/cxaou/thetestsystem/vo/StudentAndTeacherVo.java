package com.cxaou.thetestsystem.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("添加学生用的vo")
@Data
public class StudentAndTeacherVo {

    @ApiModelProperty(value = "学生的用户名",required = true)
    private String StudentName;

    @ApiModelProperty(value = "教师的用户名")
    private String TeacherName;
}
