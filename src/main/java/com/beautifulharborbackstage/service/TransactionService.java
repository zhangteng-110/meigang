package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.TransactionMapper;
import com.beautifulharborbackstage.pojo.dto.TransactionDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionResultDTO;
import com.beautifulharborbackstage.service.impl.TransactionServiceImpl;
import com.beautifulharborbackstage.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 14:54 2020/12/30
 */
@Service
public class TransactionService implements TransactionServiceImpl {
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public Object selectMonthTransactionMoney() {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date date = cal.getTime();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        Date monthStartDate = cal.getTime();
        final int next = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, next);
        Date monthEndDate = cal.getTime();
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setStartDate(monthStartDate);
        transactionDTO.setEndDate(monthEndDate);
        Object sum = transactionMapper.selectTransactionMoney(transactionDTO);
        if(sum==null){
            return 0;
        }
        return sum;
    }

    @Override
    public Object selectTomorrowTransactionMoney() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);//得到前一个天
        Date startDate = calendar.getTime();
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setStartDate(startDate);
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);//得到前一个天
        Date endDate = calendar.getTime();
        transactionDTO.setEndDate(endDate);
        Object sum = transactionMapper.selectTransactionMoney(transactionDTO);
        return sum;
    }

    @Override
    public Object selectLastYearMoney() {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        final int last = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        Date firstDayOfYear = cal.getTime();
        final int next = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, next);
        TransactionDTO transactionDTO = new TransactionDTO();
        Date lastDayOfYear = cal.getTime();
        transactionDTO.setStartDate(firstDayOfYear);
        transactionDTO.setEndDate(lastDayOfYear);
        Object sum = transactionMapper.selectTransactionMoney(transactionDTO);
        return sum;
    }

    @Override
    public Object selectEveryYearMoney() {
        Integer time[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        Object date[] = new Object[12];
        for (Integer i = 0;i < time.length;i++) {
            Date firstDayOfMonth = DateUtil.getFirstDayOfMonth(time[i]);
            Date lastDayOfMonth = DateUtil.getLastDayOfMonth(time[i]);
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setStartDate(firstDayOfMonth);
            transactionDTO.setEndDate(lastDayOfMonth);
            Object sum = transactionMapper.selectTransactionMoney(transactionDTO);
            if(sum == null){
                sum = 0;
            }
            date[i]=sum;
        }
        return date;
    }

    @Override
    public List<TransactionResultDTO> selectTransactionList(TransactionDTO transactionDTO) {
        return transactionMapper.selectTransactionList(transactionDTO);
    }

    @Override
    public List<TransactionResultDTO> selectSlotStorefront() {
        return transactionMapper.selectSlotStorefront();
    }
}
