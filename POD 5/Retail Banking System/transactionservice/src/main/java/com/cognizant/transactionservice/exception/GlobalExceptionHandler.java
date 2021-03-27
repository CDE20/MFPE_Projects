package com.cognizant.transactionservice.exception;


import java.net.ConnectException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cognizant.transactionservice.models.TransactionErrorResponse;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	//NullPointerException

	
	/**
	 * Global exception controller for Minimum balance
	 */
	@ExceptionHandler(MinimumBalanceException.class)
	public ResponseEntity<TransactionErrorResponse> nullPointer(MinimumBalanceException exception, WebRequest request) {
		TransactionErrorResponse response = new TransactionErrorResponse(LocalDateTime.now() ,HttpStatus.NOT_ACCEPTABLE ,exception.getMessage() ,"Access Denied");
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}
	
	 /**
     * Global exception controller for Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ FeignException.class })
    public ResponseEntity<TransactionErrorResponse> handleFeignException(FeignException ex) {
    	TransactionErrorResponse response = new TransactionErrorResponse(LocalDateTime.now() ,HttpStatus.INTERNAL_SERVER_ERROR ,ex.getMessage() ,"Server Down Try Later..." );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * Global exception controller for Connection Error
     */
   
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ ConnectException.class })
    public ResponseEntity<TransactionErrorResponse> handleConnectException(ConnectException ex) {
    	TransactionErrorResponse response = new TransactionErrorResponse(LocalDateTime.now() ,HttpStatus.INTERNAL_SERVER_ERROR ,ex.getMessage() ,"Connection Error..." );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}