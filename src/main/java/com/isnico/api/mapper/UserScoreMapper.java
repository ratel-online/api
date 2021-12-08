package com.isnico.api.mapper;

import com.isnico.api.model.po.UserScore;
import com.isnico.api.model.vo.UserScoreListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nico.ourbatis.mapper.SimpleMapper;

import java.util.List;

/**
 * Created by Eagga_Lo on 2021/12/8 15:33
 *
 * @author Eagga_Lo
 */
@Mapper
public interface UserScoreMapper extends SimpleMapper<UserScore, String> {

    List<UserScoreListResp> findByUserIdAndTypeOrderByCreatedTimeDesc(@Param("userId") Long userId, @Param("type") Integer type);


}
