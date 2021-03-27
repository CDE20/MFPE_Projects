package com.cognizant.calculateNetworth.model;

import java.util.List;

public class SellObject {

	int pid;

	List<String> stockIdList;

	List<String> mfAssetList;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<String> getStockIdList() {
		return stockIdList;
	}

	public void setStockIdList(List<String> stockIdList) {
		this.stockIdList = stockIdList;
	}

	public List<String> getMfAssetList() {
		return mfAssetList;
	}

	public void setMfAssetList(List<String> mfAssetList) {
		this.mfAssetList = mfAssetList;
	}

	@Override
	public String toString() {
		return "SellObject [pid=" + pid + ", stockIdList=" + stockIdList + ", mfAssetList=" + mfAssetList + "]";
	}

	public SellObject(int pid, List<String> stockIdList, List<String> mfAssetList) {
		super();
		this.pid = pid;
		this.stockIdList = stockIdList;
		this.mfAssetList = mfAssetList;
	}

	public SellObject() {
		super();
	}

}
