package com.pensionManagementSystem.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
	@Id
	private int id;
	private String username;
	private String password;
}
