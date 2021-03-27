package com.cognizant.authorization.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity.IgnoredRequestConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognizant.authorization.service.CustomerDetailsService;
import com.cognizant.authorization.service.JwtRequestFilter;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("deprecation")
@Slf4j
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private CustomerDetailsService emsuserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("START");
		super.configure(auth);
		auth.userDetailsService(emsuserDetailsService);
		log.info("END");
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("START");
		SessionManagementConfigurer<HttpSecurity> sessionCreationPolicy = http.csrf().disable().authorizeRequests()
				.antMatchers("/login").permitAll().anyRequest().authenticated().and().exceptionHandling().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		log.debug("SESSION CREATE POLICY {}:", sessionCreationPolicy);
		HttpSecurity addFilterBefore = http.addFilterBefore(jwtRequestFilter,
				UsernamePasswordAuthenticationFilter.class);
		log.debug("ADD FILTER BEFORE{}:", addFilterBefore);
		log.info("END");
	}


	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		log.info("START");
		log.info("END");
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		log.info("START");
		log.info("END");
		return NoOpPasswordEncoder.getInstance();
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		log.info("START");
		IgnoredRequestConfigurer antMatchers = web.ignoring().antMatchers("/login", "/h2-console/**", "/v2/api-docs",
				"/configuration/ui", "/configuration/security",
				"/webjars/**", "/manage/health/**");
		log.debug("ANT MATCHERS{}:", antMatchers);
		log.info("END");
	}

}
