package com.beautifulharborbackstage.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhangteng
 * @date: Created in 13:30 2020/12/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResultDTO {
    private int transactionId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;
    private int userId;
    private int transactionMoney;
    private int transactionStatus;
    private String realName;
    private int accountAmount;
    private String transactionStorefront;
}
