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
	@ApiModelProperty("手机号")
    private String phone;

    /**
     * 用户名
     */
	@ApiModelProperty("用户名") 
    private String username;

    /**
     * 密码
     */
	@ApiModelProperty("密码") 
    private String password;

    /**
     * 登录方式 0 手机号登录 1 用户名登录
     */
	@ApiModelProperty("登录方式 0 手机号登录 1 用户名登录")  
    private Integer type;  
}
