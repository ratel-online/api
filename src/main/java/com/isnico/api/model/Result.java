package com.isnico.api.model;

import com.isnico.api.enums.ResultCode;
import lombok.Data;

@Data
public class Result<T> {

	private int code;
	
	private String msg;
	
	private T data;

	public Result() { }

	public Result(ResultCode code) {
		this.code = code.getCode();
		this.msg = code.getMsg();
	}
	
	public Result(ResultCode code, T data) {
		this.code = code.getCode();
		this.msg = code.getMsg();
		this.data = data;
	}

	public static <T> Result<T> ok(T data){
		Result<T> result = new Result<T>(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	public static <T> Result<T> ok(){
		return new Result<T>(ResultCode.SUCCESS);
	}

	public static <T> Result<T> fail(ResultCode code){
		return  new Result<T>(code);
	}

	public static <T> Result<T> fail(int code, String msg){
		Result<T> result = new Result<T>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

}
