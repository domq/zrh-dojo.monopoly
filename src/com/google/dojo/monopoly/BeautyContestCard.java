package com.google.dojo.monopoly;

public class BeautyContestCard implements CommunityCard {

	@Override
	public void PlayerHasDrawnMe(MonopolyPlayer p) {
		p.setMoney(p.getMoney() + 50);
	}

}
