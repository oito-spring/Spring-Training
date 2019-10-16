package com.spring.training.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = EmployeeNotFound.class)

	public ResponseEntity<Object> exception() {
		return new ResponseEntity<>("Record not found!!!!", HttpStatus.NOT_FOUND);
	}

}
