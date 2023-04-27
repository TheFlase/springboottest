package com.wgc.springboottest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@Entity
@Table(name = "auth_user")
@Data
@ToString
@AllArgsConstructor
public class AuthUserDO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    private String deptCode;

    private String jobNumber;

    private String userName;

    private Integer accountState;

    private Long createdBy;

    protected AuthUserDO() {
    }
}
