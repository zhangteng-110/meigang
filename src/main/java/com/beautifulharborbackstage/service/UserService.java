package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.UserMapper;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.service.impl.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangteng
 * @date: Created in 17:35 2020/12/3
 */
@Service
public class UserService implements userServiceImpl {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDTO login(UserDTO userDTO) {
        UserDTO login = userMapper.login(userDTO);
        if(login != null){
            return login;
        }
        return null;
    }
}
