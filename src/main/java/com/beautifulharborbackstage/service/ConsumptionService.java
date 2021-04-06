package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.ConsumptionMapper;
import com.beautifulharborbackstage.pojo.dto.ConsumptionDTO;
import com.beautifulharborbackstage.pojo.dto.ConsumptionResultDTO;
import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import com.beautifulharborbackstage.pojo.po.exception.ReturnException;
import com.beautifulharborbackstage.service.impl.ConsumptionServiceImpl;
import com.beautifulharborbackstage.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
//            consumptionDTO.setConsumptionStatus(1);
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

    @Override
    public Object selectMonthConsumptionMoney() {
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        final Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date date = cal.getTime();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date monthStartDate = cal.getTime();
        consumptionDTO.setStartDate(monthStartDate);
        final int next = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, next);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date monthEndDate = cal.getTime();
        consumptionDTO.setEndDate(monthEndDate);
        Object sum = consumptionMapper.selectConsumptionMoney(consumptionDTO);
        if(sum==null){
            return 0;
        }
        return sum;
    }

    @Override
    public Object selectTomorrowConsumptionMoney() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);//得到前一个天
        Date startDate = calendar.getTime();
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        consumptionDTO.setStartDate(startDate);
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);//得到前一个天
        Date endDate = calendar.getTime();
        consumptionDTO.setEndDate(endDate);
        Object sum = consumptionMapper.selectConsumptionMoney(consumptionDTO);
        if(sum==null){
            return 0;
        }
        return sum;
    }

    @Override
    public Object selectLastYearMoney() {
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        final Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        final int last = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date firstDayOfYear = cal.getTime();
        consumptionDTO.setStartDate(firstDayOfYear);
        final int next = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, next);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date lastDayOfYear = cal.getTime();
        consumptionDTO.setEndDate(lastDayOfYear);
        Object sum = consumptionMapper.selectConsumptionMoney(consumptionDTO);
        if(sum==null){
            return 0;
        }
        return sum;
    }

    @Override
    public Object selectEveryYearMoney() {
        Integer time[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        Object date[] = new Object[12];
        for (Integer i = 0;i < time.length;i++) {
            Date firstDayOfMonth = DateUtil.getFirstDayOfMonth(time[i]);
            Date lastDayOfMonth = DateUtil.getLastDayOfMonth(time[i]);
            ConsumptionDTO consumptionDTO = new ConsumptionDTO();
            consumptionDTO.setStartDate(firstDayOfMonth);
            consumptionDTO.setEndDate(lastDayOfMonth);
            Object sum = consumptionMapper.selectConsumptionMoney(consumptionDTO);
            if(sum == null){
                sum = 0;
            }
            date[i]=sum;
        }
        return date;
    }

    @Override
    public Object selectTodayConsumptionMoney() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);//得到前一个天
        Date startDate = calendar.getTime();
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        consumptionDTO.setStartDate(startDate);
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);//得到前一个天
        Date endDate = calendar.getTime();
        consumptionDTO.setEndDate(endDate);
        Object sum = consumptionMapper.selectConsumptionMoney(consumptionDTO);
        if(sum==null){
            return 0;
        }
        return sum;
    }
}
