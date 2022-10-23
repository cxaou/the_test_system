package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName test_questions
 */
@TableName(value ="test_questions")
@Data
public class TestQuestions implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 试卷id
     */
    private Long examinationPaperId;

    /**
     * 0 单选 1 多选 2 主观
     */
    private Integer testQuestionsType;

    /**
     * 试题
     */
    private String data;

    /**
     * 答案
     */
    private String options;

    /**
     * 选项
     */
    private String answer;

    /**
     * 分数
     */
    private Double score;

    /**
     * 最小相似度 ， 只有主观题有
     */
    private Integer minSimilarity;

    /**
     * 最大相似度， 只有主观题有
     */
    private Integer maxSimilarity;

    /**
     * 是否删除 0 未删除 1 已删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}