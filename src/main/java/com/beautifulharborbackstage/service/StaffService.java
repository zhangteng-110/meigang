package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.StaffMapper;
import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import com.beautifulharborbackstage.pojo.po.exception.ReturnException;
import com.beautifulharborbackstage.pojo.po.exception.staffReturnException;
import com.beautifulharborbackstage.service.impl.staffServiceImpl;
import com.beautifulharborbackstage.utils.JWTUtil;
import com.beautifulharborbackstage.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author zhangteng
 * @date: Created in 17:35 2020/12/3
 */
@Service
public class StaffService implements staffServiceImpl {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Object login(StaffDTO staffDTO) {
        StaffReturnResultDTO login = staffMapper.login(staffDTO);
        String token = null;
        if(login!=null){
            String userid = RedisUtils.INSTANCE.get(String.valueOf(login.getStaffId()));
            if(userid == null){
                String username = staffDTO.getAccountNumber();
                String password = staffDTO.getPassword();
                int staffId = login.getStaffId();
                try {
                    token = JWTUtil.createToken(String.valueOf(staffId), username, password);
                    RedisUtils.INSTANCE.set(String.valueOf(staffId),token);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new staffReturnException(ErrorEnum.E_20011,null,null);
            }
        }else {
            return new staffReturnException(ErrorEnum.E_10010,null,null);
        }
        return new staffReturnException(ErrorEnum.LOGIN_SUCCESS,token,login.getStaffName());
    }

    @Override
    public List<StaffReturnResultDTO> selectAllStaff(StaffDTO staffDTO) {
        return staffMapper.selectAllStaff(staffDTO);
    }

    @Override
    public Object deleteStaffById(int staffId) {
        staffMapper.deleteStaffById(staffId);
        return new staffReturnException(ErrorEnum.DELETE_USER_SUCCESS,null,null);
    }

    @Override
    public Object register(StaffDTO staffDTO) {
        StaffReturnResultDTO staff = staffMapper.login(staffDTO);
        if(staff==null){
            staff.setStartDate(new Date());
            staffMapper.staffRegister(staffDTO);
            return new staffReturnException(ErrorEnum.REGISTER_SUCCESS,null,null);
        }
        return new staffReturnException(ErrorEnum.E_10011,null,null);
    }

    @Override
    public int getStaffNumber() {
        return staffMapper.getStaffNumber();
    }


}
