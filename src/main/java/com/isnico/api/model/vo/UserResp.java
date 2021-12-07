package com.isnico.api.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserResp {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("积分")
    private Long score;

    @ApiModelProperty("胜场")
    private Long victory;

    @ApiModelProperty("败场")
    private Long defeat;
}
