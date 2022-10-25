package com.cxaou.thetestsystem.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录用的vo")
@Data
public class LogVo {
  
      /**
     * 手机号
     */
	@ApiModelProperty(value = "手机号",example = "15879461996")
    private String phone;

    /**
     * 用户名
     */
	@ApiModelProperty(value = "用户名",example = "tom")
    private String username;

    /**
     * 密码
     */
	@ApiModelProperty(value = "密码",required = true,example = "000000")
    private String password;

    /**
     * 登录方式 0 手机号登录 1 用户名登录
     */
	@ApiModelProperty(value = "登录方式 0 手机号登录(只需传phone字段) 1 用户名登录(传入用户名字段)  手机字段跟用户名字段只选一个",required = true)
    private Integer type;  
}
