package com.practise.ExceptionHandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = NoSuchCustomerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse HandleException(NoSuchCustomerException noSuchCustomerException) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), noSuchCustomerException.getMessage());
	}
	
}
