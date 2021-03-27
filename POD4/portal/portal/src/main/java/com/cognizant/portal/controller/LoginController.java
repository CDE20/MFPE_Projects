package com.cognizant.portal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portal.model.UserLoginCredential;
import com.cognizant.portal.model.UserToken;
import com.cognizant.portal.service.AuthFeignService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/user")
public class LoginController {



	@Autowired
	private AuthFeignService feignService;

	@GetMapping("/login")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredential usercredentials,
			BindingResult bindingresult) {

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginMessage", "Login");
		return modelAndView;
	}

	@GetMapping("/home")
	public String home() {

		
		return "homepage";
	}


	@PostMapping("/homepage")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredential usercredentials,
			BindingResult bindingresult, HttpSession session) {

		log.debug("username{}: ", usercredentials.getUserid());
		ResponseEntity<?> response = null;

		try {
			response = feignService.getToken(usercredentials);
		} catch (Exception e) {
			log.error("Invalid credentials");
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("loginMessage", "Bad Credentials");
			return modelAndView;
		}

		log.debug("Response{}: ", response);
		log.info("Getting body from response entity");

		UserToken userToken = (UserToken) response.getBody();

		log.debug("token{}:", userToken.getAuthToken());
		log.debug("userToken{}: ", userToken);

		session.setAttribute("token", userToken.getAuthToken());

		log.debug("session{}:", session.toString());

		ModelAndView modelAndView = new ModelAndView("homepage");
		return modelAndView;

	}


	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("token", null);
		return "logout";
	}

}
