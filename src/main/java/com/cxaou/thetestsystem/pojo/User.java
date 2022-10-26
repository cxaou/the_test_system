package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@ApiModel("用户信息")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;

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
     * 0 admin 1 教师 2 学生
     */
    @ApiModelProperty("身份  0 admin 1 教师 2 学生")
    private Integer identity;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true,example = "000000")
    private String password;

    /**
     * 状态  0 启用 1 禁用
     */
    @ApiModelProperty(" 状态  0 启用 1 禁用")
    private Integer userState;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String headPortrait;


    @ApiModelProperty("token")
    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
