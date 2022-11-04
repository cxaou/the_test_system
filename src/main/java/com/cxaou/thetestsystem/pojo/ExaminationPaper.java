package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName examination_paper
 */
@TableName(value ="examination_paper")
@Data
@ApiModel("试卷表")
public class ExaminationPaper implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "试卷id",example = "1001")
    @TableId
    private Long id;

    /**
     * 试卷科目
     */
    @ApiModelProperty(value = "试卷科目",example = "语文",required = true)
    private String type;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "试卷的创建时间")
    private LocalDate createTime;

    /**
     * 创建人 
     */
    @ApiModelProperty(value = "试卷的创建人")
    private Long createName;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "试卷的修改时间")
    private LocalDate updateTime;

    /**
     * 修改人
     */
    @ApiModelProperty("试卷的修改人")
    private Long updateName;

    /**
     * 介绍试卷题型
     */
    @ApiModelProperty(value = "介绍试卷题型",example = "该试卷总分xxx分，单选x道，多选x道，主观x到",required = true)
    private String introduction;

    /**
     * 标题
     */
    @ApiModelProperty(value = "试卷标题",example = "语文第一单元测试",required = true)
    private String title;

    /**
     * 考试时长
     */
    @ApiModelProperty(value = "考试时长",example = "02:00:00",required = true,dataType = "Time")
    private LocalTime duration;

    /**
     * 试卷分值
     */
    @ApiModelProperty(value = "试卷分值",example = "150",required = true)
    private Double testScores;

    /**
     * 0 存在 1 删除
     */
    @ApiModelProperty(hidden = true)
    @TableLogic
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}