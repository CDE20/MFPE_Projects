package com.returnordermanag.packageDeliveryModule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




	@RestControllerAdvice
	public class GlobalExceptionHandler {
		
		@ExceptionHandler(ComponentTypeNotFoundException.class)
		public ResponseEntity<String> componentTypeNotFoundExceptionnHandler(ComponentTypeNotFoundException ex){
			
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
			
		}


	}

