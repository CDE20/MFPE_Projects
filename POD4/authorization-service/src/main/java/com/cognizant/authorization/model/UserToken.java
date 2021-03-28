package com.cognizant.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This is a model class which is used as a response for the login method of
 * JwtAuthenticationController class. This class contains fields like UserId and
 * the Authentication Token generated in that method.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserToken {

	private String userid;

	private String authToken;
}
