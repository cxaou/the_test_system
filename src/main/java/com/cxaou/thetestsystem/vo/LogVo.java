package com.cxaou.thetestsystem.vo;

import com.cxaou.thetestsystem.pojo.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@ApiModel("登录用的vo")
@Data
public class LogVo extends User  {


    /**
     * 登录方式 0 手机号登录 1 用户名登录
     */
	@ApiModelProperty(value = "登录方式 0 手机号登录(只需传phone字段) 1 用户名登录(传入用户名字段)  手机字段跟用户名字段只选一个",required = true)
    private Integer type;

    /**
     * 验证码
     */
	@ApiModelProperty(value = "验证码",required = true)
	private String code;
}
