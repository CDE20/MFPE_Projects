package com.pensionerDetailsMicroservice.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.jandex.Main;

public class DateUtil {

	public static Date parseDate(String date) throws ParseException {
		return new SimpleDateFormat("dd-MM-yyyy").parse(date);
	}

	public static void main(String[] args) throws ParseException {
	}
}
