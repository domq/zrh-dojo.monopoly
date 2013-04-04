package com.google.dojo.monopoly;

public class Board {
	private Square[] board = new Square[40];

	public Board() {
		board[0] = new GoSquare();
		board[2] = board[17] = board[33] = new CommunityChestSquare();
		board[4] = new IncomeTaxSquare();
		board[30] = new GoToPrisonSquare();
		board[38] = new LuxuryTaxSquare();
	}

	public Square getSquareAt(int index) {
		return board[index];
	}

	void DealWithSquareEffects(MonopolyPlayer monopolyPlayer) {
		if (getSquareAt(monopolyPlayer.GetSquare() ) != null) { // TODO: this is only scaffolding until every square has an effect.
			getSquareAt(monopolyPlayer.GetSquare()).playerArrivedToMe(monopolyPlayer);
		}
	}

}