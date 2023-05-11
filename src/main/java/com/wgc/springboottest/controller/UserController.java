package com.wgc.springboottest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wgc.springboottest.dto.AuthUserListDTO;
import com.wgc.springboottest.vo.AuthUserListVO;
import com.wgc.springboottest.vo.ResultVo;
import com.wgc.springboottest.entity.AuthUserDO;
import com.wgc.springboottest.entity.DeptDO;
import com.wgc.springboottest.service.AuthUserSerivce;
import com.wgc.springboottest.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@RestController
@RequestMapping("/user/")
@Slf4j
@Validated
@Api(value = "用户管理",tags = "用户管理")
public class UserController {
    @Resource
    private AuthUserSerivce authUserSerivce;
    @Resource
    private DeptService deptService;


    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "用户信息创建或更新接口",httpMethod = "POST",notes = "这是用户创建或更新接口的详细说明。")
//    @HasPermissions("delete:commodity")
    public ResultVo saveOrUpdateUser(@RequestBody AuthUserDO userDO){
        authUserSerivce.saveOrUpdate(userDO);
        return ResultVo.success();
    }

    @GetMapping("list-users")
    public ResultVo<List<AuthUserDO>> listUsers(){
        List<AuthUserDO> userDOS = authUserSerivce.selectAll();
        return ResultVo.success(userDOS);
    }

    /**
     * 用户信息分页查询
     * @param listDTO
     * @return
     */
    @PostMapping("list-users-pages")
    public ResultVo<IPage<AuthUserListVO>> listUsersPages(@RequestBody AuthUserListDTO listDTO){
        IPage<AuthUserListVO> listIPage = authUserSerivce.listUsersPages(listDTO);
        return ResultVo.success(listIPage);
    }


    @GetMapping("detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",defaultValue = "1",paramType = "query",dataType="Long",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "hedonpassword",paramType = "query",dataType="String")
    })
    public ResultVo<AuthUserDO> detial(@RequestParam(value = "id") Long id, @RequestParam(value = "password",required = false) String pwd){
        AuthUserDO authUserDO = authUserSerivce.detail(id, pwd);
        return ResultVo.success(authUserDO);
    }

    @PostMapping("saveOrUpdateDept")
    @ApiOperation(value = "部门信息创建或更新接口")
//    @HasPermissions("delete:commodity")
    public ResultVo saveOrUpdateUserDept(@RequestBody DeptDO deptDO){
        return ResultVo.success();
    }

    @GetMapping("list-depts")
    public ResultVo<List<DeptDO>> listDepts(){
        List<DeptDO> deptDOS = deptService.listDepts();
        return ResultVo.success(deptDOS);
    }



}
