package com.cognizant.portfoliomanagement.WebPortal.Model;


import org.springframework.stereotype.Component;

@Component
public class Asset {
	
	
	private int tid;
	
	
	
	private String assetid;
	
	private int portfolioid;
	
	private String type;
	
	private int units;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getAssetid() {
		return assetid;
	}
	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}
	public int getPortfolioid() {
		return portfolioid;
	}
	public void setPortfolioid(int portfolioid) {
		this.portfolioid = portfolioid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public Asset(int tid,String assetid, int portfolioid, String type, int units) {
		super();
		this.tid = tid;
		this.assetid = assetid;
		this.portfolioid = portfolioid;
		this.type = type;
		this.units = units;
	}
	public Asset() {
		super();
	}
	@Override
	public String toString() {
		return "Asset [tid="+tid+ " assetid=" + assetid + ", portfolioid=" + portfolioid + ", type=" + type + ", units=" + units
				+ "]";
	}
	

}
