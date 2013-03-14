package com.google.dojo.monopoly;

public class LuxuryTaxSquare implements Square {
	/**
	 * 
	 */

	/**
	 * @param monopolyPlayer
	 */

	public void playerArrivedToMe(MonopolyPlayer monopolyPlayer) {
		monopolyPlayer.setMoney(monopolyPlayer.getMoney() - 100);
	}
}