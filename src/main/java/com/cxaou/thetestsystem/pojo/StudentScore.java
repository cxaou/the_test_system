package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student_score
 */
@TableName(value ="student_score")
@Data
public class StudentScore implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 试卷id
     */
    private Long examinationPaperId;

    /**
     * 考试id
     */
    private Long userExaminationPaperId;

    /**
     * 成绩
     */
    private Double score;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}