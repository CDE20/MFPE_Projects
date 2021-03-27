package com.returnordermanag.webPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanag.webPortal.model.UserDetails;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserDetails, Integer>{

}
