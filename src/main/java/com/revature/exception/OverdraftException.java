package com.revature.exception;

public class OverdraftException extends RuntimeException {

	
	public OverdraftException() {
		super();
		
	}
	
	public OverdraftException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public OverdraftException(String message) {
		super(message);
	}
}
