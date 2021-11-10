package com.isnico.api.domain.po;

import java.math.BigDecimal;
import java.util.Date;

import org.nico.ourbatis.annotation.RenderPrimary;

public class UserAccount {
	
	@RenderPrimary
	private String id;
	
	private BigDecimal balance;

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
	
	public final BigDecimal getBalance() {
		return balance;
	}

	public final void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}
	
}
