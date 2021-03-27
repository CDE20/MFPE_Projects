package com.cognizant.portfoliomanagement.WebPortal.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class AssetTest {
	
	Asset asset=new Asset();
	
	@Test
	void testSetTid() {
		asset.setTid(1);
		assertEquals(1,asset.getTid());
	}

	@Test
	void testSetAssetid() {
		asset.setAssetid("101");
		assertEquals("101",asset.getAssetid());
	}

	@Test
	void testSetPortfolioid() {
		asset.setPortfolioid(11);
		assertEquals(11,asset.getPortfolioid());
	}

	@Test
	void testSetType() {
		asset.setType("MF");
		assertEquals("MF",asset.getType());
	}

	@Test
	void testSetUnits() {
		asset.setUnits(10);
		assertEquals(10,asset.getUnits());
	}

	@Test
	void testAssetIntStringIntStringInt() {
		Asset asset1=new Asset(1, "101", 11, "MF", 10);
	}

	@Test
	void testAsset() {
		Asset asset1=new Asset();
	}

	@Test
	void testToString() {
		Asset asset2=new Asset(1, "101", 11, "MF", 10);
		assertEquals("Asset [tid=0 assetid=null, portfolioid=0, type=null, units=0]",asset.toString());
	}


}
