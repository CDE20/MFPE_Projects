package com.cognizant.authorization.config;

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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognizant.authorization.service.CustomerDetailsService;
import com.cognizant.authorization.service.JwtRequestFilter;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is used for the security configuration. It extends the class
 * WebSecurityConfigurerAdapter It will take care of the authentication and
 * authorization based on the user credentials.
 */
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

	/**
	 * This method is used for the configuration of authorization part.And all the
	 * requests which starts with '/login' and all other requests will be
	 * authenticated and permitted.
	 */
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

	/**
	 * Password encoder is an interface which is used through the authorization
	 * process. The encode function shall be used to encode the password.
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		log.info("START");
		log.info("END");
		return NoOpPasswordEncoder.getInstance();
	}
	

	/**
	 * We are authorizing the requests over here. The URL we are giving to the
	 * method antMatchers(), these URL's should not be put behind the authentication
	 * wall.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		log.info("START");
		IgnoredRequestConfigurer antMatchers = web.ignoring().antMatchers("/login", "/h2-console/**",
				"/configuration/ui", "/configuration/security", "/webjars/**", "/manage/health/**");
		log.debug("ANT MATCHERS{}:", antMatchers);
		log.info("END");
	}

}
