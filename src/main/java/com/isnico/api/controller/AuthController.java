package com.isnico.api.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.isnico.api.component.RedisUtil;
import com.isnico.api.consts.AppConst;
import com.isnico.api.model.po.User;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.model.Result;
import com.isnico.api.model.vo.LoginResp;
import com.isnico.api.util.StringUtil;
import io.swagger.annotations.Api;
import org.hibernate.validator.constraints.Length;
import com.isnico.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Locale;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@Validated
@Api(tags = "Auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@ApiOperation(value = "注册")
	@PostMapping("/register")
	public Result<LoginResp> register(
			@ApiParam(value = "账户", required = true) @Pattern(regexp = AppConst.REGEX_EMAIL) @RequestParam String username,
			@ApiParam(value = "密码", required = true) @Pattern(regexp = AppConst.REGEX_PWD, message = "密码需要由长度为6~15的字母和数字组成") @RequestParam String password,
			@ApiParam(value = "昵称", required = true) @Length(min = 3, max = 15) @Pattern(regexp = AppConst.REGEX_NAME, message = "昵称只能为字母、汉字或数字") @RequestParam String name,
			@ApiParam(value = "验证码", required = true) @RequestParam String code
			){
		return Result.ok(authService.register(username, password, name, code));
	}

	@ApiOperation(value = "登录")
	@PostMapping("/login")
	public Result<LoginResp> login(
			@ApiParam(value = "账户", required = true) @NotNull @RequestParam String username,
			@ApiParam(value = "密码", required = true) @NotNull @RequestParam String password
			){
		return Result.ok(authService.login(username, password));
	}

}
