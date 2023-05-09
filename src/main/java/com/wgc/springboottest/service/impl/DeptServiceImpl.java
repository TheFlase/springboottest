package com.wgc.springboottest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wgc.springboottest.dao.DeptMapper;
import com.wgc.springboottest.entity.DeptDO;
import com.wgc.springboottest.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/5/9
 **/
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<DeptDO> listDepts() {
        QueryWrapper<DeptDO> queryWrapper = new QueryWrapper<>();
        List<DeptDO> deptDOS = null;
        deptDOS = deptMapper.selectList(queryWrapper);
        return deptDOS;
    }
}
