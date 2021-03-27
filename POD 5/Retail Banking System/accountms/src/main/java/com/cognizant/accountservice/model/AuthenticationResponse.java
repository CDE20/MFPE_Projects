package com.cognizant.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
	/**
	 *  Class used for sending authentication response
	 */
	
	private String userid;
	private String name;
	private boolean isValid;
}