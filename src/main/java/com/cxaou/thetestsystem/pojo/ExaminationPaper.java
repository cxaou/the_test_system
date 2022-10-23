package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName examination_paper
 */
@TableName(value ="examination_paper")
@Data
public class ExaminationPaper implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 试卷科目
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人 
     */
    private Long createName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Long updateName;

    /**
     * 介绍试卷题型
     */
    private String introduction;

    /**
     * 标题
     */
    private String title;

    /**
     * 考试时长
     */
    private Date duration;

    /**
     * 试卷分值
     */
    private Double testScores;

    /**
     * 0 存在 1 删除
     */
    @TableLogic
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}