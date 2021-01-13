package com.beautifulharborbackstage.controller.user;

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
@RequestMapping("/user")
@Api("用户接口Api")
public class userController {

    @Autowired
    private userServiceImpl userServiceImpl;

    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDTO",value = "传输dto",required = true,paramType = "body")
    })
    @PostMapping("/login")
    @CrossOrigin
    public Object  login(@RequestBody UserDTO userDTO){
        return userServiceImpl.login(userDTO);
    }

    @ApiOperation("注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDTO",value = "传输dto",required = true,paramType = "body")
    })
    @PostMapping("/register")
    @CrossOrigin
    public Object register(@RequestBody UserDTO userDTO){
        return userServiceImpl.register(userDTO);
    }

    @ApiOperation("查询所有会员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDTO",value = "传输dto",required = true,paramType = "body"),
            @ApiImplicitParam(name = "pageNum",value = "当前页",required = true,paramType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "总页数",required = true,paramType = "int")
    })
    @PostMapping("/selectAllVip")
    @CrossOrigin
    public PageInfo selectAllVip(@RequestBody UserDTO userDTO,
                                     @RequestParam(value = "pageNum", required = false) int pageNum,
                                     @RequestParam(value = "pageSize", required = false) int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserPO> userList = userServiceImpl.selectAllVip(userDTO);
        PageInfo<?> info = new PageInfo<>(userList);
        return info;
    }

    @ApiOperation("邮箱验证码")
    @PostMapping("/sendEmail")
    public Object sendEmail(){
        return userServiceImpl.sendEmail();
    };

    @ApiOperation("vip开通")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UserPO",value = "传输po",required = true,paramType = "body")
    })
    @PostMapping("/vipChange")
    @CrossOrigin
    public Object vipChange(@RequestBody UserDTO userDTO){
        return userServiceImpl.vipChange(userDTO);
    };

    @ApiOperation("用户删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true,paramType = "int")
    })
    @PostMapping("/deleteUserById")
    @CrossOrigin
    public Object deleteUserById(@RequestParam(value = "userId", required = true) int userId){
        return userServiceImpl.deleteUserById(userId);
    };

    @ApiOperation("用户信息回显")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true,paramType = "int")
    })
    @PostMapping("/selectUserById")
    @CrossOrigin
    public Object selectUserById(@RequestParam(value = "userId", required = true) int userId){
        return userServiceImpl.selectUserById(userId);
    };

    @ApiOperation("金额消费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UserPO",value = "传输po",required = true,paramType = "body")
    })
    @PostMapping("/consumption")
    @CrossOrigin
    public Object consumption(@RequestBody UserDTO userDTO){
        return userServiceImpl.consumption(userDTO);
    };

    @ApiOperation("金额充值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UserPO",value = "传输po",required = true,paramType = "body")
    })
    @PostMapping("/recharge")
    @CrossOrigin
    public Object recharge(@RequestBody UserDTO userDTO){
        return userServiceImpl.recharge(userDTO);
    };

    @ApiOperation("获取用户数量")
    @GetMapping("/getUserNumber")
    @CrossOrigin
    public Object getUserNumber(){
        return userServiceImpl.getUserNumber();
    }

    @ApiOperation("获取VIP数量")
    @GetMapping("/getUserVipNumber")
    @CrossOrigin
    public Object getUserVipNumber(){
        return userServiceImpl.getUserVipNumber();
    }
}
