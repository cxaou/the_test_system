package com.cxaou.thetestsystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("用户考试用的vo")
public class UserExaminationPaperVo implements Serializable {

    @ApiModelProperty("试卷Id")
    private Long examinationPaperId;


    @ApiModelProperty(hidden = true)
    private LocalDateTime startTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("考试开始时间")
    private Date acceptStartTime;

    @ApiModelProperty("批量添加的用户")
    private List<Long> UserIds;

    @ApiModelProperty("考试id")
    private Long id;

    @ApiModelProperty(hidden = true)
    private static final long serialVersionUID = 1L;
}
