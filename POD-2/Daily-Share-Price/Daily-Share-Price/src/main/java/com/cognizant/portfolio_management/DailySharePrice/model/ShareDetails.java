package com.cognizant.portfolio_management.DailySharePrice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ShareDetails {
	@Id
	@Column
	private String shareId;
	@Column(name="share_name")
	private String shareName;
	@Column
	private double shareValue;

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public ShareDetails(String shareId, String shareName, double shareValue) {
		super();
		this.shareId = shareId;
		this.shareName = shareName;
		this.shareValue = shareValue;
	}

	public ShareDetails() {
		super();
	}

	@Override
	public String toString() {
		return "ShareDetails [shareId=" + shareId + ", shareName=" + shareName + ", shareValue=" + shareValue + "]";
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public double getShareValue() {
		return shareValue;
	}

	public void setShareValue(double shareValue) {
		this.shareValue = shareValue;
	}

}
