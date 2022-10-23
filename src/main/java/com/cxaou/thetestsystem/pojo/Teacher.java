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
 * @TableName teacher
 */
@TableName(value ="teacher")
@Data
@ApiModel("教师表")
public class Teacher implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "id",example = "1008",required = true)
    @TableId
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户表的id",example = "1002")
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}