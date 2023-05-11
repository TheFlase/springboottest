package com.wgc.springboottest.service;

import com.wgc.springboottest.entity.DeptDO;

import java.util.List;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/5/9
 **/
public interface DeptService {

    int saveOrUpdateUserDept(DeptDO deptDO);


    List<DeptDO> listDepts();
}
