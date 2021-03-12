package com.beautifulharborbackstage.pojo.dto;

import com.beautifulharborbackstage.pojo.po.UserSexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhangteng
 * @date: Created in 17:14 2020/12/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {
    private int staffId;
    private String accountNumber;
    private String password;
    private String staffName;
    private String staffCode;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private UserSexEnum staffSex;
    private int salary;
    private int staffPositionId;
    private String roleName;
    private int roleId;
    private int status;
    private int storefrontId;
}
