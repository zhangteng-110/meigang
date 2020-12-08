package com.beautifulharborbackstage.controller.user;

import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.service.impl.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangteng
 * @date: Created in 17:30 2020/12/3
 */
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userServiceImpl userServiceImpl;

    @PostMapping("/login")
    public UserDTO  login(@RequestParam(value = "username",required = true) String username,
                       @RequestParam(value = "password",required = true ) String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        return userServiceImpl.login(userDTO);
    }

}
