package com.practise.ExceptionHandling.exception;


public class NoSuchCustomerException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NoSuchCustomerException(String message) {
		super();
		this.message = message;
	}

	public NoSuchCustomerException() {
		super();
	}
	
}
