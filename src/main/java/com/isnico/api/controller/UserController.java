package com.isnico.api.controller;

import com.isnico.api.annotation.Auth;
import com.isnico.api.model.Context;
import com.isnico.api.model.Result;
import com.isnico.api.model.vo.UserResp;
import com.isnico.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@Validated
@Api(tags = "User")
public class UserController {

    @Autowired
    private UserService userService;

    @Auth
    @GetMapping
    @ApiOperation(value = "用户信息")
    public Result<UserResp> userInfo(){
       return Result.ok(userService.getUserInfo(Context.get().getId()));
    }

}
