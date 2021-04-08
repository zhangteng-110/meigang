package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.ConsumptionDTO;
import com.beautifulharborbackstage.pojo.dto.ConsumptionResultDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionResultDTO;
import com.beautifulharborbackstage.pojo.po.ConsumptionPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 13:27 2020/12/30
 */
@Mapper
@Repository
public interface ConsumptionMapper {
    void addConsumption(ConsumptionDTO consumptionDTO);

    List<ConsumptionResultDTO> selectConsumptionList(ConsumptionDTO consumptionDTO);

    List<ConsumptionResultDTO> selectSlotStorefront(ConsumptionPO consumptionPO);

    Object selectConsumptionMoney(ConsumptionDTO consumptionDTO);
}
