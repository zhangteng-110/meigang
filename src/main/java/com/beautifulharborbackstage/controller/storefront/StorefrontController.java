package com.beautifulharborbackstage.controller.storefront;

import com.beautifulharborbackstage.pojo.dto.ServiceItemsDTO;
import com.beautifulharborbackstage.pojo.dto.StorefrontDTO;
import com.beautifulharborbackstage.service.impl.StorefrontServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangteng
 * @date: Created in 13:52 2021/3/11
 */
@RestController
@RequestMapping("/storefront")
@Api("店铺接口Api")
public class StorefrontController {

    @Autowired
    private StorefrontServiceImpl storefrontService;

    @ApiOperation("查询所有店铺")
    @GetMapping("/getAllStorefront")
    @CrossOrigin
    public Object getAllStorefront(){
        return storefrontService.getAllStorefront();
    }

    @ApiOperation("新增店铺")
    @PostMapping("/addStorefront")
    @CrossOrigin
    public Object addStorefront(@RequestBody StorefrontDTO storefrontDTO){
        return storefrontService.addStorefront(storefrontDTO);
    }

    @ApiOperation("修改店铺状态")
    @PostMapping("/updateStatusById")
    @CrossOrigin
    public Object updateStatusById(@RequestBody StorefrontDTO storefrontDTO){
        return storefrontService.updateStatusById(storefrontDTO);
    }

    @ApiOperation("查询所有营业店铺")
    @GetMapping("/getStorefront")
    @CrossOrigin
    public Object getStorefront(){
        return storefrontService.getStorefront();
    }

    @ApiOperation("店铺删除")
    @PostMapping("/deleteStorefrontById")
    @CrossOrigin
    public Object deleteStorefrontById(@RequestBody StorefrontDTO storefrontDTO){
        return storefrontService.deleteStorefrontById(storefrontDTO);
    }

    @ApiOperation("店铺编辑")
    @PostMapping("/updateStorefrontById")
    @CrossOrigin
    public Object updateStorefrontById(@RequestBody StorefrontDTO storefrontDTO){
        return storefrontService.updateStorefrontById(storefrontDTO);
    }

    @ApiOperation("店铺信息回显")
    @PostMapping("/getStorefrontById")
    @CrossOrigin
    public Object getStorefrontById(@RequestBody StorefrontDTO storefrontDTO){
        return storefrontService.getStorefrontById(storefrontDTO);
    }
}
