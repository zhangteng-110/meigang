package com.beautifulharborbackstage.controller.staff;

import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;
import com.beautifulharborbackstage.service.impl.staffServiceImpl;
import com.beautifulharborbackstage.service.impl.userServiceImpl;
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
@RequestMapping("/staff")
@Api("员工接口Api")
public class StaffController {

    @Autowired
    private staffServiceImpl staffServiceImpl;

    @ApiOperation("员工登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffDTO",value = "员工传输dto",required = true,paramType = "body")
    })
    @PostMapping("/login")
    @CrossOrigin
    public Object  login(@RequestBody StaffDTO staffDTO){
        return staffServiceImpl.login(staffDTO);
    }

    @ApiOperation("员工注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffDTO",value = "传输dto",required = true,paramType = "body")
    })
    @PostMapping("/register")
    @CrossOrigin
    public Object register(@RequestBody StaffDTO staffDTO){
        return staffServiceImpl.register(staffDTO);
    }

    @ApiOperation("查询所有员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffDTO",value = "传输dto",required = true,paramType = "body"),
            @ApiImplicitParam(name = "pageNum",value = "当前页",required = true,paramType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "总页数",required = true,paramType = "int")
    })
    @PostMapping("/selectAllStaff")
    @CrossOrigin
    public PageInfo selectAllStaff(@RequestBody StaffDTO staffDTO,
                                 @RequestParam(value = "pageNum", required = false) int pageNum,
                                 @RequestParam(value = "pageSize", required = false) int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<StaffReturnResultDTO> staffList = staffServiceImpl.selectAllStaff(staffDTO);
        PageInfo<?> info = new PageInfo<>(staffList);
        return info;
    }

    @ApiOperation("员工删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffId",value = "员工id",required = true,paramType = "int")
    })
    @PostMapping("/deleteStaffById")
    @CrossOrigin
    public Object deleteStaffById(@RequestParam(value = "staffId", required = true) int staffId){
        return staffServiceImpl.deleteStaffById(staffId);
    }

    @ApiOperation("员工信息回显")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffId",value = "员工id",required = true,paramType = "int")
    })
    @PostMapping("/selectStaffById")
    @CrossOrigin
    public Object selectStaffById(@RequestParam(value = "staffId", required = true) int staffId){
        return staffServiceImpl.selectStaffById(staffId);
    }

    @ApiOperation("员工信息编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffDTO",value = "传输dto",required = true,paramType = "body")
    })
    @PostMapping("/updateStaffDetail")
    @CrossOrigin
    public Object updateStaffDetail(@RequestBody StaffDTO staffDTO){
        return staffServiceImpl.updateStaffDetail(staffDTO);
    }

    @ApiOperation("获取员工数量")
    @GetMapping("/getStaffNumber")
    @CrossOrigin
    public Object getStaffNumber(){
        return staffServiceImpl.getStaffNumber();
    }

    @ApiOperation("员工状态编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffDTO",value = "传输dto",required = true,paramType = "body")
    })
    @PostMapping("/updateStatusById")
    @CrossOrigin
    public void updateStatusById(@RequestBody StaffDTO staffDTO){
        staffServiceImpl.updateStatusById(staffDTO);
    }
}
