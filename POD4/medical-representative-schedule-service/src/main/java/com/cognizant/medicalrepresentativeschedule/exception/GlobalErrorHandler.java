package com.cognizant.medicalrepresentativeschedule.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.medicalrepresentativeschedule.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	ErrorResponse errorResponse;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllErrors(Exception ex) {
		log.info("Start");

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setReason("BAD_REQUEST");
		errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setTimestamp(LocalDateTime.now());

		log.info("End");

		return ResponseEntity.badRequest().body(errorResponse);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgTypeMismatchException(MethodArgumentTypeMismatchException e) {
		log.info("Start");

		errorResponse.setMessage("Please enter the date in dd-MM-yyyy format");
		errorResponse.setReason("You need to provide date in dd-MM-yyyy format");
		errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setTimestamp(LocalDateTime.now());

		log.info("End");

		return ResponseEntity.badRequest().body(errorResponse);
	}

	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<ErrorResponse> handleDateNotFoundException(InvalidDateException e) {
		log.info("Start");

		errorResponse.setMessage("Please enter the date in dd-MM-yyyy format");
		errorResponse.setReason("You need to provide date in dd-MM-yyyy format");
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setTimestamp(LocalDateTime.now());

		log.info("End");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(TokenValidationFailedException.class)
	public ResponseEntity<ErrorResponse> handleTokenValidationFailedException(TokenValidationFailedException e) {
		log.info("Start");

		errorResponse.setMessage("Your token is invalid");
		errorResponse.setReason("Your token might have been expired or you have entered wrong token");
		errorResponse.setStatus(HttpStatus.FORBIDDEN);
		errorResponse.setTimestamp(LocalDateTime.now());

		log.info("End");

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
	}

}
