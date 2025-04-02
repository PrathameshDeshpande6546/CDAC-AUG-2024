package com.sunbeam.restcontrollers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sunbeam.models.PizzaAppResponse;

@RestControllerAdvice
public class PizzaExceptionHandler {
	@ExceptionHandler(value = Throwable.class)
	public PizzaAppResponse<?> handleException(Throwable ex) {
		ex.printStackTrace();
		String message = ex.getClass().getName() + ": " + ex.getMessage();
		return PizzaAppResponse.error(message);
	}
}
