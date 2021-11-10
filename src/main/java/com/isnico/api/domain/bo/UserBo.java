package com.isnico.api.domain.bo;

import java.util.Date;

import org.nico.ourbatis.annotation.RenderPrimary;

public class UserBo {
	
	@RenderPrimary
	private String id;
	
	private String nickname;
	
	private String account;
	
	private String ruleId;
	
	private String ruleType;
	
	private String ruleName;
	
	private Date createTime;
	
	private Date updateTime;
	
	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public final Date getUpdateTime() {
		return updateTime;
	}

	public final void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public final String getRuleId() {
		return ruleId;
	}

	public final void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public final String getRuleType() {
		return ruleType;
	}

	public final void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public final String getRuleName() {
		return ruleName;
	}

	public final void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getNickname() {
		return nickname;
	}

	public final void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public final String getAccount() {
		return account;
	}

	public final void setAccount(String account) {
		this.account = account;
	}

}
