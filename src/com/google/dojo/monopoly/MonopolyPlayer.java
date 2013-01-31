package com.google.dojo.monopoly;

public class MonopolyPlayer {
	
	public interface Square {
		void ArriveTo();
	}

	public class IncomeTaxSquare implements Square {
		public void ArriveTo() {
			if (money < 1000) {
				money = (money * 4)/5;
			}
			else
			{
				money -= 200;
			}
		}
	}
	
	public class LuxuryTaxSquare implements Square {
		public void ArriveTo() {
			money -= 100;
		}
	}
	
	public class GoToPrisonSquare implements Square {
		public void ArriveTo() {
			pos = 10;
			in_prison = true;
			turns_in_jail = 0;
		}
	}
	

	private int pos;
	private boolean in_prison;
	private int turns_in_jail;
	private int money = 1500;
	
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
		if (board[pos] != null) { // TODO: this is only scaffolding until every square has an effect.
			board[pos].ArriveTo();
		}
	}

	public int GetSquare() {
		return pos;
	}

	public void SetPosition(int i) {
		pos = i;
	}
	
	public int GetMoney() {
		return money;
	}

	public void SetMoney(int i) {
		money = i;
	}
	
	public class CommunityChestSquare implements Square {
		public void ArriveTo() {
			money += 50;		
			}
	}
}
