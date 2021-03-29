package com.pensionManagementSystem.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionManagementSystem.client.AuthorizationMicroserviceClient;
import com.pensionManagementSystem.model.JWTResponse;
import com.pensionManagementSystem.model.User;

@Controller
public class LoginController {

	@Autowired
	AuthorizationMicroserviceClient authorizationMicroserviceClient;

	@GetMapping("/login")
	public String showLoginPage(@ModelAttribute User user) {
		return "login";
	}

	@PostMapping("/login")
	public String processLogin(@ModelAttribute User user, ModelMap model, HttpSession session) {

		ResponseEntity<?> token;
		try {
			token = authorizationMicroserviceClient.generateToken(user);
			HashMap<String, String> tokenBodyMap = (LinkedHashMap<String, String>) token.getBody();
			JWTResponse response = new JWTResponse(tokenBodyMap.get("token"));
			model.addAttribute("status", "Login Success!!");
			session.setAttribute("token", response.getToken());

		} catch (Exception e) {
			model.addAttribute("status", "Invalid Credentials!!");
			return "login";
		}

		return "redirect:/processPensionerInput";
	}
	
	@GetMapping("/logout")
	public String logoutUser(ModelMap model, HttpSession session) {

		boolean validated = authorizationMicroserviceClient.validateToken((String) session.getAttribute("token"));
		
		if (validated) {
			model.addAttribute("status", "Logout Successfully!");
		} else {
			model.addAttribute("status", "Wrong User!!");
		}
		session.invalidate();
		return "login";
	}

}
