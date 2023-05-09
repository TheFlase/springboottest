package com.wgc.springboottest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/5/9
 **/
@Data
@TableName("dept")
public class DeptDO {

    private String dept;

    private String deptName;

}
