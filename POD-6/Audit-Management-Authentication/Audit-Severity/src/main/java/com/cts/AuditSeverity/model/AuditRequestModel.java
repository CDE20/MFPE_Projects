package com.cts.AuditSeverity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="auditrequest")
public class AuditRequestModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RequestId")
	private int requestId;
	@OneToOne(cascade = CascadeType.ALL)
	private AuditDetailModel auditDetail;
	@Column(name="ProjectName")
	private String projectName;
	@Column(name="ManagerName")
	private String managerName;
	@Column(name="OwnerName")
	private String ownerName;
	
	public AuditRequestModel(AuditDetailModel auditDetail,String projectName, String managerName, String applicationOwnerName) {

		super();
		this.auditDetail = auditDetail;
		this.projectName = projectName;
		this.managerName = managerName;
		this.ownerName = applicationOwnerName;
	}
	
	
		
}