package com.returnordermanag.webPortal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanag.webPortal.model.ProcessRequest;

@Repository
public interface ProcessRequestRepository extends CrudRepository<ProcessRequest, Integer> {

	
	
}
