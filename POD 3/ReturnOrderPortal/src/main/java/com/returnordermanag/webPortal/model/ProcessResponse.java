package com.returnordermanag.webPortal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Entity
@Table(name = "process_response")
public class ProcessResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestID;
	private int userID;
	private double processingCharge;
	private double packagingAndDeliveryCharge;
	private String dateOfDelivery;
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getProcessingCharge() {
		return processingCharge;
	}
	public void setProcessingCharge(double processingCharge) {
		this.processingCharge = processingCharge;
	}
	public double getPackagingAndDeliveryCharge() {
		return packagingAndDeliveryCharge;
	}
	public void setPackagingAndDeliveryCharge(double packagingAndDeliveryCharge) {
		this.packagingAndDeliveryCharge = packagingAndDeliveryCharge;
	}
	public String getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(String dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public ProcessResponse(int requestID, int userID, double processingCharge, double packagingAndDeliveryCharge,
			String dateOfDelivery) {
		super();
		this.requestID = requestID;
		this.userID = userID;
		this.processingCharge = processingCharge;
		this.packagingAndDeliveryCharge = packagingAndDeliveryCharge;
		this.dateOfDelivery = dateOfDelivery;
	}
	public ProcessResponse() {
		super();
	}
	
	
}
