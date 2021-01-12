package com.beautifulharborbackstage.pojo.dto;

import com.beautifulharborbackstage.pojo.po.UserSexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangteng
 * @date: Created in 16:00 2021/1/11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceItemsResultDTO {
    private int projectId;
    private String projectName;
    private UserSexEnum sex;
}
