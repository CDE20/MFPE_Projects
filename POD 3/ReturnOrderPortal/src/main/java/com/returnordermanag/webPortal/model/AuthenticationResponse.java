package com.returnordermanag.webPortal.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class AuthenticationResponse {
	private int userID;
	private String jwtToken;
	private Boolean valid;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public AuthenticationResponse(int userID, String jwtToken, Boolean valid) {
		super();
		this.userID = userID;
		this.jwtToken = jwtToken;
		this.valid = valid;
	}
	public AuthenticationResponse() {
		super();
	}

	
}
