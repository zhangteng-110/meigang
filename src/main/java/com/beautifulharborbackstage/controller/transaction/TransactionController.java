package com.beautifulharborbackstage.controller.transaction;

import com.beautifulharborbackstage.pojo.dto.TransactionDTO;
import com.beautifulharborbackstage.pojo.dto.TransactionResultDTO;
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
@RequestMapping("/transaction")
@Api("交易信息接口Api")
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionServiceImpl;

    @ApiOperation("查询上月充值额")
    @GetMapping("/selectMonthTransactionMoney")
    @CrossOrigin
    public Object selectMonthTransactionMoney(){
        return transactionServiceImpl.selectMonthTransactionMoney();
    }

    @ApiOperation("查询昨日充值额")
    @GetMapping("/selectTomorrowTransactionMoney")
    @CrossOrigin
    public Object selectTomorrowTransactionMoney(){
        return transactionServiceImpl.selectTomorrowTransactionMoney();
    }

    @ApiOperation("查询当日充值额")
    @GetMapping("/selectTodayTransactionMoney")
    @CrossOrigin
    public Object selectTodayTransactionMoney(){
        return transactionServiceImpl.selectTodayTransactionMoney();
    }

    @ApiOperation("查询当年充值额")
    @GetMapping("/selectLastYearMoney")
    @CrossOrigin
    public Object selectLastYearMoney(){
        return transactionServiceImpl.selectLastYearMoney();
    }

    @ApiOperation("查询当年全年充值额")
    @GetMapping("/selectEveryYearMoney")
    @CrossOrigin
    public Object selectEveryYearMoney(){
        return transactionServiceImpl.selectEveryYearMoney();
    }

    @ApiOperation("查询所有充值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",required = true,paramType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "总页数",required = true,paramType = "int")
    })
    @PostMapping("/selectTransactionList")
    @CrossOrigin
    public PageInfo selectTransactionList(@RequestBody TransactionDTO transactionDTO,
                                        @RequestParam(value = "pageNum", required = false) int pageNum,
                                        @RequestParam(value = "pageSize", required = false) int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<TransactionResultDTO> list = transactionServiceImpl.selectTransactionList(transactionDTO);
        PageInfo<?> info = new PageInfo<>(list);
        return info;
    }

    @ApiOperation("排行榜")
    @GetMapping("/selectSlotStorefront")
    @CrossOrigin
    public Object selectSlotStorefront(){
        return transactionServiceImpl.selectSlotStorefront();
    }

}
