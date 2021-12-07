package com.isnico.api.service;

import com.isnico.api.component.RedisUtil;
import com.isnico.api.consts.AppConst;
import com.isnico.api.enums.EmailMsgTypeEnums;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.exception.BusinessException;
import com.isnico.api.mapper.UserMapper;
import com.isnico.api.model.po.User;
import com.isnico.api.model.vo.LoginResp;
import com.isnico.api.util.StringUtil;
import org.nico.noson.Noson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserService userService;

    public LoginResp register(String username, String password, String name, String code) {
        String authCode = String.valueOf(redisUtil.get(EmailMsgTypeEnums.REGISTERED.getCode() + username));
        if (!Objects.equals(authCode.toLowerCase(Locale.ROOT), code.toLowerCase(Locale.ROOT))) {
            throw new BusinessException(ResultCode.ERROR_ON_AUTH_CODE_AUTH_FAIL);
        }
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(StringUtil.md5(username + "@" + password));
        userMapper.insertSelective(user);
        return setLoginInfo(user);
    }

    public LoginResp login(String username, String password) {
        User cond = new User();
        cond.setUsername(username);
        User user = userMapper.selectEntity(cond);
        if (user == null) {
            throw new BusinessException(ResultCode.ERROR_ON_USER_NOT_EXIST);
        }
        if (user.getPassword().equalsIgnoreCase(StringUtil.md5(StringUtil.md5(username + "@" + password)))) {
            throw new BusinessException(ResultCode.ERROR_ON_USER_PASSWORD_ERROR);
        }
        return setLoginInfo(user);
    }

    public LoginResp setLoginInfo(User user) {
        LoginResp resp = new LoginResp();
        resp.setId(user.getId());
        resp.setName(user.getName());
        resp.setScore(user.getScore());
        resp.setUsername(user.getUsername());
        resp.setToken(StringUtil.random(48));
        redisUtil.set(AppConst.USER_TOKEN + resp.getToken(), Noson.reversal(resp), 15, TimeUnit.DAYS);
        return resp;
    }

    /**
     * 忘记密码
     *
     * @param username 用户名
     * @param password 新密码
     * @param code     邮箱验证码
     */
    @Transactional(rollbackFor = Exception.class)
    public String forgetPassword(String username, String password, String code) {
        String authCode = String.valueOf(redisUtil.get(EmailMsgTypeEnums.FORGET_PASSWORD.getCode() + username));
        if (!Objects.equals(authCode.toLowerCase(Locale.ROOT), code.toLowerCase(Locale.ROOT))) {
            throw new BusinessException(ResultCode.ERROR_ON_AUTH_CODE_AUTH_FAIL);
        }
        // TODO
        User user = userService.getUserByUsername(username);
        if(user == null){
            throw new BusinessException(ResultCode.ERROR_ON_USER_NOT_EXIST);
        }
        user.setPassword(StringUtil.md5(username + "@" + password));
        int i = userMapper.updateSelective(user);
        if(i == 1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }





}
