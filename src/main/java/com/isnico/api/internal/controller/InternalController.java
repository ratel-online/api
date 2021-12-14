package com.isnico.api.internal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isnico.api.enums.ResultCode;
import com.isnico.api.internal.service.InternalService;
import com.isnico.api.model.Result;
import com.isnico.api.model.vo.UserResp;
import com.isnico.api.model.vo.UserScoreListResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1/internal")
@Validated
@Api(tags = "对内接口")
public class InternalController {

    @Autowired
    private InternalService userService;

    @GetMapping("/userInfo/{userId}")
    @ApiOperation(value = "用户信息")
    public Result<UserResp> userInfo(@PathVariable("userId") Long userId) {
        return Result.ok(userService.getUserInfo(userId));
    }

    @PostMapping("/editScore")
    @ApiOperation(value = "修改用户积分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "int"),
            @ApiImplicitParam(name = "score", value = "分数", dataType = "int"),
            @ApiImplicitParam(name = "type", value = "类型 1:斗地主", dataType = "int")
    })
    public Result<Object> editScore(Long userId, Integer score, Integer type) {
        userService.editScore(userId, score, type);
        return Result.ok();
    }

    @GetMapping("/userScoreList")
    @ApiOperation(value = "用户积分历史记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "int"),
            @ApiImplicitParam(name = "type", value = "类型 1:斗地主", dataType = "int"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", dataType = "int")
    })
    public Result<PageInfo<UserScoreListResp>> userScoreList(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "pageIndex") Integer pageIndex,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        PageHelper.startPage(pageIndex, pageSize);
        List<UserScoreListResp> result = userService.userScoreList(userId, type);
        return Result.ok(new PageInfo<>(result));
    }

    @PostMapping("/addUserGameRecord")
    @ApiOperation(value = "新增玩家战绩")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "int"),
            @ApiImplicitParam(name = "gameId", value = "游戏ID", dataType = "int"),
            @ApiImplicitParam(name = "group", value = "队伍组", dataType = "int"),
            @ApiImplicitParam(name = "score", value = "分数变化", dataType = "int"),
    })
    public Result<PageInfo<UserScoreListResp>> addUserGameRecord(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "gameId") Long gameId,
            @RequestParam(value = "group") Integer group,
            @RequestParam(value = "score") Integer score
    ) {
        int i = userService.addUserGameRecord(userId,gameId,group,score);
        if (i==0){
            return Result.fail(ResultCode.ERROR);
        }
        return Result.ok();
    }

    @PostMapping("/addGame")
    @ApiOperation(value = "添加游戏记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "游戏类型", dataType = "int"),
            @ApiImplicitParam(name = "players", value = "玩家数量", dataType = "int"),
            @ApiImplicitParam(name = "roomId", value = "房间id", dataType = "long"),
            @ApiImplicitParam(name = "beginTime", value = "开始时间", dataType = "date"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "date"),
    })
    public Result<PageInfo<UserScoreListResp>> addGame(
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "players") Integer players,
            @RequestParam(value = "roomId") Long roomId,
            @RequestParam(value = "beginTime") Date beginTime,
            @RequestParam(value = "endTime") Date endTime
    ) {
        int i = userService.addGame(type,players,roomId,beginTime,endTime);
        if (i==0){
            return Result.fail(ResultCode.ERROR);
        }
        return Result.ok();
    }

}
