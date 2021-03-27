package com.cognizant.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * This model class is used for validation of token 
 * for authorization 
 *
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	/**
	 * Variable uId is used to store the uId for user login
	 * credentials. The data type is String.
	 */
	private String uid;
	/**
	 * Variable isValid is used to store whether the token is valid
	 * or not. The data type is boolean.
	 */
	private boolean isValid;


}
