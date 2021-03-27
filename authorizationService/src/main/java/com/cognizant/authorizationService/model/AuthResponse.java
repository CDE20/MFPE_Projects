package com.cognizant.authorizationService.model;
/**
 * 
 * This is a model class for authenticated response 
 * @author POD-3
 *
 */
public class AuthResponse {

	private String uid;

	private String name;

	private boolean isValid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
