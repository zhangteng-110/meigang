package com.beautifulharborbackstage.controller.role;

import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import com.beautifulharborbackstage.service.impl.RoleServiceImpl;
import com.beautifulharborbackstage.service.impl.staffServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 17:30 2020/12/3
 */
@RestController
@RequestMapping("/role")
@Api("员工职位角色接口Api")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @ApiOperation("查询所有职位角色")
    @GetMapping("/getRoleList")
    @CrossOrigin
    public Object getRoleList(){
        return roleService.getRoleList();
    }

}
