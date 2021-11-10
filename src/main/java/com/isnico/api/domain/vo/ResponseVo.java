package com.isnico.api.domain.vo;

public class ResponseVo<T> {

	private String code;
	
	private String msg;
	
	private T data;
	
	private Long total;
	
	public ResponseVo(ResponseCode code) {
		this.code = code.getCode();
		this.msg = code.getMsg();
	}
	
	public ResponseVo(ResponseCode code, T data) {
		this.code = code.getCode();
		this.msg = code.getMsg();
		this.data = data;
	}
	
	public ResponseVo(ResponseCode code, T data, long total) {
		this.code = code.getCode();
		this.msg = code.getMsg();
		this.data = data;
		this.total = total;
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

	public final ResponseVo<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public final T getData() {
		return data;
	}

	public final void setData(T data) {
		this.data = data;
	}

	public final Long getTotal() {
		return total;
	}

	public final void setTotal(Long total) {
		this.total = total;
	}
	
}
