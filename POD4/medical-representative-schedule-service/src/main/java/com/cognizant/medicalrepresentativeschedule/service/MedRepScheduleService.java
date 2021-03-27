package com.cognizant.medicalrepresentativeschedule.service;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.cognizant.medicalrepresentativeschedule.model.RepSchedule;

public interface MedRepScheduleService {
	public List<RepSchedule> getRepSchedule(String token, LocalDate scheduleStartDate)
			throws TokenValidationFailedException;

}
