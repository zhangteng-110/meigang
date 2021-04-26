package com.beautifulharborbackstage.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhangteng
 * @date: Created in 17:53 2021/4/12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeDTO {
    private int noticeId;
    private String noticeText;
    private Date noticeTime;
}
