package com.cognizant.portal.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DateUtil {

	public static LocalDate convertToDate(String date) {

		LocalDate localDate = null;

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			localDate = LocalDate.parse(date, formatter);

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.debug("date : {}", localDate);

		return localDate;
	}
}