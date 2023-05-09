package com.wgc.springboottest.service;

import com.wgc.springboottest.entity.AuthUserDO;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
public interface AuthUserSerivce {

    int saveOrUpdate(AuthUserDO userDO);

    /**
     * 查询用户信息
     * @param id
     * @param pwd
     * @return
     */
    AuthUserDO detail(Long id,String pwd);
}
