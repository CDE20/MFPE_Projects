package com.cognizant.pojo;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 			This class is used as a response of error handling message.
 *          In the {@link GlobalErrorHandler} class {@link CustomErrorResponse} class 
 *          is used as a return type that will be
 *          shown to the client whenever any kind of exception occurs. 
 *          The variables of this class is used to describe the Exception.
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {

	/**
	 * Variable timestamp is used to store time when the exception occurred.
	 * the data type is LocalDateTime.
	 */
	private LocalDateTime timestamp;
	/**
	 * Variable status is used to store status which will be set in this variable
	 *  from {@link GlobalErrorHandler} class.
	 *  The data type is HttpStatus.
	 */
	private HttpStatus status;
	/**
	 * Variable reason is used to store the reason why the exception occurred. This
	 * will set in the {@link GlobalErrorHandler} class
	 *  The data type is String.
	 */
	private String reason;
	
	/**
	 * Variable message is used to store message which is retrieved from the constructor of
	 * exception class. 
	 * The data type is String.
	 */
	private String message;
}
