package com.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CodedException extends Exception {
	private static final long serialVersionUID = -4363252071565231734L;

	private String code;
	
	public CodedException(String code, String message) {
		this(code, message, null);
	}
	
	public CodedException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
}
