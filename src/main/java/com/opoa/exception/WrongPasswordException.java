package com.opoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class WrongPasswordException extends RuntimeException {
  public WrongPasswordException(String msg) {
	  super(msg) ;
  
  }
}
