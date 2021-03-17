package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.ConsumptionDTO;
import com.beautifulharborbackstage.pojo.dto.ConsumptionResultDTO;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 10:39 2021/1/6
 */
public interface ConsumptionServiceImpl {
    List<ConsumptionResultDTO> selectConsumptionList(ConsumptionDTO consumptionDTO);

    Object addConsumption(ConsumptionDTO consumptionDTO);

    List<ConsumptionResultDTO> selectSlotStorefront();
}
