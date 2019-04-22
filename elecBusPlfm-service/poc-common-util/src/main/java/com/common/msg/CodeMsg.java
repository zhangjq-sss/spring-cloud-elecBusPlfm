package com.common.msg;

public class CodeMsg {
	
	private int code;
	private String msg;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(200, "success");
	public static CodeMsg FAIL = new CodeMsg(500, "请求发送异常");
	
	//auth模块
	public static CodeMsg POC_ERROR_USER_NOACCOUNT = new CodeMsg(601, "账号或token不存在");
	public static CodeMsg POC_ERROR_PARAMETER = new CodeMsg(602, "参数错误");
	public static CodeMsg POC_ERROR_USER_ACCOUNT_LOCKED = new CodeMsg(603, "账号被锁定");
	public static CodeMsg POC_ERROR_USER_ACCOUNT_STATUS_FALSE = new CodeMsg(604, "账号已经失效");
	public static CodeMsg POC_ERROR_USER_UNACCOUNT = new CodeMsg(605, "账号或密码错误");

	private CodeMsg( int code,String msg ) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
	
}
