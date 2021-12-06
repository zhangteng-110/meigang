package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.ConsumptionMapper;
import com.beautifulharborbackstage.dao.mapper.TransactionMapper;
import com.beautifulharborbackstage.dao.mapper.UserMapper;
import com.beautifulharborbackstage.pojo.dto.ConsumptionDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionDTO;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import com.beautifulharborbackstage.pojo.po.UserPO;
import com.beautifulharborbackstage.pojo.po.exception.ReturnException;
import com.beautifulharborbackstage.service.impl.userServiceImpl;
import com.beautifulharborbackstage.utils.JWTUtil;
import com.beautifulharborbackstage.utils.MailUtil;
import com.beautifulharborbackstage.utils.RedisUtils;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 17:35 2020/12/3
 */
@Service
public class UserService implements userServiceImpl {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private ConsumptionMapper consumptionMapper;

    @Override
    public ReturnException login(UserDTO userDTO) {
        UserDTO login = userMapper.login(userDTO);
        String token = null;
        if(login!=null){
            token = RedisUtils.INSTANCE.get(login.getUserCode());
            if(token == null){
                String username = userDTO.getUsername();
                String password = userDTO.getPassword();
                String userCode = login.getUserCode();
                String profilePath = login.getProfilePath();
                try {
                    token = JWTUtil.createToken(userCode, username, password,profilePath);
                    RedisUtils.INSTANCE.set(userCode,token,1000*60*60*24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new ReturnException(ErrorEnum.E_20011,null);
            }
        }else {
            return new ReturnException(ErrorEnum.E_10010,null);
        }
        return new ReturnException(ErrorEnum.LOGIN_SUCCESS,token);
    }

    @Override
    @Transactional
    public ReturnException register(UserDTO userDTO) {
        UserDTO user = userMapper.login(userDTO);
        String token = null;
        if(user==null){
            userMapper.register(userDTO);
            Date startDate = new Date();
            userDTO.setStartDate(startDate);
            userMapper.registerDetails(userDTO);
            String userCode = userDTO.getUserCode();
            String username = userDTO.getUsername();
            String password = userDTO.getPassword();
            try {
                token = JWTUtil.createToken(userCode, username, password,null);
                RedisUtils.INSTANCE.set(userCode,token);
            } catch (Exception e) {
                e.printStackTrace();
                return new ReturnException(ErrorEnum.E_10011,null);
            }
        }else {
            return new ReturnException(ErrorEnum.E_10009,null);
        }
        return new ReturnException(ErrorEnum.REGISTER_SUCCESS,token);
    }

    @Override
    public List<UserPO> selectAllVip(UserDTO userDTO) {
        return userMapper.selectAllVip(userDTO);
    }

    @Override
    public Object sendEmail() {
        try {
            MailUtil.send_mail("910547570@qq.com","【美港】验证码");
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ReturnException(ErrorEnum.SEND_EMAIL_FAIL,null);
        }
        return new ReturnException(ErrorEnum.SEND_EMAIL_SUCCESS,null);
    }

    @Override
    public Object vipChange(UserDTO userDTO) {
        int isVip = userDTO.getIsVip();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date newDate = sdf.parse(sdf.format(new Date()));
            userDTO.setEndDate(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userMapper.vipChange(userDTO);
        if(isVip == 1){
            return new ReturnException(ErrorEnum.VIP_CHANGE,null);
        }
        return new ReturnException(ErrorEnum.VIP_CANCELLATION,null);
    }

    @Override
    public Object deleteUserById(int userId) {
        userMapper.deleteUserById(userId);
        return new ReturnException(ErrorEnum.DELETE_USER_SUCCESS,null);
    }

    @Override
    public UserPO selectUserById(int userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public Object userEdit(UserDTO userDTO) {
        userMapper.userEdit(userDTO);
        return new ReturnException(ErrorEnum.EDIT_USER_SUCCESS,null);
    }

    @Override
    @Transactional
    public Object consumption(UserDTO userDTO) {
        UserPO userPO = userMapper.selectUserById(userDTO.getUserId());
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        consumptionDTO.setUserId(userDTO.getUserId());
        consumptionDTO.setConsumptionDate(new Date());
        consumptionDTO.setConsumptionMoney(userDTO.getMoney());
        consumptionDTO.setConsumptionStatus(1);
        consumptionDTO.setIntegral(userDTO.getMoney());
        consumptionDTO.setProjectId(userDTO.getProjectId());
        consumptionDTO.setConsumptionStorefront(userDTO.getConsumptionStorefront());
        consumptionDTO.setAccountAmount(userPO.getMoney()-userDTO.getMoney());
        userDTO.setIntegral(userPO.getIntegral()+userDTO.getMoney());
        userDTO.setMoney(userPO.getMoney()-userDTO.getMoney());
        userMapper.consumptionChange(userDTO);
        consumptionMapper.addConsumption(consumptionDTO);
        return new ReturnException(ErrorEnum.CONSUMPTION_SUCCESS,null);
    }

    @Override
    @Transactional
    public Object recharge(UserDTO userDTO) {
        UserPO userPO = userMapper.selectUserById(userDTO.getUserId());
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setUserId(userDTO.getUserId());
        transactionDTO.setTransactionDate(new Date());
        transactionDTO.setTransactionStatus(1);
        transactionDTO.setTransactionMoney(userDTO.getMoney());
        transactionDTO.setTransactionStorefront(userDTO.getConsumptionStorefront());
        transactionDTO.setAccountAmount(userPO.getMoney()+userDTO.getMoney());
        userDTO.setMoney(userPO.getMoney()+userDTO.getMoney());
        userMapper.consumptionChange(userDTO);
        transactionMapper.addTransaction(transactionDTO);
        return new ReturnException(ErrorEnum.RECHARGE_SUCCESS,null);
    }

    @Override
    public int getUserNumber() {
        return userMapper.getUserNumber();
    }

    @Override
    public int getUserVipNumber() {
        return userMapper.getUserVipNumber();
    }
}
