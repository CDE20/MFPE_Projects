package com.cognizant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * This is a POJO class used to store the type of audit selected by user
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuditType {
	/**
	 * Variable auditType is used to store the Type of Audit
	 */
	String auditType;

}
