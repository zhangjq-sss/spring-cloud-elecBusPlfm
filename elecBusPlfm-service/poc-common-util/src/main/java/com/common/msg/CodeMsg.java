package com.common.msg;

public class CodeMsg {
	
	private int code;
	private String msg;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(200, "success");
	public static CodeMsg FAIL = new CodeMsg(500, "系统异常");
	public static CodeMsg POC_ERROR_PARAMETER = new CodeMsg(600, "参数有误");
	
	//auth模块10001
	public static CodeMsg POC_ERROR_USER_NOACCOUNT = new CodeMsg(10001, "账号或token不存在");
	public static CodeMsg POC_ERROR_USER_ACCOUNT_LOCKED = new CodeMsg(10002, "账号被锁定");
	public static CodeMsg POC_ERROR_USER_ACCOUNT_STATUS_FALSE = new CodeMsg(10003, "账号已经失效");
	public static CodeMsg POC_ERROR_USER_UNACCOUNT = new CodeMsg(10004, "账号或密码错误");
	public static CodeMsg POC_ERROR_USER_NOMOBILE = new CodeMsg(10005, "手机号不存在");
	public static CodeMsg POC_ERROR_MOBILECODE = new CodeMsg(10006, "手机验证码有误");
	
	//order模块20001
	
	//product模块30001
	public static CodeMsg POC_ERROR_STOCK_LOW = new CodeMsg(30001, "当前库存不允许添加这么多");
	
	//payment模块40001
	
	//promotion模块50001

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
