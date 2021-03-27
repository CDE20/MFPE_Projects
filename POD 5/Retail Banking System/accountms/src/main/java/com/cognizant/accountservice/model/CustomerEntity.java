package com.cognizant.accountservice.model;

import java.sql.Date;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
	/**
	 *  Class used for inputing customer entity
	 */
	
	private String userid;
	private String username;
	private String password;
	private Date dateOfBirth;
	private String pan;
	private String address;

}