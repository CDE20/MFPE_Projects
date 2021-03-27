package com.cts.AuditSeverity.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**

This class is used to hold the login credentials
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	/**
	 * The userid will be unique and it will hold the value which user will send
	 * from the request body for getting the token
	 */
	private String userId;
	/**
	 * This field represents the password and it will hold the value which user will send
	 * from the request body for getting the token
	 */
	private String password;
}
