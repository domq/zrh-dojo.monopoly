package com.google.dojo.monopoly;

public class BeautyContestCard implements CommunityCard {

	@Override
	public void PlayerHasDrawnMe(MonopolyPlayer p) {
		p.earnMoney(50);
	}

}
