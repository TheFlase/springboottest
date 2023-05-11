package com.wgc.springboottest.dao.db1;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wgc.springboottest.dto.AuthUserListDTO;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.vo.AuthUserListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
public interface AuthUserMapper extends BaseMapper<AuthUserDO> {

    int updateByAuthId(AuthUserDO authUserDO);

    List<AuthUserDO> selectAll();

    /**
     * 分页查询
     * @param page
     * @param param
     * @return
     */
    IPage<AuthUserListVO> listPages(IPage<AuthUserListVO> page, @Param("pageParam") AuthUserListDTO param);
}
