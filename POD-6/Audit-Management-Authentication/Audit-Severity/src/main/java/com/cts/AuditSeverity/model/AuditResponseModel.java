package com.cts.AuditSeverity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 *
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="auditresponse")
public class AuditResponseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResponseId")
	private int responseId;
	@Column(name="ExecutionStatus")
	private String executionStatus;
	@Column(name="ActionDuration")
	private String actionDuration;
	
	public AuditResponseModel(String projectExecutionStatus, String remedialActionDuration) {

		this.executionStatus = projectExecutionStatus;
		this.actionDuration = remedialActionDuration;
	}

	
	
}