package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * This class is an entity which we will be storing in the database. We
 *          will store the values already in the database for checking the user
 *          login credentials and this entity would help us to do that.
 *
 */
@Entity
@Table(name="ProjectManager")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectManager {
	/**
	 * This will be the id for the user credentials that user will have to enter in
	 * the request body
	 */
	@Id
	@Column(name="userid" ,length=20)
	private String userId;
	/**
	 * This field will be used to store the password that user will have to enter in
	 * the request body
	 */
	@Column(name="upassword",length=20)
	private String password;
	/**
	 * This field will be used to store the authToken 
	 *
	 */
	@Column(name="authtoken")
	private String authToken;
		

	

	
	
	
}
