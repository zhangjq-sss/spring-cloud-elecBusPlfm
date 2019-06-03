package com.common.msg;

import java.io.Serializable;

import com.common.msg.BaseResponse;
import com.common.msg.CodeMsg;

public class RrcResponse extends BaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object data;
	
	public boolean isSuccess() {
		return this.getCode()==200;
	}
	/**
	 * 成功时候的调用
	 */
	public static RrcResponse success() {
		return new RrcResponse(CodeMsg.SUCCESS);
	}
	
	/**
	 * 成功时候的调用 带DATA
	 */
	public static RrcResponse success(Object data) {
		return new RrcResponse(CodeMsg.SUCCESS, data);
	}
	
	/**
	 * 失败时候的调用
	 */
	public static RrcResponse error() {
		return new RrcResponse(CodeMsg.FAIL);
	}

	/**
	 * 失败时候的调用 带DATA
	 */
	public static RrcResponse error(CodeMsg codeMsg, Object data) {
		return new RrcResponse(codeMsg, data);
	}

	public RrcResponse() {
	}
	
	public RrcResponse(int code, String message, Object data) {
		super(code, message);
		this.data = data;
	}

	public RrcResponse(CodeMsg codeMsg) {
		super(codeMsg);
	}

	public RrcResponse(CodeMsg codeMsg, Object data) {
		super(codeMsg);
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
