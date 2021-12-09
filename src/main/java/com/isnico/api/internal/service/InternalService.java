package com.isnico.api.internal.service;

import com.isnico.api.consts.AppConst;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.mapper.UserMapper;
import com.isnico.api.mapper.UserScoreMapper;
import com.isnico.api.model.po.User;
import com.isnico.api.model.vo.UserResp;
import com.isnico.api.model.vo.UserScoreListResp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eagga
 */
@Service
@RequiredArgsConstructor
public class InternalService {

    private final UserMapper userMapper;
    private final UserScoreMapper userScoreMapper;

    public UserResp getUserInfo(Long id) {
        User cond = new User();
        cond.setId(id);
        cond.setDeleted(AppConst.FALSE);
        User user = userMapper.selectEntity(cond);
        if (user == null) {
            throw ResultCode.ERROR_ON_USER_NOT_EXIST.error();
        }
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        return userResp;
    }

    /**
     * 用户积分历史记录
     *
     * @param id   用户ID
     * @param type 积分流水类型
     * @return 积分记录
     */
    public List<UserScoreListResp> userScoreList(Long id, Integer type) {
        return userScoreMapper.findByUserIdAndTypeOrderByCreatedTimeDesc(id, type);
    }
}
