package com.wgc.springboottest.service;

import com.wgc.springboottest.entity.AuthUserDO;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
public interface AuthUserSerivce {
    int saveOrUpdate(AuthUserDO userDO);
}
