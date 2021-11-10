package com.isnico.api.domain.vo.game;

import java.util.Arrays;

import io.swagger.annotations.ApiModelProperty;

public class GrammerProcessResultGameVo {

	@ApiModelProperty(value = "标记")
	private String mark;
	
	@ApiModelProperty(value = "父标记")
	private String parent;
	
	@ApiModelProperty(value = "类型")
	private int type;
	
	@ApiModelProperty(value = "对话内容")
	private String content;
	
	@ApiModelProperty(value = "子标记")
	private String[] childs;

	public final String getMark() {
		return mark;
	}

	public final void setMark(String mark) {
		this.mark = mark;
	}

	public final String getParent() {
		return parent;
	}

	public final void setParent(String parent) {
		this.parent = parent;
	}

	public final int getType() {
		return type;
	}

	public final void setType(int type) {
		this.type = type;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public final String[] getChilds() {
		return childs;
	}

	public final void setChilds(String[] childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "GrammerProcessResultGameVo [mark=" + mark + ", parent=" + parent + ", type=" + type + ", content="
				+ content + ", childs=" + Arrays.toString(childs) + "]";
	}
	
}
