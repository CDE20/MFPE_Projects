package com.returnordermanag.authorizationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.returnordermanag.authorizationService.Repository.UserRepository;
import com.returnordermanag.authorizationService.model.MyUser; 

@SpringBootApplication
public class JwtAuthenticationApplication {
	
	static Logger logger = LoggerFactory.getLogger(JwtAuthenticationApplication.class);
	
	@Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<MyUser> users = Stream.of(
               new MyUser("1","Mrunal","Mrunal"),
               new MyUser("2","Abhishek","Abhishek"),
               new MyUser("3","Harivivek","Harivivek"),
               new MyUser("4","Satyam","Satyam")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
		logger.info("Authentication module started successfully");
	}

}
