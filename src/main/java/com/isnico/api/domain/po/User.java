package com.isnico.api.domain.po;

import java.util.Date;

import org.nico.ourbatis.annotation.RenderPrimary;

public class User {
	
	@RenderPrimary
	private String id;
	
	private String nickname;
	
	private String account;
	
	private String password;
	
	private String headUrl;
	
	private String ruleId;
	
	private String ruleType;
	
	private String ruleName;
	
	private Date createTime;
	
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

	public final User setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public final Date getUpdateTime() {
		return updateTime;
	}

	public final User setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public final String getRuleId() {
		return ruleId;
	}

	public final User setRuleId(String ruleId) {
		this.ruleId = ruleId;
		return this;
	}

	public final String getRuleType() {
		return ruleType;
	}

	public final User setRuleType(String ruleType) {
		this.ruleType = ruleType;
		return this;
	}

	public final String getRuleName() {
		return ruleName;
	}

	public final User setRuleName(String ruleName) {
		this.ruleName = ruleName;
		return this;
	}

	public final String getId() {
		return id;
	}

	public final User setId(String id) {
		this.id = id;
		return this;
	}

	public final String getNickname() {
		return nickname;
	}

	public final User setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public final String getAccount() {
		return account;
	}

	public final User setAccount(String account) {
		this.account = account;
		return this;
	}

	public final String getPassword() {
		return password;
	}

	public final User setPassword(String password) {
		this.password = password;
		return this;
	}
	
}
