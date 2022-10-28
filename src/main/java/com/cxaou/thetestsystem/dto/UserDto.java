package com.cxaou.thetestsystem.dto;

import com.cxaou.thetestsystem.pojo.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户信息")
public class UserDto extends User {

    @ApiModelProperty("token")
    private String token;

}
