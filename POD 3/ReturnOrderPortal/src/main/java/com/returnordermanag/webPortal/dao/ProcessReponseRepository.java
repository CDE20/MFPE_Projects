package com.returnordermanag.webPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanag.webPortal.model.ProcessResponse;

@Repository
public interface ProcessReponseRepository extends JpaRepository<ProcessResponse, Integer> {

}
