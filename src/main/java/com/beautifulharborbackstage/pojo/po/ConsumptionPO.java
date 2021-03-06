package com.beautifulharborbackstage.pojo.po;

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
public class ConsumptionPO {
    private int consumptionId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date consumptionDate;
    private int userId;
    private int consumptionMoney;
    private int consumptionStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int integral;
    private String realName;
    private int projectId;
    private String consumptionStorefront;
    private int accountAmount;
}
