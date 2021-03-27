package com.cognizant.medicinestock.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.medicinestock.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler{
	
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> allExceptions(Exception ex) {
		log.info("START");
		ErrorResponse response = new ErrorResponse();
		response.setLocalDateTime(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setReason("BAD REQUEST");
		log.debug("ERROR RESPONSE {}:", response);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TokenValidationFailedException.class)
	public ResponseEntity<ErrorResponse> handleTokenValidationFailedException(TokenValidationFailedException e) {
		log.info("START");
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.FORBIDDEN);
		errorResponse.setMessage("PLEASE ENTER VALID TOKEN");
		errorResponse.setReason("YOUR TOKEN MIGHT BE WRONG OR MAYBE EXPIRED");
		errorResponse.setLocalDateTime(LocalDateTime.now());
		log.info("END");
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
	}
	


	
}
