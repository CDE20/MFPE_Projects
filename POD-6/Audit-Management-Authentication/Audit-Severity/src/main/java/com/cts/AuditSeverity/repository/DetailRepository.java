package com.cts.AuditSeverity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.AuditSeverity.model.AuditDetailModel;
/**
 * 
 *
 */
@Repository
public interface DetailRepository extends JpaRepository<AuditDetailModel, Integer> {

	
}

