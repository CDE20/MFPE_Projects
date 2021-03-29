package com.pensionManagementSystem.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionManagementSystem.client.AuthorizationMicroserviceClient;
import com.pensionManagementSystem.client.ProcessPensionMicroserviceClient;
import com.pensionManagementSystem.model.PensionDetail;
import com.pensionManagementSystem.model.PensionerInput;

@Controller
public class PensionerInputController {
	@Autowired
	ProcessPensionMicroserviceClient processPensionMicroserviceClient;

	@Autowired
	AuthorizationMicroserviceClient authorizationMicroserviceClient;

	boolean invalidInput = false;

	@GetMapping("/processPensionerInput")
	public String showPensionerInputForm(@ModelAttribute PensionerInput pensionerInput, HttpSession session,
			ModelMap model) {
		boolean validated = authorizationMicroserviceClient.validateToken((String) session.getAttribute("token"));
		if (validated) {
			if (invalidInput) {
				model.addAttribute("status", "Wrong Pension Data!!");
				invalidInput = false;
			}
			return "pensionerInput";
		}
		return "redirect:/login";
	}

	/*
	 * { "name" : "Shubham", "dateOfBirth" : "1999-01-29", "pan" : "PCASD1234Q",
	 * "aadharNumber" : 123456789012, "pensionType" : "self" }
	 */
	@PostMapping("/getPensionerDetail")
	public String fetchDetails(@ModelAttribute PensionerInput pensionerInput, BindingResult result, HttpSession session,
			ModelMap model) {

		System.out.println(pensionerInput);

		PensionDetail pensionDetail = processPensionMicroserviceClient.getPensionDetails(pensionerInput);
		System.out.println("Details: " + pensionDetail);

		if (pensionDetail == null) {
			invalidInput = true;
			return "redirect:/processPensionerInput";
		}

		model.addAttribute("pensionDetail", pensionDetail);
		return "pensionDisbursement";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@GetMapping("/disbursement")
	public String successfulDisbursement(ModelMap model,HttpSession session) {
		boolean validated = authorizationMicroserviceClient.validateToken((String) session.getAttribute("token"));
		if (validated) {
			model.addAttribute("msg", "Congratulations!!");
			model.addAttribute("info", "Amount has been disbursed to your bank account.");
			return "success";
		}
		model.addAttribute("status","Error in disbursement");
		return "pensionDisbursement" ;
	}

}
