package com.order.exception;

import com.common.exception.CodedException;

public class BadRequestException extends CodedException{
	private static final long serialVersionUID = 6513937234879547682L;

	public BadRequestException(String code, String message) {
		super(code, message);
	}
	
}