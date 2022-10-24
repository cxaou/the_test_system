package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName user
 */
@ApiModel("学生信息表")
@TableName(value ="user")
@Data
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
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 0 admin 1 教师 2 学生
     */
    @ApiModelProperty("0 admin 1 教师 2 学生")
    private Integer identity;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 状态  0 启用 1 禁用
     */
    @ApiModelProperty("状态  0 启用 1 禁用")
    private Integer state;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String headPortrait;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}