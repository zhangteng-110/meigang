package com.beautifulharborbackstage.controller.user;

import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;
import com.beautifulharborbackstage.service.impl.userServiceImpl;
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
    public UserDTO  login(@RequestBody UserDTO userDTO){
        return userServiceImpl.login(userDTO);
    }
    @ApiOperation("注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDTO",value = "传输dto",required = true,paramType = "body")
    })
    @PostMapping("/register")
    public void  register(@RequestBody UserDTO userDTO){
        userServiceImpl.register(userDTO);
    }
    @ApiOperation("查询所有会员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDTO",value = "传输dto",required = true,paramType = "body")
    })
    @PostMapping("/selectAllVip")
    public List<UserPO> selectAllVip(@RequestBody UserDTO userDTO){
        return userServiceImpl.selectAllVip(userDTO);
    }

}
