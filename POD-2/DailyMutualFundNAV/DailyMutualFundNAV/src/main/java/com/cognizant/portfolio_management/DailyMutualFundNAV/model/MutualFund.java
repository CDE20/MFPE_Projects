package com.cognizant.portfolio_management.DailyMutualFundNAV.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MutualFund {
	@Id
	@Column
	private String mutualFundId;
	@Column
	private String mutualFundName;
	@Column
	private double mutualFundValue;
	
	public String getMutualFundId() {
		return mutualFundId;
	}
	
	public void setMutualFundId(String mutualFundId) {
		this.mutualFundId = mutualFundId;
	}
	
	public String getMutualFundName() {
		return mutualFundName;
	}
	
	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}
	
	public double getMutualFundValue() {
		return mutualFundValue;
	}
	
	public void setMutualFundValue(double mutualFundValue) {
		this.mutualFundValue = mutualFundValue;
	}
	
	@Override
	public String toString() {
		return "MutualFund [mutualFundId=" + mutualFundId + ", mutualFundName=" + mutualFundName + ", mutualFundValue="
				+ mutualFundValue + "]";
	}
	
	public MutualFund() {
		super();
	}
	
	public MutualFund(String mutualFundId, String mutualFundName, double mutualFundValue) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		this.mutualFundValue = mutualFundValue;
	}
}
