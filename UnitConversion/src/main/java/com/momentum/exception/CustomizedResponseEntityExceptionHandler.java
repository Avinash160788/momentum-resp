package com.momentum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(InvalidInputException.class)  
	//override method of ResponseEntityExceptionHandler class  
	public final ResponseEntity<Object> handleInvalidInputExceptions(InvalidInputException ex)  
	{  
		//returning exception structure and Bad Request status   
		return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);  
	}     
}
