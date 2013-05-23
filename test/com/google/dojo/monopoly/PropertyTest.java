package com.google.dojo.monopoly;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertyTest {

	@Test
	public void checkPropertyCanBeBoughtOnlyOnce() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		MonopolyProperty property1 = new MonopolyProperty();
		property1.setOwner(player1);
		assertEquals("Property not for sale.", false, property1.isForSale());
	}
	
	@Test
	public void firstBuy() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		MonopolyProperty property1 = new MonopolyProperty();
		assertEquals("Property for sale.", true, property1.isForSale());
		property1.sellFromBank(player1);
		assertEquals("New owner", player1, property1.getOwner());
	}

	@Test
	public void secondBuyShouldFail() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		MonopolyProperty property1 = new MonopolyProperty();
		property1.sellFromBank(player1);

		try {
			property1.sellFromBank(player1);
			fail("Should have thrown — Property already sold!");
		} catch (ForbiddenSaleException e) {
			// Nothing - We are happy
		}
		assertEquals("New owner", player1, property1.getOwner());
	}
	
	@Test
	public void propertyPrice() {
		int value = 100;
		MonopolyProperty property1 = new MonopolyProperty(value);
		assertEquals("Property price", 100, property1.getValue());
	}
	
	@Test
	public void propertySaleValue() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		MonopolyProperty property1 = new MonopolyProperty();
		property1.sellFromBank(player1);
		assertEquals("Charge for the property", 1300, player1.getMoney());
	}
	
	@Test
	public void brokePlayer() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		MonopolyProperty property1 = new MonopolyProperty(1600);
		try {
			property1.sellFromBank(player1);
			fail("Should have thrown — BrokePlayerException");
		} catch (BrokePlayerException e) {
			// OK
		}
	}
	
}
