package com.cts.AuditSeverity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *  
 * 	
 *
 */
@Entity
@Table(name = "auditdetail")
public class AuditDetailModel {

	public AuditDetailModel(String auditType) {
		super();
		this.auditType = auditType;
	}

	public AuditDetailModel(int auditId, String auditType, Date auditDate) {
		super();
		this.auditId = auditId;
		this.auditType = auditType;
		this.auditDate = auditDate;
	}

	public AuditDetailModel() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuditId")
	private int auditId;
	@Column(name = "AuditType")
	private String auditType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "auditdate")
	private Date auditDate;

	@PrePersist
	protected void onCreate() {
		auditDate = new Date();
	}

	/*
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @Column(name="AuditDate") private Date auditDate;
	 */
	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public int getAuditId() {
		return auditId;
	}

}
