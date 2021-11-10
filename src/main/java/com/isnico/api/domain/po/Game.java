package com.isnico.api.domain.po;

import java.util.Date;

import org.nico.ourbatis.annotation.RenderPrimary;

public class Game {
	
	@RenderPrimary
	private String id;
	
	private String ownerId;
	
	private String content;
	
	private String introduce;
	
	private String cover;
	
	private String title;
	
	private String gameTypeId;
	
	private String gameTypeName;
	
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
	
	public final String getGameTypeId() {
		return gameTypeId;
	}

	public final void setGameTypeId(String gameTypeId) {
		this.gameTypeId = gameTypeId;
	}

	public final String getGameTypeName() {
		return gameTypeName;
	}

	public final void setGameTypeName(String gameTypeName) {
		this.gameTypeName = gameTypeName;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getOwnerId() {
		return ownerId;
	}

	public final void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public final String getIntroduce() {
		return introduce;
	}

	public final void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public final String getCover() {
		return cover;
	}

	public final void setCover(String cover) {
		this.cover = cover;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

}
