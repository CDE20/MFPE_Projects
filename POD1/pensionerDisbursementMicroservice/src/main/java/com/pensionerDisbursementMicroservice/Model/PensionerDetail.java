package com.pensionerDisbursementMicroservice.Model;

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
	private String dateOfBirth;
	private String pan;
	private double salary;
	private double allowances;
	private String pensionType;
	private Bank bank;

}
