package com.google.dojo.monopoly;

public class HospitalFeesCard implements CommunityCard {

	@Override
	public void PlayerHasDrawnMe(MonopolyPlayer p) {
		p.chargeMoney(100);
	}

}
