package com.beautifulharborbackstage.pojo.po;

/**
 * @author zhangteng
 * @date: Created in 11:01 2020/12/7
 */
public enum UserSexEnum {
    MAN("1","男"),
    WEMAN("0","女");

    private String code;

    private String msg;

    UserSexEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
