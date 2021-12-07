package com.isnico.api.enums;

import com.isnico.api.exception.BusinessException;

public enum ResultCode {

	SUCCESS(0, "请求成功"),
	ERROR_ON_TOKEN_INVALID(401, "无效令牌"),
	ERROR(500, "系统错误"),

	ERROR_ON_AUTH_CODE_AUTH_FAIL(100001, "验证码错误"),
	ERROR_ON_USER_NOT_EXIST(100002, "账户不存在"),
	ERROR_ON_USER_PASSWORD_ERROR(100003, "账号或密码错误"),
	;
	
	private int code;
	
	private String msg;

	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BusinessException error(){
		return new BusinessException(this);
	}

	public final int getCode() {
		return code;
	}

	public final void setCode(int code) {
		this.code = code;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}
	
}
