package com.wgc.springboottest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
@ApiModel("AuthUserDO-用户信息实体DO")
public class AuthUserDO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty("用户ID")
    private Long id;

    @NotEmpty(message = "部门编码不能为空！")
    @ApiModelProperty(value = "部门编码",required = true)
    private String deptCode;

    @ApiModelProperty("用户工号")
    private String jobNumber;

    private String userName;

    private Integer accountState;

    private Long createdBy;

    protected AuthUserDO() {
    }
}
