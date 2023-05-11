package com.wgc.springboottest.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wgc.springboottest.dao.db1.AuthUserMapper;
import com.wgc.springboottest.dto.AuthUserListDTO;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.exception.BusinessException;
import com.wgc.springboottest.service.AuthUserSerivce;
import com.wgc.springboottest.vo.AuthUserListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@Service
@Slf4j
public class AuthUserServiceImpl implements AuthUserSerivce {
    @Resource
    private AuthUserMapper authUserMapper;

    @Override
    public List<AuthUserDO> selectAll() {
        return authUserMapper.selectAll();
    }

    @Override
    public IPage<AuthUserListVO> listUsersPages(AuthUserListDTO listDTO) {
        IPage iPage = authUserMapper.listPages(listDTO.getPage(), listDTO);
        return iPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrUpdate(AuthUserDO userDO) {
        if(ObjectUtil.isNotNull(userDO.getId())){
            AuthUserDO authUserDO = authUserMapper.selectById(userDO.getId());
            if(ObjectUtil.isNull(authUserDO)){
                throw new BusinessException("用户不存在，请核实后再试！用户ID："+userDO.getId());
            }
            int updateCount = authUserMapper.updateById(userDO);
            log.info("用户更新，入参：{}，更新结果：{}",JSONUtil.toJsonStr(userDO),updateCount);
        }else {
            int saveCount = authUserMapper.insert(userDO);
            log.info("新增用户，入参：{},影响条数：{}", JSONUtil.toJsonStr(userDO),saveCount);
        }
        return 1;
    }

    @Override
    public AuthUserDO detail(Long id, String pwd) {
        if(ObjectUtil.isNull(id)){
            throw new BusinessException("用户ID信息不能为空");
        }
//        Optional<AuthUserDO> authUserDO = authUserRepository.findById(id);
//        return authUserDO.orElse(null);
        return null;
    }
}
