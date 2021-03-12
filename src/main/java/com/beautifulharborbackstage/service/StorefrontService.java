package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.StorefrontMapper;
import com.beautifulharborbackstage.pojo.dto.StorefrontDTO;
import com.beautifulharborbackstage.pojo.dto.StorefrontResultDTO;
import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import com.beautifulharborbackstage.pojo.po.exception.ReturnException;
import com.beautifulharborbackstage.service.impl.StorefrontServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 13:50 2021/3/11
 */
@Service
public class StorefrontService implements StorefrontServiceImpl {
    @Autowired
    private StorefrontMapper storefrontMapper;
    @Override
    public List<StorefrontResultDTO> getAllStorefront() {
        return storefrontMapper.getAllStorefront();
    }

    @Override
    public Object addStorefront(StorefrontDTO storefrontDTO) {
        storefrontDTO.setStartDate(new Date());
        storefrontDTO.setStatus(1);
        try {
            storefrontMapper.addStorefront(storefrontDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnException(ErrorEnum.Fail,null);
        }
        return new ReturnException(ErrorEnum.SUCCESS,null);
    }

    @Override
    public Object updateStatusById(StorefrontDTO storefrontDTO) {
        try {
            storefrontMapper.updateStatusById(storefrontDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnException(ErrorEnum.Fail,null);
        }
        return new ReturnException(ErrorEnum.SUCCESS,null);
    }

    @Override
    public List<StorefrontResultDTO> getStorefront() {
        return storefrontMapper.getStorefront();
    }

    @Override
    public Object deleteStorefrontById(StorefrontDTO storefrontDTO) {
        try {
            storefrontMapper.deleteStorefrontById(storefrontDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnException(ErrorEnum.Fail,null);
        }
        return new ReturnException(ErrorEnum.SUCCESS,null);
    }

    @Override
    public StorefrontResultDTO getStorefrontById(StorefrontDTO storefrontDTO) {
        return storefrontMapper.getStorefrontById(storefrontDTO);
    }

    @Override
    public Object updateStorefrontById(StorefrontDTO storefrontDTO) {
        try {
            storefrontMapper.updateStorefrontById(storefrontDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnException(ErrorEnum.Fail,null);
        }
        return new ReturnException(ErrorEnum.SUCCESS,null);
    }
}
