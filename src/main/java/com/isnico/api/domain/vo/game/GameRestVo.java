package com.isnico.api.domain.vo.game;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class GameRestVo {
	
	@ApiModelProperty(value = "游戏ID")
	private String id;
	
	@ApiModelProperty(value = "所有者ID")
	private String ownerId;

	@ApiModelProperty(value = "所有者昵称")
	private String ownerNickname;

	@ApiModelProperty(value = "所有者头像")
	private String ownerHeadUrl;
	
	@ApiModelProperty(value = "游戏介绍")
	private String introduce;

	@ApiModelProperty(value = "封面图片地址")
	private String cover;

	@ApiModelProperty(value = "游戏标题")
	private String title;

	@ApiModelProperty(value = "游戏类型")
	private String gameTypeId;

	@ApiModelProperty(value = "游戏类型名称")
	private String gameTypeName;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	
	public String getOwnerNickname() {
		return ownerNickname;
	}

	public void setOwnerNickname(String ownerNickname) {
		this.ownerNickname = ownerNickname;
	}

	public String getOwnerHeadUrl() {
		return ownerHeadUrl;
	}

	public void setOwnerHeadUrl(String ownerHeadUrl) {
		this.ownerHeadUrl = ownerHeadUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public final String getOwnerId() {
		return ownerId;
	}

	public final void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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
