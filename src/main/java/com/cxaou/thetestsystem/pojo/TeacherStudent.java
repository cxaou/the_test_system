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
    private Long studetId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}