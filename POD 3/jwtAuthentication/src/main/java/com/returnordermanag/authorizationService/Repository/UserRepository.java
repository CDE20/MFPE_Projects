package com.returnordermanag.authorizationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnordermanag.authorizationService.model.MyUser;

public interface UserRepository extends JpaRepository<MyUser,String > {

	public MyUser findByUsername(String username);

	

}
