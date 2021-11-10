package com.isnico.api.domain.vo.user;

import io.swagger.annotations.ApiModelProperty;

public class UserRestVo {

	@ApiModelProperty(value = "用户ID")
	private String userId;
	
	@ApiModelProperty(value = "用户昵称")
	private String nickname;
	
	@ApiModelProperty(value = "用户头像")
	private String headUrl;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	
}
