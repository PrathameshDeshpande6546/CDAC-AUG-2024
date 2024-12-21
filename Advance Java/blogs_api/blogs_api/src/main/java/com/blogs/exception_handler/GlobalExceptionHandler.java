package com.blogs.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dto.ApiResponse;

@RestControllerAdvice // => It's a spring bean containing - common exc handling advice meant for Rest
						// Controllers
public class GlobalExceptionHandler {
	//exception handling method
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException
	(ResourceNotFoundException e)
	{
		System.out.println("in handle res not found exc ");
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(e.getMessage()));
	}

}
