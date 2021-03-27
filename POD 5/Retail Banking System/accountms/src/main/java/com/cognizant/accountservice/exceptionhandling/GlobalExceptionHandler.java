package com.cognizant.accountservice.exceptionhandling;

import java.net.ConnectException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cognizant.accountservice.model.AccountErrorResponse;

import feign.FeignException;



/**
 * Global exception controller
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Global exception controller for Access Denied 
	 */
	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<AccountErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {
		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.CONFLICT ,ex.getMessage() ,"Access Denied" );
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	/**
	 * Global exception controller for Account not found
	 */
	@ExceptionHandler({ AccountNotFoundException.class })
	public ResponseEntity<AccountErrorResponse> handleAccountNotFoundException(AccountNotFoundException ae) {

		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.NOT_FOUND ,ae.getMessage() , "Account Not Found");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * Global exception controller for Minimum balanace
	 */
	@ExceptionHandler(MinimumBalanceException.class)
	public ResponseEntity<AccountErrorResponse> nullPointer(MinimumBalanceException exception, WebRequest request) {
		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.NOT_ACCEPTABLE ,exception.getMessage() ,"Access Denied");
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}
	
	  /**
     * Global exception controller for Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ FeignException.class })
    public ResponseEntity<AccountErrorResponse> handleFeignException(FeignException ex) {
        AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.INTERNAL_SERVER_ERROR ,ex.getMessage() ,"Server Down Try Later..." );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * Global exception controller for Connection Error
     */
   
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ ConnectException.class })
    public ResponseEntity<AccountErrorResponse> handleConnectException(ConnectException ex) {
        AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.INTERNAL_SERVER_ERROR ,ex.getMessage() ,"Connection Error..." );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}