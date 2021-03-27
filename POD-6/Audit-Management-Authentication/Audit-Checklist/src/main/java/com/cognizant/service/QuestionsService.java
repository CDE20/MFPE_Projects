package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.QuestionsEntity;
import com.cognizant.repository.QuestionsRepository;
/**
 * @version 1.8
 * 			This class is used to load the questions from database and
 *          checking whether the question resides in database or not based on the
 *          given id.
 *
 */
@Service
public class QuestionsService {
	/**
	 * 
	 */
	@Autowired
	QuestionsRepository questionsRepository;
	/**
	 * 
	 * @param auditType
	 * @return List
	 * @throws IndexOutOfBoundsException
	 */
	public List<QuestionsEntity> getQuestions(String auditType) throws IndexOutOfBoundsException {

		if(questionsRepository.findByAuditType(auditType).isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		return questionsRepository.findByAuditType(auditType);
	}
	/**
	 * 
	 * @param questionsResponse
	 * @return List
	 */
	public List<QuestionsEntity> saveResponses(List<QuestionsEntity> questionsResponse) {

		return questionsRepository.saveAll(questionsResponse);
		
	}

	
}
