package com.wgc.springboottest.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.wgc.springboottest.dao.AuthUserRepository;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.exception.BusinessException;
import com.wgc.springboottest.service.AuthUserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

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
    @Transactional(rollbackFor = Exception.class)
    public int saveOrUpdate(AuthUserDO userDO) {
        AuthUserDO save = authUserRepository.save(userDO);
        log.info("保存的用户信息：{}", JSONUtil.toJsonStr(save));
        return 1;
    }

    @Override
    public AuthUserDO detail(Long id, String pwd) {
        if(ObjectUtil.isNull(id)){
            throw new BusinessException("用户ID信息不能为空");
        }
        Optional<AuthUserDO> authUserDO = authUserRepository.findById(id);
        return authUserDO.orElse(null);
    }
}
