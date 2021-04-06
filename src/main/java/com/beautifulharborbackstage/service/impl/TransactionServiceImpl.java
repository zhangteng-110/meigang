package com.beautifulharborbackstage.service.impl;


import com.beautifulharborbackstage.pojo.dto.TransactionDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionResultDTO;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 14:55 2020/12/30
 */
public interface TransactionServiceImpl {
    Object selectMonthTransactionMoney();

    Object selectTomorrowTransactionMoney();

    Object selectTodayTransactionMoney();

    Object selectLastYearMoney();

    Object selectEveryYearMoney();

    List<TransactionResultDTO> selectTransactionList(TransactionDTO transactionDTO);

    List<TransactionResultDTO> selectSlotStorefront();
}
