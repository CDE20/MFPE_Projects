package com.cognizant.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a POJO class used to store details entered by Project Manager/User
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetails {
	
	private String auditType;
	
	private Date auditDate;
	

}
