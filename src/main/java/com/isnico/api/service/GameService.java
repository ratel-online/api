package com.isnico.api.service;

import com.isnico.api.enums.GameGroupEnums;
import com.isnico.api.mapper.GameRecordMapper;
import com.isnico.api.model.vo.GameRecordListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRecordMapper gameRecordMapper;

    /**
     * 查询战绩
     * @param userId 用户id
     * @param group 队伍组，为空查全部
     * @see GameGroupEnums
     * @return 结果列表
     */
    public List<GameRecordListResp> getRecord(Long userId, Integer group) {

        return gameRecordMapper.findByUserIdAndGroupOrderByCreatedTimeDesc(userId,group);
    }
}
