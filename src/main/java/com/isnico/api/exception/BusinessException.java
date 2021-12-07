package com.isnico.api.exception;

import com.isnico.api.enums.ResultCode;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -4285570151529511652L;

	private int code;
	
	private String msg;
	
	private ResultCode resultCode;

	public BusinessException(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
		this.resultCode = resultCode;
	}
	
	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
