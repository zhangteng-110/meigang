package com.beautifulharborbackstage.pojo.po.exception;

import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zhangteng
 * @date: Created in 14:22 2020/12/15
 */
@Data
public class ReturnException implements Serializable {
    private ErrorEnum errorEnum;
    private String errorCode;
    private String errorMessage;
    private String token;

    public ReturnException(ErrorEnum errorEnum,String token) {
//        super();
        this.errorEnum = errorEnum;
        this.errorCode = errorEnum.getErrorCode();
        this.errorMessage = errorEnum.getErrorMsg();
        this.token = token;
    }
}
