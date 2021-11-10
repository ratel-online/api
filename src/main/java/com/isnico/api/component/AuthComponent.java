package com.isnico.api.component;

import javax.servlet.http.HttpServletRequest;

import com.isnico.api.domain.bo.UserBo;
import com.isnico.api.domain.vo.ResponseCode;
import com.isnico.api.exception.TrapException;
import org.nico.noson.Noson;
import org.nico.noson.util.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
public class AuthComponent{

	@Autowired
	private CacheComponent cacheComponent;
	
	/**
	 * 获取当前登录用户
	 * 
	 * @return
	 * @throws TrapException
	 */
	public UserBo getUser() throws TrapException {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String authToken = request.getHeader("Trap-Auth-Token");
		String value = cacheComponent.get(authToken);
		if(StringUtils.isNotBlank(value)) {
			return Noson.convert(value, UserBo.class);
		}else {
			throw new TrapException(ResponseCode.ERROR_ON_LOGIN_INVALID);
		}
	}
	
	/**
	 * 获取当前用户ID
	 * 
	 * @return
	 * @throws TrapException
	 */
	public String getUserId() throws TrapException {
		return getUser().getId();
	}



}
