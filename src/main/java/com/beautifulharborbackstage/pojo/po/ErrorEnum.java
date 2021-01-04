package com.beautifulharborbackstage.pojo.po;

public enum ErrorEnum {
	/*
	 * 错误信息
	 * */
	E_400("400", "请求处理异常，请稍后再试"),
	E_500("500", "请求方式有误,请检查 GET/POST"),
	E_501("501", "请求路径不存在"),
	E_502("502", "权限不足"),
	E_10008("10008", "角色删除失败,尚有用户属于此角色"),
	E_10009("10009", "账户已存在"),
	E_10010("10010", "账号或密码错误，请重试"),
	E_10011("10011", "账户创建失败，请重试"),

	E_20011("20011", "登陆已过期,请重新登陆"),

	E_90003("90003", "缺少必填参数"),
	LOGIN_SUCCESS("200", "登录成功"),
	REGISTER_SUCCESS("200", "注册成功"),
	SEND_EMAIL_SUCCESS("2000", "验证码发送成功"),
	SEND_EMAIL_FAIL("4000", "验证码发送失败"),

	VIP_CHANGE("200","以成功为该用户开通会员"),
	VIP_CANCELLATION("500","会员已注销"),

	DELETE_USER_SUCCESS("200","删除成功"),

	EDIT_USER_SUCCESS("200","编辑成功"),

	CONSUMPTION_SUCCESS("200","消费成功"),

	RECHARGE_SUCCESS("200","充值成功");

	private String errorCode;

	private String errorMsg;

	ErrorEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public String toString() {
		return "[" + this.errorCode + "," + this.errorMsg + "]";
	}

}