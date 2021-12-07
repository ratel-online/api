package com.isnico.api.exception;

import javax.validation.ConstraintViolationException;

import com.isnico.api.enums.ResultCode;
import com.isnico.api.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result<?> errorHandler(Exception ex) {
		ex.printStackTrace();
		return new Result<>(ResultCode.ERROR);
	}
	
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public Result<?> errorHandler(BusinessException ex) {
		ex.printStackTrace();
		return new Result<>(ex.getResultCode());
	}
	
	@ResponseBody
	@ExceptionHandler(value = ConstraintViolationException.class)
	public Result<?> errorHandler(ConstraintViolationException ex) {
		ex.printStackTrace();
		return Result.fail(ResultCode.ERROR.getCode(), ex.getMessage());
	}

}
