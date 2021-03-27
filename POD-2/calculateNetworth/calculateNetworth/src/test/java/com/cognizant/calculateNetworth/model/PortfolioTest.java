package com.cognizant.calculateNetworth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PortfolioTest {

	@Test
	void testPortfolio() {
		Portfolio portfolio=new Portfolio();
	}

	@Test
	void testPortfolioInt() {
		Portfolio portfolio=new Portfolio(1);
	}

	@Test
	void testToString() {
		Portfolio portfolio=new Portfolio(1);
		assertEquals("Portfolio [portfolioId=1]",portfolio.toString());
	}

	@Test
	void testSetPortfolioId() {
		Portfolio portfolio=new Portfolio();
		portfolio.setPortfolioId(1);
		assertEquals(1,portfolio.getPortfolioId());
	}

}
