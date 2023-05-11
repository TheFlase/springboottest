package com.wgc.springboottest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@Data
@ToString
@AllArgsConstructor
@ApiModel("AuthUserDO-用户信息实体DO")
@TableName("auth_user")
public class AuthUserDO {
    @ApiModelProperty("用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotEmpty(message = "部门编码不能为空！")
    @ApiModelProperty(value = "部门编码",required = true)
    @TableField(value = "dept_code")
    private String deptCode;

    @ApiModelProperty("用户工号")
    @TableField(value = "job_number")
    private String jobNumber;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "account_state")
    private Integer accountState;

    @TableField(value = "created_by")
    private Long createdBy;
}
