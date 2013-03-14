package com.google.dojo.monopoly;

public class MonopolyPlayer {

	private int pos;
	private boolean in_prison;
	private int turns_in_jail;
	private int money = 1500;
	private CommunityCard next_community_card;
	
	private Square[] board;
	
	MonopolyPlayer() {
		pos = 0;
		in_prison = false;
		
		board = new Square[40];
		board[2] = new CommunityChestSquare();
		board[4] = new IncomeTaxSquare();
		board[30] = new GoToPrisonSquare();
		board[38] = new LuxuryTaxSquare();
	}

	public void MoveByDice(int i, int j) {
		if (in_prison) {
			if (i != j) {
				turns_in_jail = turns_in_jail + 1;
				if (turns_in_jail < 3) {
				  return;
				} else {
					// Payer needs to pay his way out of jail,
					// but keeps the same dice to play (don't return)
					setMoney(getMoney() - 50);
				}
			}
		}

		// Normal movement rules.
		in_prison = false;
		pos  = (pos + i + j) % 40;
		DealWithSquareEffects();
	}
	
	private void DealWithSquareEffects() {
		if (board[pos] != null) { // TODO: this is only scaffolding until every square has an effect.
			board[pos].playerArrivedToMe(this);
		}
	}

	public int GetSquare() {
		return pos;
	}

	public void SetPosition(int i) {
		pos = i;
	}
		
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	void putToPrison(GoToPrisonSquare goToPrisonSquare) {
		pos = 10;
		in_prison = true;
		turns_in_jail = 0;
	}

	public CommunityCard getNextCommunityCard() {
		return next_community_card;
	}

	public void setNextCommunityCard(CommunityCard next_community_card) {
		this.next_community_card = next_community_card;
	}
}
