package com.beautifulharborbackstage.controller.user;

import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.service.impl.userServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,paramType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,paramType = "String")
    })
    public UserDTO  login(@RequestParam(value = "username",required = true) String username,
                       @RequestParam(value = "password",required = true ) String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);
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

}
