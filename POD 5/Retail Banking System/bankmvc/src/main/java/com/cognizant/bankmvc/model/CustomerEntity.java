package com.cognizant.bankmvc.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
	private String userid;
	
	private String username;
	
	private String password;
	
	private Date dateOfBirth;
	
	private String pan;
	
	private String address;
	
	private List<Account> accounts = new ArrayList<Account>();
	
}
