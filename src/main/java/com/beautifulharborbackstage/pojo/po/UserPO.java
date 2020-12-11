package com.beautifulharborbackstage.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhangteng
 * @date: Created in 16:19 2020/12/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    private int userId;
    private String userCode;
    private UserSexEnum userSex;
    private String realName;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int isVip;
    private int integral;
    private int money;
}
