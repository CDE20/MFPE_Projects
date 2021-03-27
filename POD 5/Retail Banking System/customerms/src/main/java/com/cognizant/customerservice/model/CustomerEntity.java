package com.cognizant.customerservice.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {
	@Id
	@Column(name = "userid", length = 20,unique=true)
	private String userid;
	
	@Column(name = "username", length = 20)
	@NotBlank
	private String username;
	
	@Column(name = "password")
	@NotBlank
	private String password;
	
	@Column(name = "dateOfBirth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth; 
	
	@Column(name = "pan", length = 10)
	@NotBlank
	private String pan;
	
	@Column(name = "address")
	@NotBlank
	private String address;
	

	@Transient
	private List<Account> accounts = new ArrayList<>();
	
}
