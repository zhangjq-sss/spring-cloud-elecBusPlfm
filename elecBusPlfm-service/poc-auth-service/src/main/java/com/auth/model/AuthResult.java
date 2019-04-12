package com.auth.model;

import lombok.Data;


@Data
public class AuthResult {
	private String 			code; 		//错误编码
	private String 		message; //错误编码
	private Object 		data;  		//token
	

	public AuthResult() {
		super();
		code ="9999";
		message ="";
        data =null;
	}

	public boolean isSuccess() {
		return code .equals("0000");
	}

}
