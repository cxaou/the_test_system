package com.cxaou.thetestsystem.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @TableName affiche
 */
@TableName(value = "affiche")
@Data
@ApiModel("公告")
public class Affiche implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "id", example = "1001")
    @TableId
    private Long id;

    /**
     * 创建者 id
     */
    @ApiModelProperty(value = "创建者id，谁创建了这个公告", example = "1125")
    private Long createId;

    /**
     * 修改者 id
     */
    @ApiModelProperty(value = "修改者id，谁修改了这个公告", example = "1855")
    private Long updateId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建公告的时间")
    private LocalDate createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改公告的时间")
    private LocalDate updateTime;

    /**
     * 公告类型 0 系统公告 1 教师公告
     */
    @ApiModelProperty(value = "公告类型 0 系统公告 1 教师公告")
    private Integer type;

    /**
     * 公告内容
     */
    @ApiModelProperty(value = "公告内容")
    private String data;

    /**
     * 0 发布中， 1 已近回收
     */
    @ApiModelProperty(value = "公告状态")
    private Integer afficheStatic;

    /**
     * 是否删除公告 0 否 1 删除
     */
    @ApiModelProperty(hidden = true)
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}