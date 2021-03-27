package com.returnordermanag.paymentService.exception;

import java.util.List;

public class Errormsg {
	 private String message;
	 private List<String> details;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public Errormsg(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}
	public Errormsg() {
		super();
	}
	 
	 
}