package com.wgc.springboottest.controller;

import com.wgc.springboottest.aspect.HasPermissions;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.service.AuthUserSerivce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@RestController
@RequestMapping("/user/")
public class UserController {
    @Resource
    private AuthUserSerivce authUserSerivce;

    @GetMapping("save")
    @HasPermissions("delete:commodity")
    public String listAllUser(){
        AuthUserDO userDO = new AuthUserDO(2L,"ZTN22245222","zt22202333","wgc",1,1L);
        authUserSerivce.saveOrUpdate(userDO);
        return "sucess";
    }



}
