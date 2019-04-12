package com.product.exception;

import com.common.exception.CodedException;

/**
 * 未授权
 */
public class UnauthorizedException extends CodedException {
	private static final long serialVersionUID = -8104406381789721411L;

	public UnauthorizedException(String code, String message) {
		super(code, message);
	}
	
}
