package com.returnordermanag.webPortal.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name = "process_request")
public class ProcessRequest {

	@Id
	private int userID;
	private String username;
	private long contactNumber;
	private long creditCardNumber;
	private String componentType;
	private String componentName;
	private int quantityOfDefective;
	private boolean isPriorityRequest;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getComponentType() {
		return componentType;
	}
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public int getQuantityOfDefective() {
		return quantityOfDefective;
	}
	public void setQuantityOfDefective(int quantityOfDefective) {
		this.quantityOfDefective = quantityOfDefective;
	}
	public boolean isPriorityRequest() {
		return isPriorityRequest;
	}
	public void setPriorityRequest(boolean isPriorityRequest) {
		this.isPriorityRequest = isPriorityRequest;
	}
	public ProcessRequest(int userID, String username, long contactNumber, long creditCardNumber, String componentType,
			String componentName, int quantityOfDefective, boolean isPriorityRequest) {
		super();
		this.userID = userID;
		this.username = username;
		this.contactNumber = contactNumber;
		this.creditCardNumber = creditCardNumber;
		this.componentType = componentType;
		this.componentName = componentName;
		this.quantityOfDefective = quantityOfDefective;
		this.isPriorityRequest = isPriorityRequest;
	}
	public ProcessRequest() {
		super();
	}
	
	

}
