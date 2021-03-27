package com.cts.AuditSeverity.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 *  	This is a POJO Class for Questions Entity
 *
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class QuestionsEntity {

	/**
	 * Variable questionId is used to store the QuestionID
	 */
	private Integer questionId;
	/**
	 * Variable auditType is used to store the Audit Type
	 */
	private String auditType;
	/**
	 * Variable question is used to store the Question
	 */
	private String question;
	/**
	 * Variable response is used to store the Response of the question
	 */
	private String response;
}
