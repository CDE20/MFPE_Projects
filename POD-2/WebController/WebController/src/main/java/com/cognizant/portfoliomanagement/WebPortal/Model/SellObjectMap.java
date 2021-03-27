package com.cognizant.portfoliomanagement.WebPortal.Model;

import java.util.List;
import java.util.Map;

public class SellObjectMap {

	int pid;

	Map<String,Integer> stockIdList;

	Map<String,Integer> mfAssetList;

	public int getPid() {
		return pid;
	}

	
	public SellObjectMap(int pid, Map<String, Integer> stockIdList, Map<String, Integer> mfAssetList) {
		super();
		this.pid = pid;
		this.stockIdList = stockIdList;
		this.mfAssetList = mfAssetList;
	}


	public Map<String, Integer> getStockIdList() {
		return stockIdList;
	}


	public void setStockIdList(Map<String, Integer> stockIdList) {
		this.stockIdList = stockIdList;
	}


	public Map<String, Integer> getMfAssetList() {
		return mfAssetList;
	}


	public void setMfAssetList(Map<String, Integer> mfAssetList) {
		this.mfAssetList = mfAssetList;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public SellObjectMap() {
		super();
	}


	@Override
	public String toString() {
		return "SellObjectMap [pid=" + pid + ", stockIdList=" + stockIdList + ", mfAssetList=" + mfAssetList + "]";
	}

}
