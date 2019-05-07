package com.common.msg;

public class CodeMsg {
	
	private int code;
	private String msg;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(200, "success");
	public static CodeMsg FAIL = new CodeMsg(500, "对不起，系统异常");
	public static CodeMsg POC_ERROR_PARAMETER = new CodeMsg(600, "参数有误");
	
	//用户模块出错4001
	
	
	//gateway错误码5001
	public static CodeMsg POC_ERROR_VARIFYTOKEN_AUTH = new CodeMsg(5001, "校验token请求出错-auth");
	public static CodeMsg POC_ERROR_LOGIN_AUTH = new CodeMsg(5002, "登录请求出错-auth");
	public static CodeMsg POC_ERROR_LOGOUT_AUTH = new CodeMsg(5003, "用户退出请求出错-auth");
	public static CodeMsg POC_ERROR_SENDCODE_AUTH = new CodeMsg(5004, "发送短信验证码请求出错-auth");
	public static CodeMsg POC_ERROR_VARIFYCODE_AUTH = new CodeMsg(5005, "校验手机验证码请求出错-auth");
	
	public static CodeMsg POC_ERROR_REQUEST_OTHER_SERVICE = new CodeMsg(9999, "调用其他服务异常");
	public static CodeMsg POC_ERROR_TOKEN_EXPIRE = new CodeMsg(8888, "TOKEN 无效");
	public static CodeMsg POC_ERROR_LIMIT = new CodeMsg(7777, "对不起，当前人数太多了，请重试");
	
	public static CodeMsg POC_ERROR_ZUUL = new CodeMsg(6666, "对不起，当前请求人太多了，请稍后重试");
	
	//auth模块10001
	public static CodeMsg POC_ERROR_USER_NOACCOUNT = new CodeMsg(10001, "账号或token不存在");
	public static CodeMsg POC_ERROR_USER_ACCOUNT_LOCKED = new CodeMsg(10002, "账号被锁定");
	public static CodeMsg POC_ERROR_USER_ACCOUNT_STATUS_FALSE = new CodeMsg(10003, "账号已经失效");
	public static CodeMsg POC_ERROR_USER_UNACCOUNT = new CodeMsg(10004, "账号或密码错误");
	public static CodeMsg POC_ERROR_USER_NOMOBILE = new CodeMsg(10005, "手机号不存在");
	public static CodeMsg POC_ERROR_MOBILECODE = new CodeMsg(10006, "手机验证码有误");
	
	//order模块20001
	public static CodeMsg POC_ERROR_UPDATEPRODSTOCK = new CodeMsg(20001, "对不起，调用更新库存失败");
	public static CodeMsg POC_ERROR_ADDCART = new CodeMsg(20001, "对不起，加入购物车失败");
	
	//product模块30001
	public static CodeMsg POC_ERROR_STOCK_LOW = new CodeMsg(30001, "当前库存不允许添加这么多");
	public static CodeMsg POC_ERROR_UPDATESTOCK = new CodeMsg(30002, "抱歉，差一点就抢到了");
	
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
