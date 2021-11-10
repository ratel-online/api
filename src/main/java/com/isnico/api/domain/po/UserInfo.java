package com.isnico.api.domain.po;

import java.util.Date;

import org.nico.ourbatis.annotation.RenderPrimary;

public class UserInfo {
	
	@RenderPrimary
	private String id;
	
	private String addressOfGithub;
	
	private String addressOfGitee;
	
	private String addressOfBlog;
	
	private String addressOfTwitter;

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
	
	public final String getAddressOfGithub() {
		return addressOfGithub;
	}

	public final void setAddressOfGithub(String addressOfGithub) {
		this.addressOfGithub = addressOfGithub;
	}

	public final String getAddressOfGitee() {
		return addressOfGitee;
	}

	public final void setAddressOfGitee(String addressOfGitee) {
		this.addressOfGitee = addressOfGitee;
	}

	public final String getAddressOfBlog() {
		return addressOfBlog;
	}

	public final void setAddressOfBlog(String addressOfBlog) {
		this.addressOfBlog = addressOfBlog;
	}

	public final String getAddressOfTwitter() {
		return addressOfTwitter;
	}

	public final void setAddressOfTwitter(String addressOfTwitter) {
		this.addressOfTwitter = addressOfTwitter;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	
}
