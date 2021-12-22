package com.isnico.api.internal.service;

import com.isnico.api.consts.AppConst;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.enums.UserScoreTypeEnums;
import com.isnico.api.mapper.GameMapper;
import com.isnico.api.mapper.GameRecordMapper;
import com.isnico.api.mapper.UserMapper;
import com.isnico.api.mapper.UserScoreMapper;
import com.isnico.api.model.po.Game;
import com.isnico.api.model.po.GameRecord;
import com.isnico.api.model.po.User;
import com.isnico.api.model.po.UserScore;
import com.isnico.api.model.vo.UserResp;
import com.isnico.api.model.vo.UserScoreListResp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Eagga
 */
@Service
@RequiredArgsConstructor
public class InternalService {

    private final UserMapper userMapper;
    private final UserScoreMapper userScoreMapper;
    private final GameRecordMapper gameRecordMapper;
    private final GameMapper gameMapper;

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
     * @param type   类型
     */
    @Transactional(rollbackFor = Exception.class)
    public void editScore(Long userId, Integer score, Integer type) {
        User user = userMapper.findUserLock(userId);
        if (user == null) {
            throw ResultCode.ERROR_ON_USER_NOT_EXIST.error();
        }
        user.setScore(user.getScore() + score);
        userMapper.update(user);

        UserScore userScore = new UserScore();
        userScore.setCreatedTime(LocalDateTime.now());
        userScore.setUpdateTime(LocalDateTime.now());
        userScore.setUserId(userId);
        userScore.setScore(score);
        userScore.setType(type);
        userScore.setDesc(Objects.requireNonNull(UserScoreTypeEnums.getByValue(type)).getDesc());
        userScoreMapper.insert(userScore);
    }

    public int addUserGameRecord(Long userId, Long gameId, Integer group, Integer score) {
        GameRecord gameRecord = new GameRecord();
        gameRecord.setUserId(userId);
        gameRecord.setGameId(gameId);
        gameRecord.setGroup(group);
        gameRecord.setScore(score);
        return gameRecordMapper.insertSelective(gameRecord);
    }

    public int addGame(Integer type, Integer players, Long roomId, Date beginTime, Date endTime) {
        Game game = new Game();
        game.setType(type);
        game.setPlayers(players);
        game.setRoom_id(roomId);
        game.setBegin_time(beginTime);
        game.setEnd_time(endTime);
        return gameMapper.insertSelective(game);
    }
}
