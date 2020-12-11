package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.UserMapper;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;
import com.beautifulharborbackstage.service.impl.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public void register(UserDTO userDTO) {
        userMapper.register(userDTO);
        userMapper.registerDetails(userDTO);
    }

    @Override
    public List<UserPO> selectAllVip(UserDTO userDTO) {
        return userMapper.selectAllVip(userDTO);
    }
}
