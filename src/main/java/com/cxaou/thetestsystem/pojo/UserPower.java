package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_power
 */
@TableName(value ="user_power")
@Data
public class UserPower implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 添加试卷的权限  0 有权限 1 没有权限
     */
    private Integer addExamination;

    /**
     * 发布公告的权限  0 有权限 1 没有权限 
     */
    private Integer addAffiche;

    /**
     * 删除公告的权限 0 有权限 1 没有权限
     */
    private Integer delAffiche;

    /**
     * 修改试卷的权限 0 有权限 1 没有权限
     */
    private Integer publishExamination;

    /**
     * 判卷的权限（可以二次判卷）0 有权限 1 没有权限
     */
    private Integer gradePapers;

    /**
     * 管理员权限 0 有权限 1 没有权限
     */
    private Integer admin;

    /**
     * 教师权限 0 有权限 1 没有权限
     */
    private Integer teachers;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}