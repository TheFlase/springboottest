package com.wgc.springboottest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 翁国超<zt22202>
 * @Description //
 * @Date 2023/5/10
 **/
@ApiModel
@Data
public class AuthUserListVO implements Serializable {
    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty(value = "部门编码")
    private String deptCode;

    @ApiModelProperty("用户工号")
    private String jobNumber;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户状态 0-停用 1-启用")
    private Integer accountState;

    @ApiModelProperty("创建人ID")
    private Long createdBy;
}
