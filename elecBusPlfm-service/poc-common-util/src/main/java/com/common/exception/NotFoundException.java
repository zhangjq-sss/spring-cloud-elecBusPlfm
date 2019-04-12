package com.common.exception;


public class NotFoundException extends CodedException {
	private static final long serialVersionUID = 5073238353958393675L;
	
	public NotFoundException(String code, String message) {
		super(code, message);
	}
	
}
