package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName teacher_student
 */
@TableName(value ="teacher_student")
@Data
public class TeacherStudent implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 教师id
     */
    private Long thacherId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 逻辑删除  0 未删除 1 已删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}