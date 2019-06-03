package com.customer.exception;

import com.common.exception.CodedException;

/**
 * 500错误
 * @author hui.liu
 *
 */
public class InternalServerErrorException  extends CodedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7006621963892141876L;

	public InternalServerErrorException(String code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	
}
