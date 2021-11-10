package com.isnico.api.consts;

public interface CacheConst {
	
	//用户token缓存key
	String TRAP_USER_TOKEN = "trap:user:token@";
	
	//邮箱认证缓存key
	String TRAP_USER_REGISTER_AUTH_CODE = "trap:user:register:auth:code@";
	String TRAP_USER_LOGIN_AUTH_CODE = "trap:user:register:auth:code@";
	
	//用户登录密码错误次数
	String TRAP_USER_PASSWORD_FAIL_COUNT = "trap:user:login:error:count@";
}
