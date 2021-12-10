package com.isnico.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isnico.api.annotation.Auth;
import com.isnico.api.consts.AppConst;
import com.isnico.api.model.Context;
import com.isnico.api.model.Result;
import com.isnico.api.model.vo.GameRecordListResp;
import com.isnico.api.model.vo.UserResp;
import com.isnico.api.service.GameService;
import com.isnico.api.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/api/v1/getRecord")
@Validated
@Api(tags = "game")
public class GameController {


    @Autowired
    private GameService gameService;

    @Auth
    @GetMapping("/getRecord")
    @ApiOperation(value = "用户战绩")
    public Result<PageInfo<GameRecordListResp>> getRecord(
            @ApiParam(value = "队伍组", required = false) @RequestParam(value = "group",required = false) Integer group,
            @ApiParam(value = "页码", required = true) @RequestParam Integer pageIndex,
            @ApiParam(value = "每页数量", required = true) @RequestParam Integer pageSize
    ){
        PageHelper.startPage(pageIndex,pageSize);
        List<GameRecordListResp> list = gameService.getRecord(Context.get().getId(),group);
        return Result.ok(new PageInfo<>(list));
    }
}
