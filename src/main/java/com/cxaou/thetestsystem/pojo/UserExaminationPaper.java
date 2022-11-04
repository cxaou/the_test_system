package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName user_examination_paper
 */
@TableName(value ="user_examination_paper")
@Data
@ApiModel("考试信息")
public class UserExaminationPaper implements Serializable {
    /**
     * 主键
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;

    /**
     * 试卷id
     */
    @ApiModelProperty("试卷id")
    private Long examintionPaperId;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 考试用时时长
     */
    @ApiModelProperty("考试用时时长")
    private LocalTime examinationTime;

    /**
     * 考试开始时间
     */
    @ApiModelProperty("考试开始时间")
    private LocalDateTime startTime;

    /**
     * 考试结束时间
     */
    @ApiModelProperty("考试结束时间")
    private LocalDateTime endTime;

    /**
     * 是否开始考试 0 开始 1 未开始 2 结束
     */
    @ApiModelProperty(" 是否开始考试 0 开始 1 未开始 2 结束")
    private Integer examinationStart;


    /**
     * 发布人的id
     */
    private Long createId;

    /**
     * 修改人的id
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 发布时间
     */
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
