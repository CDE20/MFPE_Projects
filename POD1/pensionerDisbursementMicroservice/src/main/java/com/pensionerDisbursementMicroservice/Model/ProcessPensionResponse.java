package com.pensionerDisbursementMicroservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class ProcessPensionResponse {

	private int pensionStatusCode;

}
