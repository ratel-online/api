package com.isnico.api.controller;

import java.util.concurrent.TimeUnit;

import javax.validation.constraints.Pattern;

import com.isnico.api.component.MailUtil;
import com.isnico.api.component.RedisUtil;
import com.isnico.api.consts.AppConst;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.model.Result;
import com.isnico.api.util.StringUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/mail")
@Validated
@Api(tags = "Mail")
public class MailController {

	@Autowired
	private MailUtil mailUtil;

	@Autowired
	private RedisUtil redisUtil;

	@ApiOperation(value = "发送邮件")
	@PostMapping
	public Result<?> send(
			@ApiParam(value = "账户", required = true)
			@Pattern(regexp = AppConst.REGEX_EMAIL, message = "不符合邮箱格式")
			@RequestParam String email
			){
		String code = StringUtil.random(AppConst.MAIL_AUTH_CODE_LENGTH);
		boolean success = mailUtil.sendSimpleMail(email, "NicoNicoNi! Register Auth Code Mail !", "Auth Code: " + code);
		if(success) {
			redisUtil.set(AppConst.USER_REGISTER_AUTH_CODE + email, code, 5L, TimeUnit.MINUTES);
			return Result.ok();
		}
		return Result.fail(ResultCode.ERROR);
	}

	
}
