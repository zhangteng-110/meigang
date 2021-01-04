package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 17:35 2020/12/3
 */
public interface userServiceImpl {
    public Object login(UserDTO userDTO);

    public Object register(UserDTO userDTO);

    public List<UserPO> selectAllVip(UserDTO userDTO);

    public Object sendEmail();

    public Object vipChange(UserDTO userDTO);

    public Object deleteUserById(int userId);

    public UserPO selectUserById(int userId);

    public Object userEdit(UserDTO userDTO);

    public Object consumption(UserDTO userDTO);

    public Object recharge(UserDTO userDTO);

    public int getUserNumber();

    public int getUserVipNumber();
}
