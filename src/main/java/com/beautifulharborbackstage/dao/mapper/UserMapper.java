package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /*int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/
    UserDTO login(UserDTO userDTO);

    void register(UserDTO userDTO);

    List<UserPO> selectAllVip(UserDTO userDTO);

    void registerDetails(UserDTO userDTO);

    void consumptionChange(UserDTO userPO);

    void vipChange(UserDTO userDTO);

    void deleteUserById(int userId);

    UserPO selectUserById(int userId);

    void userEdit(UserDTO userDTO);

    int getUserNumber();

    int getUserVipNumber();
}