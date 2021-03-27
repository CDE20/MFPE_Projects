package com.cognizant.accountservice.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountCreationStatus {

	/**
	 *  AccountCreationStatus for returning response
	 */
	@Id
	private long accountId;
	private String message;


}
