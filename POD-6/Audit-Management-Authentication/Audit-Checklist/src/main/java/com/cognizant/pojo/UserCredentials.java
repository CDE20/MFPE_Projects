package com.cognizant.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * This POJO class is used to handle user details entered from UI by User
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCredentials {
	/**
	 * This field will contain the userid
	 */
	private String userId;
	/**
	 * This field will contain the password
	 */
	private String password;
}
