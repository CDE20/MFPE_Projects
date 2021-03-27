package com.cognizant.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 *
 *  This class we are using as a response of error handling message.
 *          In the {@link GlobalErrorHandler} class we are using this
 *          {@link CustomErrorResponse} class as a return type that will be
 *          shown to the client whenever any kind of exception occurs. The
 *          fields of this class will be used to show this kind of response.
 */
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomErrorResponse {
	/**
	 * This field will show the time when the exception occurs
	 */
	private LocalDateTime timestamp;
	/**
	 * This field will show the status which we will be setting in this field from
	 * {@link GlobalErrorHandler} class.
	 */
	private HttpStatus status;
	/**
	 * This field will represent the reason why the exception has been occured. This
	 * we will set in the {@link GlobalErrorHandler} class
	 */
	private String reason;
	/**
	 * This field will represent the message which we will set in the constructor of
	 * exception class. This we will set in the {@link GlobalErrorHandler} class
	 */
	private String message;

}
