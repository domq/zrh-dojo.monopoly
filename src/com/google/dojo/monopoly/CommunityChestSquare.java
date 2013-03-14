package com.google.dojo.monopoly;

public class CommunityChestSquare implements Square {
	

	/**
	 * 
	 */

	public void playerArrivedToMe(MonopolyPlayer monopolyPlayer) {
		monopolyPlayer.getNextCommunityCard().PlayerHasDrawnMe(monopolyPlayer);
	}
}