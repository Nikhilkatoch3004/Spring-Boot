package com.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(StudentNotFound.class)
//	public ResponseEntity<String> handleStudentNotFound(StudentNotFound ex){
//		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
//	}
}
