package com.wgc.springboottest.dao.db2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wgc.springboottest.entity.DeptDO;

import java.util.List;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/5/9
 **/

public interface DeptMapper extends BaseMapper<DeptDO> {

    List<DeptDO> selectAll();

}
