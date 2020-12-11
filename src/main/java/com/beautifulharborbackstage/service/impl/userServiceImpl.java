package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 17:35 2020/12/3
 */
public interface userServiceImpl {
    public UserDTO login(UserDTO userDTO);

    public void register(UserDTO userDTO);

    public List<UserPO> selectAllVip(UserDTO userDTO);
}
