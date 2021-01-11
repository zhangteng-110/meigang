package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 17:35 2020/12/3
 */
public interface staffServiceImpl {
    public Object login(StaffDTO staffDTO);

    public List<StaffReturnResultDTO> selectAllStaff(StaffDTO staffDTO);

    public Object deleteStaffById(int staffId);

    public Object register(StaffDTO staffDTO);

    public int getStaffNumber();

    public StaffReturnResultDTO selectStaffById(int staffId);

    public Object updateStaffDetail(StaffDTO staffDTO);

    public void updateStatusById(StaffDTO staffDTO);
}
