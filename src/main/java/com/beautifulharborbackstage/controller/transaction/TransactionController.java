package com.beautifulharborbackstage.controller.transaction;

import com.beautifulharborbackstage.service.impl.TransactionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("查询上月营业额")
    @GetMapping("/selectMonthTransactionMoney")
    @CrossOrigin
    public Object selectMonthTransactionMoney(){
        return transactionServiceImpl.selectMonthTransactionMoney();
    }

    @ApiOperation("查询昨日营业额")
    @GetMapping("/selectTomorrowTransactionMoney")
    @CrossOrigin
    public Object selectTomorrowTransactionMoney(){
        return transactionServiceImpl.selectTomorrowTransactionMoney();
    }

    @ApiOperation("查询当年营业额")
    @GetMapping("/selectLastYearMoney")
    @CrossOrigin
    public Object selectLastYearMoney(){
        return transactionServiceImpl.selectLastYearMoney();
    }

    @ApiOperation("查询当年全年营业额")
    @GetMapping("/selectEveryYearMoney")
    @CrossOrigin
    public Object selectEveryYearMoney(){
        return transactionServiceImpl.selectEveryYearMoney();
    }
}
