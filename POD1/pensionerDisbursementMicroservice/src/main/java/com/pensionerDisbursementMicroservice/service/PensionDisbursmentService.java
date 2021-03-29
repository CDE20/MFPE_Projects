package com.pensionerDisbursementMicroservice.service;

import org.springframework.stereotype.Service;

import com.pensionerDisbursementMicroservice.Model.Bank;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;

@Service
public class PensionDisbursmentService {

	public ProcessPensionResponse code(Bank bank, double serviceCharge) {
		ProcessPensionResponse ppr = new ProcessPensionResponse();
		double x = bank.getBankType().equalsIgnoreCase("public") ? 500 : 550;
		if (x == serviceCharge)
			ppr.setPensionStatusCode(10);

		else {
			ppr.setPensionStatusCode(21);

		}

		return ppr;
	}

}
