package com.returnordermanag.authorizationService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "myuser")
public class MyUser {

	@Id
	@Column(name = "userid")
	private String userid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	private String token;

	public MyUser(String userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public MyUser() {
		super();
	}

}
