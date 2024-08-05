package com.practise.ExceptionHandling.exception;


public class CustomerAlreadyExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CustomerAlreadyExistsException(String message) {
		super();
		this.setMessage(message);
	}

	public CustomerAlreadyExistsException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
