package com.isnico.api.filter;

import com.isnico.api.annotation.Auth;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.exception.BusinessException;
import com.isnico.api.model.Context;
import com.isnico.api.model.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthFilter {

    @Pointcut("@annotation(auth)")
    public void authPath(Auth auth){}

    @Around(value="authPath(auth)", argNames = "point,auth")
    public Object aroundMethod(ProceedingJoinPoint point, Auth auth){
        Object result;
        try {
            if (Context.get() == null){
                result = Result.fail(ResultCode.ERROR_ON_TOKEN_INVALID);
            }else{
                result = point.proceed();
            }
        } catch(BusinessException e) {
            result = Result.fail(e.getResultCode());
        } catch (Throwable e) {
            result = Result.fail(ResultCode.ERROR.getCode(), e.getMessage());
        }
        return result;
    }
}
