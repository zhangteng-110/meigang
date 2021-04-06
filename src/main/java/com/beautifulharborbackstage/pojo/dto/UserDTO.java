package com.beautifulharborbackstage.pojo.dto;

import com.beautifulharborbackstage.pojo.po.UserSexEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangteng
 * @date: Created in 9:23 2020/12/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private int userId;
    private String username;
    private String password;
    private String userCode;
    private UserSexEnum userSex;
    private String email;
    private String phone;
    private String realName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int isVip;
    private int integral;
    private int money;
    private String cardNumber;
    private int projectId;
    private String consumptionStorefront;
    private String profilePath;
}
