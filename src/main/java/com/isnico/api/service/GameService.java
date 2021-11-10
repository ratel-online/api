package com.isnico.api.service;

import java.util.ArrayList;
import java.util.List;

import com.isnico.api.domain.po.Game;
import com.isnico.api.domain.vo.game.GameRestVo;
import com.isnico.api.domain.vo.user.UserRestVo;
import com.isnico.api.mapper.GameMapper;
import com.isnico.api.utils.CommonUtils;
import org.apache.ibatis.annotations.Param;
import org.nico.ourbatis.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class GameService{
	
	@Autowired
	private GameMapper gameMapper;
	
	@Autowired
	private UserService userService;
	
	public Game selectById(String key) {
		return gameMapper.selectById(key);
	}

	public Game selectEntity(Game condition) {
		return gameMapper.selectEntity(condition);
	}

	public List<Game> selectList(Game condition) {
		return gameMapper.selectList(condition);
	}

	public long selectCount(Object condition) {
		return gameMapper.selectCount(condition);
	}

	public List<Game> selectPage(Page<Object> page) {
		return gameMapper.selectPage(page);
	}

	public String selectId(Game condition) {
		return gameMapper.selectId(condition);
	}

	public List<String> selectIds(Game condition) {
		return gameMapper.selectIds(condition);
	}

	public int insert(Game entity) {
		return gameMapper.insert(entity);
	}

	public int insertSelective(Game entity) {
		return gameMapper.insertSelective(entity);
	}

	public int insertBatch(List<Game> list) {
		return gameMapper.insertBatch(list);
	}

	public int update(Game entity) {
		return gameMapper.update(entity);
	}

	public int updateSelective(Game entity) {
		return gameMapper.updateSelective(entity);
	}

	public int updateBatch(List<Game> list) {
		return gameMapper.updateBatch(list);
	}

	public int delete(Game condition) {
		return gameMapper.delete(condition);
	}

	public int deleteById(String key) {
		return gameMapper.deleteById(key);
	}

	public int deleteBatch(List<String> list) {
		return gameMapper.deleteBatch(list);
	}
	
	/**
	 * 查询首页的游戏, 之后将会使用elasticsearch代替！
	 * 
	 * @param condition title条件搜索
	 * @return game 列表
	 */
	public List<Game> selectHomeGames(String condition){
		return gameMapper.selectHomeGames(condition);
	}
	
	/**
	 * 查询指定用户的游戏, 之后将会使用elasticsearch代替！
	 * 
	 * @param condition title条件搜索
	 * @param userId 用户id
	 * @return game 列表
	 */
	public List<Game> selectHomeGamesByUser(String condition, String userId){
		return gameMapper.selectHomeGamesByUser(condition, userId);
	}
	
	/**
	 * 获取简单的游戏信息，内部会查询用户信息与游戏信息合并
	 * 
	 * @param games 游戏列表
	 * @return list
	 */
	public List<GameRestVo> getGameRestInfo(List<Game> games){
		if(! CollectionUtils.isEmpty(games)) {
			final List<GameRestVo> gameRestVoList = new ArrayList<>(games.size());
			games.forEach(game -> {
				GameRestVo gameRestVo = CommonUtils.convertPovo(game, GameRestVo.class);
				UserRestVo userRestVo = userService.selectRestUseInfo(game.getOwnerId());
				if(userRestVo != null) {
					gameRestVo.setOwnerHeadUrl(userRestVo.getHeadUrl());
					gameRestVo.setOwnerNickname(userRestVo.getNickname());
				}
				gameRestVoList.add(gameRestVo);
			});
			return gameRestVoList;
		}else {
			return null;
		}
	}

}
