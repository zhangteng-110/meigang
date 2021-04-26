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
import org.springframework.transaction.annotation.Transactional;

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
            token = RedisUtils.INSTANCE.get(String.valueOf(login.getStaffId()));
            if(token == null){
                String username = staffDTO.getAccountNumber();
                String password = staffDTO.getPassword();
                int staffId = login.getStaffId();
                String profilePath = login.getProfilePath();
                try {
                    token = JWTUtil.createToken(String.valueOf(staffId), username, password,profilePath);
                    RedisUtils.INSTANCE.set(String.valueOf(staffId),token,1000*60*60*24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new staffReturnException(ErrorEnum.E_20011,null,null,null);
            }
        }else {
            return new staffReturnException(ErrorEnum.E_10010,null,null,null);
        }
        return new staffReturnException(ErrorEnum.LOGIN_SUCCESS,token,login.getStaffName(),login.getProfilePath());
    }

    @Override
    public List<StaffReturnResultDTO> selectAllStaff(StaffDTO staffDTO) {
        return staffMapper.selectAllStaff(staffDTO);
    }

    @Override
    public Object deleteStaffById(int staffId) {
        staffMapper.deleteStaffById(staffId);
        return new staffReturnException(ErrorEnum.DELETE_USER_SUCCESS,null,null,null);
    }

    @Override
    public Object register(StaffDTO staffDTO) {
        StaffReturnResultDTO staff = staffMapper.login(staffDTO);
        if(staff==null){
            staffDTO.setStartDate(new Date());
            staffMapper.staffRegister(staffDTO);
            return new staffReturnException(ErrorEnum.REGISTER_SUCCESS,null,null,null);
        }
        return new staffReturnException(ErrorEnum.E_10011,null,null,null);
    }

    @Override
    public int getStaffNumber() {
        return staffMapper.getStaffNumber();
    }

    @Override
    public StaffReturnResultDTO selectStaffById(int staffId) {
        return staffMapper.selectStaffById(staffId);
    }

    @Override
    public Object updateStaffDetail(StaffDTO staffDTO) {
        staffMapper.updateStaffDetail(staffDTO);
        return new staffReturnException(ErrorEnum.EDIT_USER_SUCCESS,null,null,null);
    }

    @Override
    public void updateStatusById(StaffDTO staffDTO) {
        if (staffDTO.getStatus()!=1){
            staffDTO.setEndDate(new Date());
        }else{
            staffDTO.setStartDate(new Date());
        }
        staffMapper.updateStatusById(staffDTO);
    }


}
