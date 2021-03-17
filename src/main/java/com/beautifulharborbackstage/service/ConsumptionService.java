package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.ConsumptionMapper;
import com.beautifulharborbackstage.pojo.dto.ConsumptionDTO;
import com.beautifulharborbackstage.pojo.dto.ConsumptionResultDTO;
import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import com.beautifulharborbackstage.pojo.po.exception.ReturnException;
import com.beautifulharborbackstage.service.impl.ConsumptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 10:38 2021/1/6
 */
@Service
public class ConsumptionService implements ConsumptionServiceImpl {
    @Autowired
    private ConsumptionMapper consumptionMapper;

    @Override
    public List<ConsumptionResultDTO> selectConsumptionList(ConsumptionDTO consumptionDTO) {
        return consumptionMapper.selectConsumptionList(consumptionDTO);
    }

    @Override
    public Object addConsumption(ConsumptionDTO consumptionDTO) {
        try {
            consumptionDTO.setConsumptionStatus(1);
            consumptionDTO.setConsumptionDate(new Date());
            consumptionMapper.addConsumption(consumptionDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnException(ErrorEnum.Fail,null);
        }
        return new ReturnException(ErrorEnum.CONSUMPTION_SUCCESS,null);
    }

    @Override
    public List<ConsumptionResultDTO> selectSlotStorefront() {
        return consumptionMapper.selectSlotStorefront();
    }
}
