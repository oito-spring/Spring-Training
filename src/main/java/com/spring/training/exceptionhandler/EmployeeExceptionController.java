package com.spring.training.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {
	@ExceptionHandler({ EmployeeNotFoundException.class, MethodNotAllowed.class })

	public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> exception(MethodNotAllowed exception) {
		return new ResponseEntity<>("Please specify an id", HttpStatus.METHOD_NOT_ALLOWED);
	}
}
