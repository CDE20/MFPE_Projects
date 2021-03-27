package com.cognizant.accountservice.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountErrorResponse {
	/**
	 *  AccountErrorResponse for returning Error response
	 */
	
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private String message;
}
