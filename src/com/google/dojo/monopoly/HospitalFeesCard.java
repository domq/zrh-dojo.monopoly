package com.google.dojo.monopoly;

public class HospitalFeesCard implements CommunityCard {

	@Override
	public void PlayerHasDrawnMe(MonopolyPlayer p) {
		p.setMoney(p.getMoney() - 100);
	}

}