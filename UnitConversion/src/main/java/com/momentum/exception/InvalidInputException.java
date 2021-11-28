package com.momentum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException{

	public InvalidInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
