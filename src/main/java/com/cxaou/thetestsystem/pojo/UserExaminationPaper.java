package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user_examination_paper
 */
@TableName(value ="user_examination_paper")
@Data
public class UserExaminationPaper implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 试卷id
     */
    private Long examintionPaperId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 考试用时时长
     */
    private Date examinationTime;

    /**
     * 考试开始时间
     */
    private Date startTime;

    /**
     * 考试结束时间
     */
    private Date endTime;

    /**
     * 是否开始考试 0 开始 1 结束
     */
    private Integer start;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}