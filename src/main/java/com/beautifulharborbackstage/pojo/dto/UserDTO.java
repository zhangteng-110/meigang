package com.beautifulharborbackstage.pojo.dto;

import com.beautifulharborbackstage.pojo.po.UserSexEnum;
import lombok.*;

import java.io.Serializable;

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
    private String realName;
}
