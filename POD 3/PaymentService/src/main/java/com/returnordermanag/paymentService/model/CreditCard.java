package com.returnordermanag.paymentService.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard {

	@Id
	private long cardNumber;
	private double cardLimit;
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public double getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(double cardLimit) {
		this.cardLimit = cardLimit;
	}
	public CreditCard(long cardNumber, double cardLimit) {
		super();
		this.cardNumber = cardNumber;
		this.cardLimit = cardLimit;
	}
	public CreditCard() {
		super();
	}
	
	

	
}
