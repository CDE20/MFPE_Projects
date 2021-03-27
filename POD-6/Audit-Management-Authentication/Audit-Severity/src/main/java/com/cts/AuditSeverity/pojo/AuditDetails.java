package com.cts.AuditSeverity.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
This POJO class is for AuditDetails
 *
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetails {
	/**
	 * Variable auditType is used to store the type of Audit
	 */
	private String auditType;
	/**
	 * Variable auditDate is used to store the Audit Date
	 */
	private Date auditDate;
	
		
}
