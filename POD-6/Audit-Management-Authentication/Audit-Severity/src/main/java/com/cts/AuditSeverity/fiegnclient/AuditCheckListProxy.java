package com.cts.AuditSeverity.fiegnclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.AuditSeverity.pojo.AuditType;
import com.cts.AuditSeverity.pojo.QuestionsEntity;
/**
 * 
 *
 */
@FeignClient(url= "${audit.checklist.url}",name="audit-checklist")
public interface AuditCheckListProxy {
	
	@PostMapping("/getChecklist")
	public ResponseEntity<List<QuestionsEntity>> getChecklist(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditType auditType);
}
