package com.beautifulharborbackstage.controller.project;

import com.beautifulharborbackstage.service.impl.ServiceItemsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangteng
 * @date: Created in 16:10 2021/1/11
 */
@RestController
@RequestMapping("/service")
@Api("项目接口Api")
public class ServiceItemsController {

    @Autowired
    private ServiceItemsServiceImpl serviceItemsService;

    @ApiOperation("查询男生项目")
    @GetMapping("/getManProjectList")
    @CrossOrigin
    public Object getManProjectList(){
        return serviceItemsService.getManProjectList();
    }

    @ApiOperation("查询女生项目")
    @GetMapping("/getWemanProjectList")
    @CrossOrigin
    public Object getWemanProjectList(){
        return serviceItemsService.getWemanProjectList();
    }
}
