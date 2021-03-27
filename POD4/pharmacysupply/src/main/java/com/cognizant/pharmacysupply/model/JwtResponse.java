package com.cognizant.pharmacysupply.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JwtResponse implements Serializable{

	private static final long serialVersionUID = -8091879091924046844L;
	private String userid;
	private String username;
	private boolean valid;
	
	
	

	
	
	
	
}
