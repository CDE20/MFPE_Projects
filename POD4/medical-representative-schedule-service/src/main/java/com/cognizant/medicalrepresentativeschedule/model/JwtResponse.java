package com.cognizant.medicalrepresentativeschedule.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse implements Serializable{

	private static final long serialVersionUID = -8091879091924046844L;
	private String id;
	private String name;
	private boolean valid;

}