package com.google.dojo.monopoly;

public class MonopolyPlayer {

	private int pos;
	private boolean in_prison;
	private int turns_in_jail;
	private int money = 1500;
	
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
					money -= 50;
				}
			}
		}

		// Normal movement rules.
		in_prison = false;
		pos  = (pos + i + j) % 40;
		DealWithSquareEffects();
	}
	
	private void DealWithSquareEffects() {
		switch(pos) {
		case 4: // Income tax
			money -= 200;
			break;
		case 30: // Go to Prison
			pos = 10;
			in_prison = true;
			turns_in_jail = 0;
			break;
		case 38: // Luxury tax
			money -= 100;
			break;
		}
	}

	public int GetSquare() {
		// TODO Auto-generated method stub
		return pos;
	}

	public void SetPosition(int i) {
		pos = i;
	}
	
	public int GetMoney() {
		return money;
	}
}
