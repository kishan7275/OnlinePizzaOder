package com.opoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class WrongPasswordHandler  {
	  public ResponseEntity<String> handleException(Exception ex){
		  return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	  }
}