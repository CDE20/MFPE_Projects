package com.cognizant.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.Controller.AuditCheckListController;
import com.cognizant.feignclient.AuthClient;
import com.cognizant.model.QuestionsEntity;
import com.cognizant.pojo.AuditType;
import com.cognizant.repository.QuestionsRepository;
import com.cognizant.service.QuestionsService;
import com.cognizant.service.TokenService;

import lombok.extern.slf4j.Slf4j;
/**
 * 		 	This class contains test cases for the AuthController
 *          class which are written using junit and mockito
 */
@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class AuditCheckListControllerTest {

	@Mock
	AuthClient authClient;
	
	@Mock
	TokenService tokenService;
	
	@Mock
	AuditType auditType;
	
	@Mock
	QuestionsService questionsService;
	
	@Mock
	Environment env;
	
	@InjectMocks
	AuditCheckListController auditCheckListController;
	
	@Mock
	QuestionsRepository questionsRepository;
	
	@Test
	public void contextLoads() {
		assertNotNull(auditCheckListController);
	}
	/**
	 * To test testGetCheckList method
	 */
	@Test
	public void testGetChecklist() {
		ResponseEntity<?> responseEntity = null;
		List<QuestionsEntity> questionsList = new ArrayList<QuestionsEntity>();
		questionsList.add(new QuestionsEntity(1,"Internal","How are you","Yes"));
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		when(questionsService.getQuestions("Internal")).thenReturn(questionsList);
		responseEntity = auditCheckListController.getChecklist("token", auditType);
		assertNotNull(responseEntity);
			
	}
	
	@Test
	public void testGetChecklistTokenInvalid() {
		ResponseEntity<?> responseEntity = null;
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		responseEntity = auditCheckListController.getChecklist("token", auditType);
		assertEquals(HttpStatus.FORBIDDEN,responseEntity.getStatusCode());
	}
	
	
	
	@Test
	public void testSaveResponses() {
		ResponseEntity<?> responseEntity = null;
		List<QuestionsEntity> questionsList = new ArrayList<QuestionsEntity>();
		questionsList.add(new QuestionsEntity(1,"Internal","How are you","Yes"));
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		assertEquals(HttpStatus.OK,auditCheckListController.saveResponses("token", questionsList).getStatusCode());
	}
	
	@Test
	public void testSaveResponseTokenInvalid() {
		ResponseEntity<?> responseEntity = null;
		List<QuestionsEntity> questionsList = new ArrayList<QuestionsEntity>();
		questionsList.add(new QuestionsEntity(1,"Internal","How are you","Yes"));
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		responseEntity = auditCheckListController.saveResponses("token",questionsList);
		assertEquals(HttpStatus.FORBIDDEN,responseEntity.getStatusCode());
	}
	
	
	
	
}
