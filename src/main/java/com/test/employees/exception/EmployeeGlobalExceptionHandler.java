package com.test.employees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object>valEntity(SalaryNotFoundException n){
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}
