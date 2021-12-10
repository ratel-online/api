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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 修改用户积分
     *
     * @param userId 用户ID
     * @param score  分数 增加传证书 减少传负数
     */
    @Transactional(rollbackFor = Exception.class)
    public void editScore(Long userId, Long score) {
        User cond = new User();
        cond.setId(userId);
        cond.setDeleted(AppConst.FALSE);
        User user = userMapper.selectEntity(cond);
        if (user == null) {
            throw ResultCode.ERROR_ON_USER_NOT_EXIST.error();
        }
        user.setScore(user.getScore() + score);
        userMapper.update(user);
    }
}
