package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName affiche
 */
@TableName(value ="affiche")
@Data
public class Affiche implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 创建者 id
     */
    private Long createId;

    /**
     * 修改者 id
     */
    private Long updateId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间 
     */
    private Date updateTime;

    /**
     * 公告类型 0 系统公告 1 教师公告
     */
    private Integer type;

    /**
     * 公告内容
     */
    private String data;

    /**
     * 是否删除公告 0 否 1 删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}