package com.beautifulharborbackstage.controller.consumption;

import com.beautifulharborbackstage.pojo.dto.*;
import com.beautifulharborbackstage.service.impl.ConsumptionServiceImpl;
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

    @ApiOperation("金额消费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ConsumptionDTO",value = "传输po",required = true,paramType = "body")
    })
    @PostMapping("/addConsumption")
    @CrossOrigin
    public Object addConsumption(@RequestBody ConsumptionDTO consumptionDTO){
        return consumptionService.addConsumption(consumptionDTO);
    }

    @ApiOperation("排行榜")
    @GetMapping("/selectSlotStorefront")
    @CrossOrigin
    public Object selectSlotStorefront(){
        return consumptionService.selectSlotStorefront();
    }

    @ApiOperation("查询上月营业额")
    @GetMapping("/selectMonthConsumptionMoney")
    @CrossOrigin
    public Object selectMonthConsumptionMoney(){
        return consumptionService.selectMonthConsumptionMoney();
    }

    @ApiOperation("查询昨日营业额")
    @GetMapping("/selectTomorrowConsumptionMoney")
    @CrossOrigin
    public Object selectTomorrowConsumptionMoney(){
        return consumptionService.selectTomorrowConsumptionMoney();
    }

    @ApiOperation("查询今日营业额")
    @GetMapping("/selectTodayConsumptionMoney")
    @CrossOrigin
    public Object selectTodayConsumptionMoney(){
        return consumptionService.selectTodayConsumptionMoney();
    }

    @ApiOperation("查询当年营业额")
    @GetMapping("/selectLastYearMoney")
    @CrossOrigin
    public Object selectLastYearMoney(){
        return consumptionService.selectLastYearMoney();
    }

    @ApiOperation("查询当年全年营业额")
    @GetMapping("/selectEveryYearMoney")
    @CrossOrigin
    public Object selectEveryYearMoney(){
        return consumptionService.selectEveryYearMoney();
    }
}
