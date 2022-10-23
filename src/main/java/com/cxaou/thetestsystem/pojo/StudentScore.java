package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName student_score
 */
@TableName(value ="student_score")
@Data
@ApiModel("用户成绩表")
public class StudentScore implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "id",required = true,example = "1002")
    @TableId
    private Long id;

    /**
     * 学生id
     */
    @ApiModelProperty(value = "学生id的",required = true,example = "1045")
    private Long studentId;

    /**
     * 试卷id
     */
    @ApiModelProperty(value = "试卷的id",required = true,example = "4578")
    private Long examinationPaperId;

    /**
     * 考试id
     */
    @ApiModelProperty(value = "考试id",required = true,example = "4521")
    private Long userExaminationPaperId;

    /**
     * 成绩
     */
    @ApiModelProperty(value = "分数",example = "100")
    private Double score;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}