package com.domain.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class Callback<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3735503713236625487L;

	private Integer code;

	private T datas;

	private String msg;

	private Boolean success;

	public Callback() {
		super();
	}

	public Callback(Integer code, T datas, String msg, Boolean success) {
		super();
		this.code = code;
		this.datas = datas;
		this.msg = msg;
		this.success = success;
	}

	public Callback(Integer code, T datas, String msg) {
		super();
		this.code = code;
		this.datas = datas;
		this.msg = msg;
		this.success = true;
	}

}