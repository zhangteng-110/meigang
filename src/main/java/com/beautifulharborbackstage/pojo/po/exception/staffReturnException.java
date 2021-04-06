package com.beautifulharborbackstage.pojo.po.exception;

import com.beautifulharborbackstage.pojo.po.ErrorEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangteng
 * @date: Created in 14:22 2020/12/15
 */
@Data
public class staffReturnException implements Serializable {
    private ErrorEnum errorEnum;
    private String errorCode;
    private String errorMessage;
    private String staffName;
    private String token;
    private String profilePath;

    public staffReturnException(ErrorEnum errorEnum, String token,String staffName,String profilePath) {
//        super();
        this.errorEnum = errorEnum;
        this.errorCode = errorEnum.getErrorCode();
        this.errorMessage = errorEnum.getErrorMsg();
        this.token = token;
        this.staffName = staffName;
        this.profilePath = profilePath;
    }
}
