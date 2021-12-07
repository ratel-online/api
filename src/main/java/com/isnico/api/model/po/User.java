package com.isnico.api.model.po;

import java.util.Date;

import lombok.Data;
import org.nico.ourbatis.annotation.RenderPrimary;

@Data
public class User {
	
	@RenderPrimary
	private Long id;
	
	private String name;

	private String avatar;

	private Long score;

	private Long victory;

	private Long defeat;

	private String username;
	
	private String password;

	private Date createTime;
	
	private Date updateTime;

	private Integer deleted;

}
