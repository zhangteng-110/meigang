package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.NoticeMapper;
import com.beautifulharborbackstage.dao.mapper.StaffMapper;
import com.beautifulharborbackstage.pojo.dto.NoticeDTO;
import com.beautifulharborbackstage.pojo.dto.NoticeResultDTO;
import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import com.beautifulharborbackstage.pojo.po.exception.ReturnException;
import com.beautifulharborbackstage.pojo.po.exception.staffReturnException;
import com.beautifulharborbackstage.service.impl.NoticeServiceImpl;
import com.beautifulharborbackstage.service.impl.staffServiceImpl;
import com.beautifulharborbackstage.utils.JWTUtil;
import com.beautifulharborbackstage.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author zhangteng
 * @date: Created in 17:35 2020/12/3
 */
@Service
public class NoticeService  implements NoticeServiceImpl {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public List<NoticeResultDTO> selectNotice() {
        return noticeMapper.selectNotice();
    }

    @Override
    public Object addNotice(NoticeDTO noticeDTO) {
        try {
            String noticeText = noticeDTO.getNoticeText();
            String text = noticeText.substring(noticeText.indexOf("<p>") + 3, noticeText.lastIndexOf("</p>"));
            System.err.println("-------------------"+text.length());
            noticeDTO.setNoticeText(text);
            noticeDTO.setNoticeTime(new Date());
            noticeMapper.addNotice(noticeDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnException(ErrorEnum.Fail,null);
        }
        return new ReturnException(ErrorEnum.SUCCESS,null);
    }
}
