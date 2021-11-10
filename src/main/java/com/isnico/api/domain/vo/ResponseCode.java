package com.isnico.api.domain.vo;

public enum ResponseCode {

	SUCCESS("000000", "请求成功"),
	ERROR("500000", "系统错误"),
	ERROR_ON_PROCESS("500001", "解析错误"),
	ERROR_ON_INSERT("500002", "插入失败"),
	ERROR_ON_LOGIN_INVALID("500003", "登录时效"),
	ERROR_ON_AUTH_CODE_NOT_EXIST("500004", "验证码失效"),
	ERROR_ON_AUTH_CODE_AUTH_FAIL("500005", "验证码错误"),
	ERROR_ON_USER_NOT_EXIST("500006", "账户不存在"),
	ERROR_ON_USER_PASSWORD_ERROR("500007", "账号或密码错误"),
	ERROR_ON_DATA_NOT_EXIST("500008", "数据不存在"),
	ERROR_ON_USER_IDENTITY_MISMATCH("500009", "用户身份不匹配"),
	ERROR_ON_UPDATE("500010", "更新失败"),
	;
	
	private String code;
	
	private String msg;

	private ResponseCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public final String getCode() {
		return code;
	}

	public final void setCode(String code) {
		this.code = code;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}
	
}
