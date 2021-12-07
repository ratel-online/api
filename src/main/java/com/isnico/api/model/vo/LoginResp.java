package com.isnico.api.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginResp {
	
	@ApiModelProperty("用户ID")
	private Long id;

	@ApiModelProperty("名称")
	private String name;

	@ApiModelProperty("积分")
	private Long score;

	@ApiModelProperty("用户昵称")
	private String username;

	@ApiModelProperty("令牌")
	private String token;

}
