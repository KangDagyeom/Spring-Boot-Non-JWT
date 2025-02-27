package com.javaweb.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.api.ErrorHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
		ErrorHandler errorResponse = new ErrorHandler();
		errorResponse.setError(ex.getMessage());
		errorResponse.setDetails(Arrays.asList("Vui lòng kiểm tra lại các trường bắt buộc."));
		return new ResponseEntity<>(errorResponse, HttpStatus.ALREADY_REPORTED);
	}
}