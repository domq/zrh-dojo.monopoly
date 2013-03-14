package com.google.dojo.monopoly;

public class GoToPrisonSquare implements Square {
	/**
	 * 
	 */
	public void playerArrivedToMe(MonopolyPlayer monopolyPlayer) {
		monopolyPlayer.putToPrison(this);
	}
}