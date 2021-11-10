package com.isnico.api.aop;

import javax.validation.ConstraintViolationException;

import com.isnico.api.domain.vo.ResponseCode;
import com.isnico.api.domain.vo.ResponseVo;
import com.isnico.api.exception.TrapException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResponseVo<?> errorHandler(Exception ex) {
		ex.printStackTrace();
		return new ResponseVo<>(ResponseCode.ERROR);
	}
	
	@ResponseBody
	@ExceptionHandler(value = TrapException.class)
	public ResponseVo<?> errorHandler(TrapException ex) {
		ex.printStackTrace();
		return new ResponseVo<>(ex.getResponseCode());
	}
	
	@ResponseBody
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseVo<?> errorHandler(ConstraintViolationException ex) {
		ex.printStackTrace();
		return new ResponseVo<>(ResponseCode.ERROR).setMsg(ex.getMessage());
	}

}
