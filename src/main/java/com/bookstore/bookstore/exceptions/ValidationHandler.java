package com.bookstore.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationHandler {

	@ExceptionHandler(value = InputException.class)
	public ResponseEntity<?> exception(InputException exception) {
		return new ResponseEntity<>("Failed due to bad input", HttpStatus.BAD_REQUEST);
	}
	


}
