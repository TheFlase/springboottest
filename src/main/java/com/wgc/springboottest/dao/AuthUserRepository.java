package com.wgc.springboottest.dao;

import com.wgc.springboottest.entity.AuthUserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
public interface AuthUserRepository extends CrudRepository<AuthUserDO,Long> {

}
