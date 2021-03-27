package com.cognizant.customerservice.exception;

import java.net.ConnectException;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.customerservice.model.CustomErrorResponse;

import feign.FeignException;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ CustomerNotFoundException.class })
	public ResponseEntity<CustomErrorResponse> handleConsumerNotFoundException(CustomerNotFoundException ex) {

		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Invalid Consumer Id Provided");

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler({ ConsumerAlreadyExistException.class })
	public ResponseEntity<CustomErrorResponse> handleConsumerExistException(ConsumerAlreadyExistException ex) {

		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_ACCEPTABLE);
		response.setReason("Invalid Consumer Id Provided");

		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

	}

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<CustomErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {

		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		response.setReason("Access Denied");

		return new ResponseEntity<>(response, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler({ LoginFailedException.class })
	public ResponseEntity<CustomErrorResponse> handleLoginFailedException(AccessDeniedException ex) {

		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		response.setReason("Login Failed");

		return new ResponseEntity<>(response, HttpStatus.CONFLICT);

	}

	@ExceptionHandler(BindException.class)
	protected HashMap<String, Object> handleBindException(BindException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		HashMap<String, Object> map = new HashMap<>();
		map.put("key1", "Validation Error");
		map.put("Exception", ex);
		map.put("status", status);
		return map;
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		HashMap<String, Object> map = new HashMap<>();
		map.put("key1", "Validation Error");
		map.put("Exception", e);
		map.put("status", status);
		return map;
	}
	
	  /**
     * Global exception controller for Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ FeignException.class })
    public ResponseEntity<CustomErrorResponse> handleFeignException(FeignException ex) {
    	CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now() ,HttpStatus.INTERNAL_SERVER_ERROR ,ex.getMessage() ,"Server Down Try Later..." );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * Global exception controller for Connection Error
     */
   
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ ConnectException.class })
    public ResponseEntity<CustomErrorResponse> handleConnectException(ConnectException ex) {
    	CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now() ,HttpStatus.INTERNAL_SERVER_ERROR ,ex.getMessage() ,"Connection Error..." );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
