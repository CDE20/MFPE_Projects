package com.cognizant.portfoliomanagement.WebPortal.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SellObjectMapTest {

	SellObjectMap sellone=new SellObjectMap();
	
	@Test
	void testSellObjectMapIntMapOfStringIntegerMapOfStringInteger() {
		SellObjectMap sell1=new SellObjectMap(0, null, null);
	}

	@Test
	void testSetStockIdList() {
		sellone.setStockIdList(null);
		assertEquals(null,sellone.getStockIdList());
	}

	@Test
	void testSetMfAssetList() {
		sellone.setMfAssetList(null);
		assertEquals(null,sellone.getMfAssetList());
	}

	@Test
	void testSellObjectMap() {
		SellObjectMap sell=new SellObjectMap();
	}

	@Test
	void testToString() {
		SellObjectMap sell2=new SellObjectMap(0, null, null);
		assertEquals("SellObjectMap [pid=0, stockIdList=null, mfAssetList=null]",sell2.toString());
	}

}
