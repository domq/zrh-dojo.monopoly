package com.google.dojo.monopoly;

public class IncomeTaxSquare implements Square {
	/**
	 * 
	 */
		/**
	 * @param monopolyPlayer
	 */
	
	public void playerArrivedToMe(MonopolyPlayer monopolyPlayer) {
		if (monopolyPlayer.getMoney() < 1000) {
			monopolyPlayer.setMoney((monopolyPlayer.getMoney() * 4)/5);
		}
		else
		{
			monopolyPlayer.setMoney(monopolyPlayer.getMoney() - 200);
		}
	}
}