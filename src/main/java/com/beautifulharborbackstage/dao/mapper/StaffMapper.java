package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    StaffReturnResultDTO login(StaffDTO staffDTO);

    List<StaffReturnResultDTO> selectAllStaff(StaffDTO staffDTO);

    void deleteStaffById(@Param("staffId")int staffId);

    void staffRegister(StaffDTO staffDTO);

    int getStaffNumber();

    StaffReturnResultDTO selectStaffById(@Param("staffId") int staffId);

    void updateStaffDetail(StaffDTO staffDTO);
}