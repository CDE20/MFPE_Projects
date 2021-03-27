package com.cts.AuditSeverity.pojo;
/**
 * 
 * Variable auditDetails is used to store the AuditDetails of the Project
 *
 */
public class AuditResponse {

	private int auditId;
	private String projectExecutionStatus;
	private String remedialActionDuration;
	
	public AuditResponse(String projectExecutionStatus, String remedialActionDuration) {
		super();
		this.projectExecutionStatus = projectExecutionStatus;
		this.remedialActionDuration = remedialActionDuration;
	}
	
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public String getProjectExecutionStatus() {
		return projectExecutionStatus;
	}
	public void setProjectExecutionStatus(String projectExecutionStatus) {
		this.projectExecutionStatus = projectExecutionStatus;
	}
	public String getRemedialActionDuration() {
		return remedialActionDuration;
	}
	public void setRemedialActionDuration(String remedialActionDuration) {
		this.remedialActionDuration = remedialActionDuration;
	}

	@Override
	public String toString() {
		return "AuditResponse [auditId=" + auditId + ", projectExecutionStatus=" + projectExecutionStatus
				+ ", remedialActionDuration=" + remedialActionDuration + "]";
	}
	
}
