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
		property1.setOwner(player1);
		assertEquals("New owner", player1, property1.getOwner());
	}
}
