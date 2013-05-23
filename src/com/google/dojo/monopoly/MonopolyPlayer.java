package com.google.dojo.monopoly;

public class MonopolyPlayer {

	private int pos;
	private boolean in_prison;
	private int turns_in_jail;
	private int money = 1500;
	private CommunityCard next_community_card;
	
	private Board board = new Board();

	MonopolyPlayer() {
		pos = 0;
		in_prison = false;
		
		
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
		int new_pos = pos + i + j;
		if (new_pos > 40) {
			money += 200;
		}
		pos = new_pos % 40;
		board.DealWithSquareEffects(this);
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

	public void chargeMoney(int amount) {
		if (amount > money) {
			throw new BrokePlayerException();
		}
		money -= amount;
	}

	public void earnMoney(int amount) {
		setMoney(getMoney() + amount);
	}
}
