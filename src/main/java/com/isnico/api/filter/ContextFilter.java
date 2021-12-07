package com.isnico.api.filter;

import com.isnico.api.component.RedisUtil;
import com.isnico.api.consts.AppConst;
import com.isnico.api.model.Context;
import com.isnico.api.model.vo.LoginResp;
import com.isnico.api.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.nico.noson.Noson;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(filterName = "contextFilter", urlPatterns = "/*")
public class ContextFilter implements Filter {

    @Autowired
    private RedisUtil redisUtil;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.doIt((HttpServletRequest)request, (HttpServletResponse)response, chain);
    }

    protected void doIt(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String authorization = request.getHeader("Authorization");
            if (StringUtils.isNotBlank(authorization)){
                if (authorization.startsWith("Bearer ")){
                    authorization = authorization.substring(7);
                }
                String loginUserInfoJson = redisUtil.get(AppConst.USER_TOKEN + authorization);
                if (StringUtils.isNotBlank(loginUserInfoJson)){
                    LoginResp loginResp = Noson.convert(loginUserInfoJson, LoginResp.class);
                    Context ctx = new Context();
                    ctx.setId(loginResp.getId());
                    ctx.setUsername(loginResp.getUsername());
                    Context.set(ctx);
                }
            }
            String traceId = request.getHeader("TraceID");
            if (StringUtils.isNotBlank(traceId)){
                traceId = StringUtil.uuid();
            }
            MDC.put("traceId", traceId);
            chain.doFilter(request, response);
        } finally {
            Context.clear();
            MDC.clear();
        }

    }
}
