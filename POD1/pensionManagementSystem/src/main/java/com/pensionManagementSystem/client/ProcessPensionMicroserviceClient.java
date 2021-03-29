package com.pensionManagementSystem.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pensionManagementSystem.model.PensionDetail;
import com.pensionManagementSystem.model.PensionerInput;

@FeignClient("ProcessPensionService")//url = "http://localhost:8081/"
public interface ProcessPensionMicroserviceClient {

	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetails(@RequestBody PensionerInput pensionerInput);

}
