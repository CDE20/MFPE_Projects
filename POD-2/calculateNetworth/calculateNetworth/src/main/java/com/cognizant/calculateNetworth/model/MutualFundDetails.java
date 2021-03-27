package com.cognizant.calculateNetworth.model;

public class MutualFundDetails {

	private String mutualFundId;
	private String mutualFundName;
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

	public MutualFundDetails(String mutualFundId, String mutualFundName, double mutualFundValue) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		this.mutualFundValue = mutualFundValue;
	}

	public MutualFundDetails() {
		super();
	}

	@Override
	public String toString() {
		return "MutualFundDetails [mutualFundId=" + mutualFundId + ", mutualFundName=" + mutualFundName
				+ ", mutualFundValue=" + mutualFundValue + "]";
	}

}
