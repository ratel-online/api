package com.isnico.api.domain.vo.user;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class UserFullVo {
	
	@ApiModelProperty(value = "用户ID")
	private String id;
	
	@ApiModelProperty(value = "用户昵称")
	private String nickname;
	
	@ApiModelProperty(value = "用户账户")
	private String account;
	
	@ApiModelProperty(value = "用户头像")
	private String headUrl;
	
	@ApiModelProperty(value = "角色名称")
	private String ruleName;
	
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	
	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final UserFullVo setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public final Date getUpdateTime() {
		return updateTime;
	}

	public final UserFullVo setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public final String getRuleName() {
		return ruleName;
	}

	public final UserFullVo setRuleName(String ruleName) {
		this.ruleName = ruleName;
		return this;
	}

	public final String getId() {
		return id;
	}

	public final UserFullVo setId(String id) {
		this.id = id;
		return this;
	}

	public final String getNickname() {
		return nickname;
	}

	public final UserFullVo setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public final String getAccount() {
		return account;
	}

	public final UserFullVo setAccount(String account) {
		this.account = account;
		return this;
	}
	
}
