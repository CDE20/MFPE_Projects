package com.cts.AuditSeverity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.SeverityController;
import com.cts.AuditSeverity.fiegnclient.AuditBenchmarkFeignclient;
import com.cts.AuditSeverity.fiegnclient.AuditCheckListProxy;
import com.cts.AuditSeverity.fiegnclient.AuthClient;
import com.cts.AuditSeverity.pojo.AuditBenchmark;
import com.cts.AuditSeverity.pojo.AuditDetails;
import com.cts.AuditSeverity.pojo.AuditRequest;
import com.cts.AuditSeverity.pojo.AuditResponse;
import com.cts.AuditSeverity.pojo.AuditType;
import com.cts.AuditSeverity.pojo.QuestionsEntity;
import com.cts.AuditSeverity.service.AuditRequestResponse;
import com.cts.AuditSeverity.service.TokenService;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class SeverityControllerTest {

	@Mock
	private AuditRequestResponse service;
	
	@Mock
	AuthClient authClient;
	
	@Mock
	AuditCheckListProxy checklistProxy;
	
	
	@Mock
	TokenService tokenService;
	
	@Mock
	AuditBenchmarkFeignclient auditBenchmarkFeignclient;
	
	@Mock
	Environment env;
	
	@InjectMocks
	SeverityController severityController;
	
	@Test
	public void contextLoad() {
		assertNotNull(severityController);
	}

	@Test
	public void testAuditSeverity() {
		List<QuestionsEntity> questionsEntity = new ArrayList<>();
		questionsEntity.add(new QuestionsEntity(1,"Internal","ABC","No"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","DEF","No"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","PQR","Yes"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","STU","Yes"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","QWF","Yes"));

		ResponseEntity<List<QuestionsEntity>> questionsList = new ResponseEntity<List<QuestionsEntity>>(questionsEntity,HttpStatus.OK);
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		ResponseEntity<List<AuditBenchmark>> responseEntity = new ResponseEntity<List<AuditBenchmark>>(auditBenchmarkList,HttpStatus.OK);
		AuditType auditType = new AuditType("Internal");
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		when(auditBenchmarkFeignclient.getBenchmarkMap("token")).thenReturn(responseEntity);
		when(checklistProxy.getChecklist("token", auditType)).thenReturn(questionsList);
		AuditResponse auditResponse = new AuditResponse(env.getProperty("project.status.green"),env.getProperty("remedial.action.no"));
		
		assertNotNull(severityController.auditSeverity("token", new AuditRequest("P","Q","R",new AuditDetails("Internal",null))).getBody());
	}
	
	@Test
	public void testAuditSeverityTokenFails() {
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		assertEquals(HttpStatus.FORBIDDEN,severityController.auditSeverity("token", new AuditRequest("P","Q","R",new AuditDetails("Internal",null))).getStatusCode());

	}
	
}
