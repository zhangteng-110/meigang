package com.beautifulharborbackstage.controller.notice;

import com.beautifulharborbackstage.pojo.dto.NoticeDTO;
import com.beautifulharborbackstage.pojo.dto.ServiceItemsDTO;
import com.beautifulharborbackstage.service.impl.NoticeServiceImpl;
import com.beautifulharborbackstage.service.impl.ServiceItemsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangteng
 * @date: Created in 16:10 2021/1/11
 */
@RestController
@RequestMapping("/notice")
@Api("公告接口Api")
public class NoticeController {

    @Autowired
    private NoticeServiceImpl noticeService;

    @ApiOperation("公告信息查询")
    @GetMapping("/selectNotice")
    @CrossOrigin
    public Object selectNotice(){
        return noticeService.selectNotice();
    }

    @ApiOperation("添加公告信息")
    @PostMapping("/addNotice")
    @CrossOrigin
    public Object addNotice(@RequestBody NoticeDTO noticeDTO){
        return noticeService.addNotice(noticeDTO);
    }
}
