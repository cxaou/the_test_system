package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
@ApiModel("学生表")
public class Student implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "id",example = "1002")
    @TableId
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "关联的用户表id",example = "1005")
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}