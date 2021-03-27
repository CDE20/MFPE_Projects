package com.cognizant.pharmacysupply.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.pharmacysupply.model.ErrorResponse;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllErrors(Exception ex) {
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setReason("Bad request");
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MedicineNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleFeignStatusException(MedicineNotFoundException e) {
		ErrorResponse customErrorResponse = new ErrorResponse();
		customErrorResponse.setStatus(HttpStatus.FORBIDDEN);
		customErrorResponse.setMessage("The medicine is not present in the stock");
		customErrorResponse.setReason("You might have entered wrong medicine name.");
		customErrorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(customErrorResponse, HttpStatus.FORBIDDEN);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> handleNoSuchElementExceptionException(NoSuchElementException e) {
		ErrorResponse customErrorResponse = new ErrorResponse();
		customErrorResponse.setStatus(HttpStatus.FORBIDDEN);
		customErrorResponse.setMessage("The medicine is not present in the stock.");
		customErrorResponse
				.setReason("You might have entered wrong medicine name or medicine not present in the stock");
		customErrorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(customErrorResponse, HttpStatus.FORBIDDEN);
	}
}
