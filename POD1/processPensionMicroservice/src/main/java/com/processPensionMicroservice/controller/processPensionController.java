package com.processPensionMicroservice.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.processPensionMicroservice.client.PensionDisbursementClient;
import com.processPensionMicroservice.client.PensionerDetailClient;
import com.processPensionMicroservice.exception.NotFoundException;
import com.processPensionMicroservice.model.PensionDetail;
import com.processPensionMicroservice.model.PensionerDetail;
import com.processPensionMicroservice.model.PensionerInput;
import com.processPensionMicroservice.model.ProcessPensionInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;
import com.processPensionMicroservice.service.ProcessPensionService;

@RestController
public class processPensionController {

	@Autowired
	PensionerDetailClient pensionerDetailClient;
	@Autowired
	PensionDisbursementClient pensionDisbursementClient;
	@Autowired
	ProcessPensionService processPensionService;

	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetails(@RequestBody PensionerInput pensionerInput) {

		System.out.println(pensionerInput);

		PensionerDetail pensionerDetail = pensionerDetailClient
				.getPensionerDetailByAadhaar(pensionerInput.getAadharNumber());

		System.out.println(pensionerDetail);
		
		PensionDetail pensionDetail = null;
		
		if(pensionerDetail == null) {
			return pensionDetail;
		}
		
		ProcessPensionResponse ppr = processPensionService.checkdetails(pensionerInput, pensionerDetail);

		if (ppr.getPensionStatusCode() == 10) {
			pensionDetail = processPensionService.getresult(pensionerDetail);

			ProcessPensionInput processPensionInput = new ProcessPensionInput(pensionerInput.getAadharNumber(),
					pensionDetail.getPensionAmount(), 500);

			System.out.println(processPensionInput);

			try {
				ppr = this.getcode(processPensionInput);
				if (ppr.getPensionStatusCode() == 21) {
					pensionDetail.setPensionAmount(pensionDetail.getPensionAmount() - 550);
				} else if (ppr.getPensionStatusCode() == 10) {
					pensionDetail.setPensionAmount(pensionDetail.getPensionAmount() - 500);
				}
			} catch (IOException | NotFoundException e) {
				return null;
			}
		}
		// Pension Details
		System.out.println(pensionDetail);
		return pensionDetail;
	}

	@PostMapping("/ProcessPension")
	public ProcessPensionResponse getcode(@RequestBody ProcessPensionInput processPensionInput)
			throws IOException, NotFoundException {
		return pensionDisbursementClient.getcode(processPensionInput);
	}

}
