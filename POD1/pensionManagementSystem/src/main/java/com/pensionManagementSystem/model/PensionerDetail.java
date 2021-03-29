package com.pensionManagementSystem.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PensionerDetail {
	private String name;
	private Date dateOfBirth;
	private String pan;
	private double salary;
	private double allowance;
	private String pensionType;
	private Bank bank;

}
