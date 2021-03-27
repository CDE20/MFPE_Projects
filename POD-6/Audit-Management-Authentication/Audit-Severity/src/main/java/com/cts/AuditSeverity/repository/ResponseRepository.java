package com.cts.AuditSeverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.AuditSeverity.model.AuditResponseModel;
/**
 * 
 *
 */
@Repository
public interface ResponseRepository extends JpaRepository<AuditResponseModel, Integer> {

}
