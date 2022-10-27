package com.cxaou.thetestsystem.dto;

import com.cxaou.thetestsystem.pojo.UserExaminationPaper;
import com.cxaou.thetestsystem.pojo.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户考试")
public class UserInfoDto extends UserInfo {

    @ApiModelProperty("我的考试")
    private UserExaminationPaper userExaminationPaper;


}
