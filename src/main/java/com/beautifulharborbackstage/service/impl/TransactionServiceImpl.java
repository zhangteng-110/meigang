package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.TransactionDTO;

/**
 * @author zhangteng
 * @date: Created in 14:55 2020/12/30
 */
public interface TransactionServiceImpl {
    Object selectMonthTransactionMoney();

    Object selectTomorrowTransactionMoney();

    Object selectLastYearMoney();

    Object selectEveryYearMoney();
}
