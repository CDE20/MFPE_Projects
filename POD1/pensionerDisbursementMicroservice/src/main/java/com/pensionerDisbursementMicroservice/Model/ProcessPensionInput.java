package com.pensionerDisbursementMicroservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Getter
@Setter
public class ProcessPensionInput {

	private Long aadharNumber;
	private Double pensionAmount;
	private double serviceCharge;
}
