package com.product.exception;

import com.common.exception.CodedException;

public class ForbiddenException extends CodedException {
	private static final long serialVersionUID = 6513937234879547682L;

	public ForbiddenException(String code, String message) {
		super(code, message);
	}
	
}