package com.returnordermanag.webPortal.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name = "user_details")
public class UserDetails {
	@Id
	private int userID;
	private String userName;
	private String password;
	private String jwtToken;
	private boolean isValid;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public UserDetails(int userID, String userName, String password, String jwtToken, boolean isValid) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.jwtToken = jwtToken;
		this.isValid = isValid;
	}
	public UserDetails() {
		super();
	}
	
	
}
