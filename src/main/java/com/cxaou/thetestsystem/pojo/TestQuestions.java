package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName test_questions
 */
@TableName(value ="test_questions")
@Data
@ApiModel("试题表")
public class TestQuestions implements Serializable {
    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value = "id",required = true,example = "1")
    private Long id;

    /**
     * 试卷id
     */
    @ApiModelProperty(value = "试卷的id",required = true,example = "1")
    private Long examinationPaperId;

    /**
     * 0 单选 1 多选 2 主观
     */
    @ApiModelProperty(value = " 0 单选 1 多选 2 主观",required = true,example = "0")
    private Integer testQuestionsType;

    /**
     * 试题
     */
    @ApiModelProperty(value = "试题",example = "下面哪个是软件代码版本控制软件？")
    private String data;

    /**
     * 选项
     */
    @ApiModelProperty(value = "选项 只有选择题有",example = "{\"A\":\" project\",\" B\": \"SVN\",\" C\" :\" notepad++\",\" D\":\"Xshell\"}" )
    private String options;

    /**
     * 答案
     */
    @ApiModelProperty(value = "答案",example = "B")
    private String answer;

    /**
     * 分数
     */
    @ApiModelProperty(value = "分数",example = "10")
    private Double score;

    /**
     * 最小相似度 ， 只有主观题有
     */
    @ApiModelProperty(" 最小相似度 ， 只有主观题有")
    private Integer minSimilarity;

    /**
     * 最大相似度， 只有主观题有
     */
    @ApiModelProperty("最大相似度， 只有主观题有")
    private Integer maxSimilarity;

    /**
     * 是否删除 0 未删除 1 已删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
