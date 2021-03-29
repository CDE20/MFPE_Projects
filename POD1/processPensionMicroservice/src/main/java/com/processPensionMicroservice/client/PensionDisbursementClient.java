package com.processPensionMicroservice.client;

import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.processPensionMicroservice.exception.NotFoundException;
import com.processPensionMicroservice.model.ProcessPensionInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;

@FeignClient(name = "PensionDisbursementService", url = "http://localhost:8083/")
public interface PensionDisbursementClient {
	@PostMapping("/disbursePension")
	public ProcessPensionResponse getcode(@RequestBody ProcessPensionInput processPensionInput)
			throws IOException, NotFoundException;
}