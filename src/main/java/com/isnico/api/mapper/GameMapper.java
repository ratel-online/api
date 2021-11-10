package com.isnico.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nico.ourbatis.mapper.SimpleMapper;
import com.isnico.api.domain.po.Game;

public interface GameMapper extends SimpleMapper<Game, String>{

	public List<Game> selectHomeGames(@Param("condition") String condition);
	
	public List<Game> selectHomeGamesByUser(@Param("condition") String condition, @Param("userId") String userId);
}
