package com.pensionManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bank {
	private String bankName;
	private long accountNumber;
	private String bankType;

}
