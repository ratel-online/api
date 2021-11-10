package com.isnico.api.exception;

import com.isnico.api.domain.vo.ResponseCode;

public class TrapException extends Exception{

	private static final long serialVersionUID = -4285570151529511652L;

	private String code;
	
	private String message;
	
	private ResponseCode responseCode;

	public TrapException(ResponseCode responseCode) {
		this.code = responseCode.getCode();
		this.message = responseCode.getMsg();
		this.responseCode = responseCode;
	}
	
	public TrapException() {
		super();
	}

	public TrapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TrapException(String message, Throwable cause) {
		super(message, cause);
	}

	public TrapException(String message) {
		super(message);
	}

	public TrapException(Throwable cause) {
		super(cause);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	
	
}
