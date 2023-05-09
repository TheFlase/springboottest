package com.wgc.springboottest.controller;

import com.wgc.springboottest.dto.response.ResultVo;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.service.AuthUserSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@RestController
@RequestMapping("/user/")
@Slf4j
@Validated
@Api(value = "用户管理",tags = "用户管理")
public class UserController {
    @Resource
    private AuthUserSerivce authUserSerivce;

    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "用户信息创建或更新接口",httpMethod = "POST",notes = "这是用户创建或更新接口的详细说明。")
//    @HasPermissions("delete:commodity")
    public ResultVo saveOrUpdateUser(@RequestBody AuthUserDO userDO){
        authUserSerivce.saveOrUpdate(userDO);
        return ResultVo.success();
    }


    @GetMapping("detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",defaultValue = "1",paramType = "query",dataType="Long",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "hedonpassword",paramType = "query",dataType="String")
    })
    public ResultVo<AuthUserDO> detial(@RequestParam(value = "id") Long id, @RequestParam(value = "password",required = false) String pwd){
        AuthUserDO authUserDO = authUserSerivce.detail(id, pwd);
        return ResultVo.success(authUserDO);
    }



}
