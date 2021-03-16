package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.TransactionDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionResultDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 13:27 2020/12/30
 */
@Mapper
@Repository
public interface TransactionMapper {
    void addTransaction(TransactionDTO transactionDTO);

    Object selectTransactionMoney(TransactionDTO transactionDTO);

    List<TransactionResultDTO> selectTransactionList(TransactionDTO transactionDTO);

    List<TransactionResultDTO> selectSlotStorefront();
}
