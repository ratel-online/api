package com.isnico.api.service;

import com.isnico.api.consts.AppConst;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.exception.BusinessException;
import com.isnico.api.mapper.UserMapper;
import com.isnico.api.model.po.User;
import com.isnico.api.model.vo.UserResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserResp getUserInfo(Long id){
        User cond = new User();
        cond.setId(id);
        cond.setDeleted(AppConst.FALSE);
        User user = userMapper.selectEntity(cond);
        if (user == null){
            throw ResultCode.ERROR_ON_USER_NOT_EXIST.error();
        }
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        return userResp;
    }
}
