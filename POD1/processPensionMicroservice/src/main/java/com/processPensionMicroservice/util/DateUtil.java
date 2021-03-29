package com.processPensionMicroservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date parseDate(String date) throws ParseException {

		return new SimpleDateFormat("dd-MM-yyyy").parse(date);

	}

}
