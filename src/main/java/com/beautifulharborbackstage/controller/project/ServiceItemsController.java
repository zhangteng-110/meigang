package com.beautifulharborbackstage.controller.project;

import com.beautifulharborbackstage.pojo.dto.ServiceItemsDTO;
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

    @ApiOperation("查询所有项目")
    @GetMapping("/getProjectList")
    @CrossOrigin
    public Object getProjectList(){
        return serviceItemsService.getProjectList();
    }

    @ApiOperation("修改服务项目状态")
    @PostMapping("/updateStatusById")
    @CrossOrigin
    public Object updateStatusById(@RequestBody ServiceItemsDTO serviceItemsDTO){
        return serviceItemsService.updateStatusById(serviceItemsDTO);
    }
    @ApiOperation("新增服务项目")
    @PostMapping("/addServiceItem")
    @CrossOrigin
    public Object addServiceItem(@RequestBody ServiceItemsDTO serviceItemsDTO){
        return serviceItemsService.addServiceItem(serviceItemsDTO);
    }

    @ApiOperation("修改服务项目名称")
    @PostMapping("/updateNameById")
    @CrossOrigin
    public Object updateNameById(@RequestBody ServiceItemsDTO serviceItemsDTO){
        return serviceItemsService.updateNameById(serviceItemsDTO);
    }


    @ApiOperation("项目信息回显")
    @PostMapping("/getProjectById")
    @CrossOrigin
    public Object getProjectById(@RequestBody ServiceItemsDTO serviceItemsDTO){
        return serviceItemsService.getProjectById(serviceItemsDTO);
    }

    @ApiOperation("项目信息删除")
    @PostMapping("/deleteProjectById")
    @CrossOrigin
    public Object deleteProjectById(@RequestBody ServiceItemsDTO serviceItemsDTO){
        return serviceItemsService.deleteProjectById(serviceItemsDTO);
    }
}
