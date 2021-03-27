package com.cognizant.calculateNetworth.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SellObjectTest {

	SellObject sell=new SellObject();
	
	@Test
	void testSetPid() {
		sell.setPid(1);
		assertEquals(1,sell.getPid());
	}

	@Test
	void testSetStockIdList() {
		List<String> mfAssetList=null;
		sell.setMfAssetList(mfAssetList);
		assertEquals(null,sell.getMfAssetList());
	}

	@Test
	void testSetMfAssetList() {
		List<String> stockIdList=null;
		sell.setStockIdList(stockIdList);
		assertEquals(null,sell.getStockIdList());
	}

	@Test
	void testToString() {
		SellObject sell1=new SellObject(1, null, null);
		assertEquals("SellObject [pid=1, stockIdList=null, mfAssetList=null]",sell1.toString());
	}

	@Test
	void testSellObjectIntListOfStringListOfString() {
		SellObject sell3=new SellObject(0, null, null);
	}

	@Test
	void testSellObject() {
		SellObject sell2=new SellObject();
	}

}
