package com.cts.AuditSeverity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.model.AuditDetailModel;
import com.cts.AuditSeverity.model.AuditRequestModel;
import com.cts.AuditSeverity.model.AuditResponseModel;
import com.cts.AuditSeverity.pojo.AuditDetails;
import com.cts.AuditSeverity.pojo.AuditRequest;
import com.cts.AuditSeverity.pojo.AuditResponse;
import com.cts.AuditSeverity.repository.DetailRepository;
import com.cts.AuditSeverity.repository.RequestRepository;
import com.cts.AuditSeverity.repository.ResponseRepository;
import com.cts.AuditSeverity.service.AuditRequestResponse;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * 			Test class to test AuditRequestResponse
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class AuditRequestResponseTest {

	@Mock
	RequestRepository requestRepository;
	@Mock
	ResponseRepository responseRepository;
	
	@InjectMocks
	AuditRequestResponse requestResponse;
	
	@Mock
	Environment env;
	
	
	/**
	 * 
	 */
	@Test
	public void saveResponseTest() {
		log.info(env.getProperty("string.start"));
		AuditResponse response = new AuditResponse("GREEN","No action required");
		AuditResponseModel detailModel = new AuditResponseModel(response.getProjectExecutionStatus(),response.getRemedialActionDuration());
		when(responseRepository.save(detailModel)).thenReturn(detailModel);
		assertEquals(detailModel, requestResponse.saveResponse(response));
		log.info(env.getProperty("string.end"));
	}
	
}
