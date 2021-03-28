package com.cognizant.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This is a model class which is used as a table using Spring Data
 * JPA's @Entity Annotations. It contains fields like UserId, Password and
 * UserName.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "user")
public class MyUser {

	@Id
	@Column(name = "userid", length = 20)
	private String userid;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "username", length = 20)
	private String username;

}
