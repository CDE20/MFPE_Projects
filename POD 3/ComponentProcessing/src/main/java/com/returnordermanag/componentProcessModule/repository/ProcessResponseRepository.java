package com.returnordermanag.componentProcessModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanag.componentProcessModule.model.ProcessResponse;

@Repository
public interface ProcessResponseRepository extends JpaRepository<ProcessResponse, Integer> {
	
}
