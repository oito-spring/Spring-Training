package com.example.demo.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SuppressWarnings("serial")
@ControllerAdvice
public class CustomException extends Exception {
	/**
	 * @param exception
	 */
	@ExceptionHandler(value = RecordNotFound.class)

	public ResponseEntity<Object> exception(RecordNotFound exception) {
		return new ResponseEntity<>("Record with requested id not found", HttpStatus.NOT_FOUND);
	}

	/**
	 * @param exception
	 */
	public ResponseEntity<Object> exception(MethodNotAllowed exception) {
		return new ResponseEntity<>("Method not Allowed! Check if id is specified", HttpStatus.METHOD_NOT_ALLOWED);
	}
}
