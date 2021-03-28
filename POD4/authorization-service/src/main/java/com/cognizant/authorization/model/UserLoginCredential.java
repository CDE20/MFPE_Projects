package com.cognizant.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This is a model class which is passed as an argument to generate token in
 * login method of the JwtAuthenticationController class.This class contains
 * fields like UserId and Password.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLoginCredential {

	private String userid;

	private String password;
}
