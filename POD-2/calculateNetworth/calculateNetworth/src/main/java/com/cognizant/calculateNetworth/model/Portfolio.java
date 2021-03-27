package com.cognizant.calculateNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Portfolio {
	@Id
	@Column
	private int portfolioId;

	public Portfolio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Portfolio(int portfolioId) {
		super();
		this.portfolioId = portfolioId;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + "]";
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}


}