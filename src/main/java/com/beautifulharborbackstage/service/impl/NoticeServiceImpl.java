package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.NoticeDTO;
import com.beautifulharborbackstage.pojo.dto.NoticeResultDTO;
import com.beautifulharborbackstage.pojo.dto.RoleReturnResultDTO;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 10:28 2021/1/8
 */
public interface NoticeServiceImpl {
    public List<NoticeResultDTO> selectNotice();

    Object addNotice(NoticeDTO noticeDTO);
}
