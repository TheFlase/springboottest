package com.wgc.springboottest.service.impl;

import cn.hutool.json.JSONUtil;
import com.wgc.springboottest.aspect.HasPermissions;
import com.wgc.springboottest.dao.AuthUserRepository;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.service.AuthUserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@Service
@Slf4j
public class AuthUserServiceImpl implements AuthUserSerivce {
    @Resource
    private AuthUserRepository authUserRepository;


    @Override
    @HasPermissions("delete:commodity")
    public int saveOrUpdate(AuthUserDO userDO) {
        AuthUserDO save = authUserRepository.save(userDO);
        log.info("保存的用户信息：{}", JSONUtil.toJsonStr(save));
        return 1;
    }
}
