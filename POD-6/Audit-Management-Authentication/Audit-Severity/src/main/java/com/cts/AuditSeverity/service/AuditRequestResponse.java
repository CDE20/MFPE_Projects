package com.cts.AuditSeverity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.AuditSeverity.model.AuditDetailModel;
import com.cts.AuditSeverity.model.AuditRequestModel;
import com.cts.AuditSeverity.model.AuditResponseModel;
import com.cts.AuditSeverity.pojo.AuditRequest;
import com.cts.AuditSeverity.pojo.AuditResponse;
import com.cts.AuditSeverity.repository.RequestRepository;
import com.cts.AuditSeverity.repository.ResponseRepository;
/**
 * 
 *
 */
@Service
public class AuditRequestResponse {
	
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private ResponseRepository responseRepository;
	/**
	 * 	
	 * @param request
	 * @return AuditRequestModel
	 */
	public AuditRequestModel saveRequest(AuditRequest request) {
		AuditRequestModel requestModel = new AuditRequestModel();
		AuditDetailModel auditDetailModel = new AuditDetailModel(request.getAuditDetails().getAuditType());
		requestModel.setAuditDetail(auditDetailModel);
		requestModel.setProjectName(request.getProjectName());
		requestModel.setManagerName(request.getProjectManagerName());
		requestModel.setOwnerName(request.getApplicationOwnerName());
		return requestRepository.save(requestModel);
	}
	/**
	 * 
	 * @param response
	 * @return AuditResponseModel
	 */
	public AuditResponseModel saveResponse(AuditResponse response) {
		AuditResponseModel responseModel = new AuditResponseModel(response.getProjectExecutionStatus(),response.getRemedialActionDuration());
		return responseRepository.save(responseModel);
	}
	
	
}