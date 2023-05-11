package com.wgc.springboottest.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/5/10
 **/
@Data
@ApiModel
public class AuthUserListDTO implements Serializable {
    @ApiModelProperty("分页参数")
    private Page page;

    @ApiModelProperty(value = "工号")
    private String jobNumber;

}
