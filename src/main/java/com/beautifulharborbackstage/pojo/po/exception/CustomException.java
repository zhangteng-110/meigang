package com.beautifulharborbackstage.pojo.po.exception;

/**
 * @author zhangteng
 * @date: Created in 11:01 2021/2/19
 */
public class CustomException extends Exception {
    public CustomException(){
        super();
    }
    public CustomException(String message) {
        super(message);
    }
}
