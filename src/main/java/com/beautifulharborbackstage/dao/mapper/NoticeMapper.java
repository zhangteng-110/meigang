package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.NoticeDTO;
import com.beautifulharborbackstage.pojo.dto.NoticeResultDTO;
import com.beautifulharborbackstage.pojo.dto.UserDTO;
import com.beautifulharborbackstage.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
   List<NoticeResultDTO> selectNotice();

   void addNotice(NoticeDTO noticeDTO);
}