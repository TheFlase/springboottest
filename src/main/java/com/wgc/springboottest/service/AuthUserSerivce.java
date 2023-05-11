package com.wgc.springboottest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wgc.springboottest.dto.AuthUserListDTO;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.vo.AuthUserListVO;

import java.util.List;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
public interface AuthUserSerivce {

    int saveOrUpdate(AuthUserDO userDO);

    List<AuthUserDO> selectAll();

    /**
     * 用户信息分页查询
     * @param listDTO
     * @return
     */
    IPage<AuthUserListVO> listUsersPages(AuthUserListDTO listDTO);

    /**
     * 查询用户信息
     * @param id
     * @param pwd
     * @return
     */
    AuthUserDO detail(Long id,String pwd);
}
