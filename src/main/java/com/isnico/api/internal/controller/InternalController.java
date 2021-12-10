package com.isnico.api.internal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

}
