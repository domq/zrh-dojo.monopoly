package com.google.dojo.monopoly;

public class BeautyContestCard implements CommunityCard {

	@Override
	public void PlayerHasDrawnMe(MonopolyPlayer p) {
		p.SetMoney(p.GetMoney() + 50);
	}

}
