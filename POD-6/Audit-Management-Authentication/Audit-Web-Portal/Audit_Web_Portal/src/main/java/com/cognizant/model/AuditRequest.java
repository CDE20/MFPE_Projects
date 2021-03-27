package com.cognizant.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * This is a POJO class used to store the Audit related info and responses of questions selected by user
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class AuditRequest {
	/**
	 * Variable projectName is used to store the Name of the Project
	 */
	private String projectName;
	/**
	 * Variable projectManagerName is used to store the Manager Name of the Project
	 */
	private String projectManagerName;
	/**
	 * Variable applicationOwnerName is used to store the Application Owner Name of the Project
	 */
	private String applicationOwnerName;
	/**
	 * Variable auditDetails is used to store the AuditDetails of the Project
	 */
	private AuditDetails auditDetails;
}
