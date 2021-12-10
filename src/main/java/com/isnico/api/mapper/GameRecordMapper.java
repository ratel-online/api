package com.isnico.api.mapper;

import com.isnico.api.model.po.GameRecord;
import com.isnico.api.model.po.User;
import com.isnico.api.model.vo.GameRecordListResp;
import io.lettuce.core.dynamic.annotation.Param;
import org.nico.ourbatis.mapper.SimpleMapper;

import java.util.List;

public interface GameRecordMapper extends SimpleMapper<GameRecord, String> {

    List<GameRecordListResp> findByUserIdAndGroupOrderByCreatedTimeDesc(@Param("userId") Long userId,@Param("group") Integer group);
}
