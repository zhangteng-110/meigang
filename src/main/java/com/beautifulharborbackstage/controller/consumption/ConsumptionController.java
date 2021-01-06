package com.beautifulharborbackstage.controller.consumption;

import com.beautifulharborbackstage.pojo.dto.ConsumptionDTO;
import com.beautifulharborbackstage.pojo.dto.ConsumptionResultDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionResultDTO;
import com.beautifulharborbackstage.service.impl.ConsumptionServiceImpl;
import com.beautifulharborbackstage.service.impl.TransactionServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 15:05 2020/12/30
 */
@RestController
@RequestMapping("/consumption")
@Api("消费信息接口Api")
public class ConsumptionController {
    @Autowired
    private ConsumptionServiceImpl consumptionService;



    @ApiOperation("查询所有充值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",required = true,paramType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "总页数",required = true,paramType = "int")
    })
    @PostMapping("/selectConsumptionList")
    @CrossOrigin
    public PageInfo selectConsumptionList(@RequestBody ConsumptionDTO consumptionDTO,
                                        @RequestParam(value = "pageNum", required = false) int pageNum,
                                        @RequestParam(value = "pageSize", required = false) int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ConsumptionResultDTO> list = consumptionService.selectConsumptionList(consumptionDTO);
        PageInfo<?> info = new PageInfo<>(list);
        return info;
    }
}
