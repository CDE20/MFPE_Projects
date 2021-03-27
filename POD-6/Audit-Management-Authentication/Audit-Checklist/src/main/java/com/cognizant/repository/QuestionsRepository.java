package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.QuestionsEntity;

/**
 * 
 * This interface communicates with db to fetch the questions.
 *
 */
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Integer> {
	/**
	 * 
	 * @param i
	 * @return
	 */
	List<QuestionsEntity> findByAuditType(String i);

}
