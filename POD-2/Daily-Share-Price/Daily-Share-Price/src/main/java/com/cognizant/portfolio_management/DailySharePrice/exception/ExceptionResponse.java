package com.cognizant.portfolio_management.DailySharePrice.exception;

import java.util.Date;

public class ExceptionResponse {

	public ExceptionResponse(Date timeStamp, String details, String message) {
		super();
		this.timeStamp = timeStamp;
		this.details = details;
		this.message = message;
	}

	private Date timeStamp;
	private String details;
	private String message;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ExceptionResponse() {
		super();
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", details=" + details + ", message=" + message + "]";
	}
}
