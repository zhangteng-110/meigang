package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.RoleReturnResultDTO;
import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    List<RoleReturnResultDTO> getRoleList();
}