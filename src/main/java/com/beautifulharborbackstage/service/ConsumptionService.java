package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.ConsumptionMapper;
import com.beautifulharborbackstage.pojo.dto.ConsumptionDTO;
import com.beautifulharborbackstage.pojo.dto.ConsumptionResultDTO;
import com.beautifulharborbackstage.service.impl.ConsumptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
