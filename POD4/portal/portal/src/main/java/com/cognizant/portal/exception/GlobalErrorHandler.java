package com.cognizant.portal.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {


	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllErrors(Exception ex) {
		log.info("Start");
		ModelAndView modelAndView = new ModelAndView("tokenExpired");
		return modelAndView;
	}

	@ExceptionHandler(MedicineNotFoundException.class)
	public ModelAndView handleAllMedicineStockErrors(MedicineNotFoundException ex) {
		log.info("Start");
		ModelAndView modelAndView = new ModelAndView("medicineNotFound");
		return modelAndView;
	}

}
