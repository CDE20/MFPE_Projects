package com.cognizant.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 
 *		   This class contains test cases for the QuestionsEntity model class
 *         which are written using junit and mockito
 */

@RunWith(SpringRunner.class)
@ContextConfiguration
public class QuestionsEntityTest {

	QuestionsEntity questions = new QuestionsEntity();
	/**
	 * 
	 * test the allArgsConstructor of QuestionsEntity model class
	 */
	@Test
	public void testQuestionsEntityConstructor() {
		assertNotNull(questions);
	}
	/**
	 * 
	 * test the QuestionsEntityParameterizedConstructor of QuestionsEntity model class
	 */
	@Test
	public void testQuestionsEntityParameterizedConstructor() {
		QuestionsEntity parameterizedQuestions = new QuestionsEntity(1,"Internal","Is data deleted with permission of user?","Yes");
		assertEquals("Internal",parameterizedQuestions.getAuditType());
	}
	/**
	 * 
	 * test the Getter and Setter of Question id in QuestionsEntity model class
	 */
	@Test
	public void testSetQUestionId() {
		questions.setQuestionId(2);
		assertEquals(2,questions.getQuestionId().intValue());
	}
	/**
	 * 
	 * test the Getter and Setter of Audit Type in QuestionsEntity model class
	 */
	@Test
	public void testAuditType() {
		questions.setAuditType("SOX");
		assertEquals("SOX",questions.getAuditType());
	}
	/**
	 * 
	 * test the Getter and Setter of Question in QuestionsEntity model class
	 */
	@Test
	public void testQuestion() {
		questions.setQuestion("How are you");
		assertEquals("How are you",questions.getQuestion());
	}
	/**
	 * 
	 * test the Getter and Setter of Response in QuestionsEntity model class
	 */
	@Test
	public void testResponse() {
		questions.setResponse("No");
		assertEquals("No",questions.getResponse());
	}
	
	
}
