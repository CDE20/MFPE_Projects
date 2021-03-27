package com.returnordermanag.paymentService;



import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.returnordermanag.paymentService.exception.CardNotFoundException;
import com.returnordermanag.paymentService.exception.Errormsg;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	 @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        Errormsg error = new Errormsg("Server Error", details);
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 @ExceptionHandler(CardNotFoundException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(CardNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        Errormsg error = new Errormsg("Card Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	 
	    
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        Errormsg error = new Errormsg("Validation Failed", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	    }
}

