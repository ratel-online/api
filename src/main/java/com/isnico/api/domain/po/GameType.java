package com.isnico.api.domain.po;

import java.util.Date;

import org.nico.ourbatis.annotation.RenderPrimary;

public class GameType {

	@RenderPrimary
	private String id;
	
	private String name;

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
	
	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
}
