package com.pensionManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class ProcessPensionInput {

	private Long aadharNumber;
	private Double pensionAmount;
	private double serviceCharge;

}
