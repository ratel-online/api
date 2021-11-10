package com.isnico.api.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.isnico.api.aop.AuthAop;
import com.isnico.api.domain.vo.ResponseCode;
import com.isnico.api.domain.vo.ResponseVo;
import com.isnico.api.domain.vo.game.GameFullVo;
import com.isnico.api.domain.vo.game.GameRestVo;
import com.isnico.api.domain.vo.user.UserRestVo;
import com.isnico.api.utils.CommonUtils;
import org.nico.noson.util.string.StringUtils;
import com.isnico.api.component.AuthComponent;
import com.isnico.api.domain.po.Game;
import com.isnico.api.exception.TrapException;
import com.isnico.api.service.GameService;
import com.isnico.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/game")
@Validated
public class GameController {

	@Autowired
	private GameService gameService;

	@Autowired
	private TrapComponent trapComponent;
	
	@Autowired
	private AuthComponent authComponent;
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "获取指定游戏信息")
	@GetMapping("/{id}")
	public ResponseVo<GameFullVo> getGame(
			@ApiParam(value = "游戏id", required = true) @NotNull @PathVariable String id
			) {
		Game game = gameService.selectById(id);
		
		GameFullVo gameFullVo = CommonUtils.convertPovo(game, GameFullVo.class);
		UserRestVo userRestVo = userService.selectRestUseInfo(game.getOwnerId());
		if(userRestVo != null) {
			gameFullVo.setOwnerHeadUrl(userRestVo.getHeadUrl());
			gameFullVo.setOwnerNickname(userRestVo.getNickname());
		}
		
		return new ResponseVo<GameFullVo>(ResponseCode.SUCCESS, gameFullVo);
	}
	
	@ApiOperation(value = "添加游戏")
	@AuthAop.AuthBy
	@PostMapping("/")
	public ResponseVo<GameFullVo> addGame(@RequestBody GameFullVo gameVo) throws TrapException{
		ResponseCode code = null;
		GameFullVo gameFullVo = null;
		
		String result = trapComponent.trapGrammerProcess(gameVo.getContent());
		if(StringUtils.isNotBlank(result)) {
			Game game = CommonUtils.convertPovo(gameVo, Game.class);
			game.setId(CommonUtils.getUUID());
			game.setContent(result);
			game.setOwnerId(authComponent.getUserId());
			
			int modify = gameService.insert(game);
			if(modify == 1) {
				gameFullVo = CommonUtils.convertPovo(game, GameFullVo.class);
				UserRestVo userRestVo = userService.selectRestUseInfo(game.getOwnerId());
				if(userRestVo != null) {
					gameFullVo.setOwnerHeadUrl(userRestVo.getHeadUrl());
					gameFullVo.setOwnerNickname(userRestVo.getNickname());
				}
				
				code = ResponseCode.SUCCESS;
			}else {
				code = ResponseCode.ERROR_ON_INSERT;
			}
		}else {
			code = ResponseCode.ERROR_ON_PROCESS;
		}
		return new ResponseVo<GameFullVo>(code, gameFullVo);
	}
	
	@ApiOperation(value = "更新游戏")
	@AuthAop.AuthBy
	@PutMapping("/")
	public ResponseVo<GameFullVo> updateGame(@RequestBody GameFullVo gameVo) throws TrapException{
		ResponseCode code = null;
		GameFullVo gameFullVo = null;
		
		Game game = gameService.selectById(gameVo.getId());
		String userId = authComponent.getUserId();
		if(game != null) {
			if(game.getOwnerId().equalsIgnoreCase(userId)) {
				String result = trapComponent.trapGrammerProcess(gameVo.getContent());
				if(StringUtils.isNotBlank(result)) {
					game.setCover(gameVo.getCover());
					game.setGameTypeId(gameVo.getGameTypeId());
					game.setGameTypeName(gameVo.getGameTypeName());
					game.setContent(result);
					game.setIntroduce(gameVo.getIntroduce());
					game.setTitle(gameVo.getTitle());
					
					int modify = gameService.update(game);
					if(modify == 1) {
						gameFullVo = CommonUtils.convertPovo(game, GameFullVo.class);
						UserRestVo userRestVo = userService.selectRestUseInfo(game.getOwnerId());
						if(userRestVo != null) {
							gameFullVo.setOwnerHeadUrl(userRestVo.getHeadUrl());
							gameFullVo.setOwnerNickname(userRestVo.getNickname());
						}
						
						code = ResponseCode.SUCCESS;
					}else {
						code = ResponseCode.ERROR_ON_UPDATE;
					}
				}else {
					code = ResponseCode.ERROR_ON_PROCESS;
				}
			}else {
				code = ResponseCode.ERROR_ON_USER_IDENTITY_MISMATCH;
			}
		}else {
			code = ResponseCode.ERROR_ON_DATA_NOT_EXIST;
		}
		return new ResponseVo<GameFullVo>(code, gameFullVo);
	}
	
	@ApiOperation(value = "获取主页游戏列表")
	@GetMapping("/")
	public ResponseVo<List<GameRestVo>> list(
			@ApiParam(value = "查询条件(gameID或title)", required = false) @RequestParam(required = false) String condition,
			@ApiParam(value = "默认为1，页号，从1开始", required = false) @RequestParam(required = false, defaultValue = "1") int page,
			@ApiParam(value = "默认为20，页大小，即每页存放多少条资产信息", required = false) @RequestParam(required = false, defaultValue = "20") int pagesize
			) throws TrapException{
		ResponseCode code = null;
		
		Page<Game> pageResult = PageHelper.startPage(page, pagesize);
		gameService.selectHomeGames(condition);
		
		List<Game> games = pageResult.getResult();
		List<GameRestVo> result = gameService.getGameRestInfo(games);
		
		code = ResponseCode.SUCCESS;
		return new ResponseVo<List<GameRestVo>>(code, result, pageResult.getTotal());
	}
	
	@ApiOperation(value = "获取开发者的游戏列表")
	@GetMapping("/owner")
	public ResponseVo<List<GameRestVo>> listOfUser(
			@ApiParam(value = "查询条件(gameId或title)", required = false) @RequestParam(required = false) String condition,
			@ApiParam(value = "用户Id", required = false) @RequestParam(required = false) String userId,
			@ApiParam(value = "默认为1，页号，从1开始", required = false) @RequestParam(required = false, defaultValue = "1") int page,
			@ApiParam(value = "默认为20，页大小，即每页存放多少条资产信息", required = false) @RequestParam(required = false, defaultValue = "20") int pagesize
			) throws TrapException{
		ResponseCode code = null;
		
		Page<Game> pageResult = PageHelper.startPage(page, pagesize);
		gameService.selectHomeGamesByUser(condition, userId);
		
		List<Game> games = pageResult.getResult();
		List<GameRestVo> result = gameService.getGameRestInfo(games);
		
		code = ResponseCode.SUCCESS;
		return new ResponseVo<List<GameRestVo>>(code, result, pageResult.getTotal());
	}
}
