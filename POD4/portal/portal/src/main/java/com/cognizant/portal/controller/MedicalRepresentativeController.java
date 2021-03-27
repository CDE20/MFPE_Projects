package com.cognizant.portal.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portal.model.RepSchedule;
import com.cognizant.portal.service.MedicalRepFeignService;
import com.cognizant.portal.util.DateUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/user")
@Controller
public class MedicalRepresentativeController {

	@Autowired
	private MedicalRepFeignService feignService;

	@RequestMapping("/schedule")
	public String getRepSchedule() {
		log.info("Start");
		return "giveRepScheduleDate";
	}

	@RequestMapping("/createSchedule")
	public ModelAndView createSchedule(@RequestParam("scheduleStartDate") String scheduleStartDate, HttpSession session)
			throws Exception {
		log.debug("dateOfMeeting {}:", scheduleStartDate);
		ModelAndView modelAndView = new ModelAndView();

		LocalDate date = DateUtil.convertToDate(scheduleStartDate);
		if (date.isBefore(LocalDate.now())) {
			modelAndView.addObject("errorMessage", true);
			modelAndView.setViewName("giveRepScheduleDate");
			return modelAndView;
		}

		String token = (String) session.getAttribute("token");
		log.debug("token {}:", token);
		ResponseEntity<?> response = feignService.getRepSchedule(token, scheduleStartDate);
		log.debug("response {}:", response);
		@SuppressWarnings("unchecked")
		List<RepSchedule> repScheduleList = (List<RepSchedule>) response.getBody();

		log.debug("medicineStock {}:", repScheduleList);
		modelAndView.setViewName("repScheduleList");
		modelAndView.addObject("repScheduleList", repScheduleList);
		return modelAndView;
	}

}
