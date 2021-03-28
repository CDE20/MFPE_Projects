package com.cognizant.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This is model class which is used as a response when a successful validation
 * of token happens which contains fields like UserId, UserName and if the user
 * is valid or not.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtResponse {

	private String userid;

	private String username;

	private boolean isValid;
}
