package com.google.dojo.monopoly;

public class Board {
	private Square[] board = new Square[40];

	public Board() {
		board[2] = new CommunityChestSquare();
		board[4] = new IncomeTaxSquare();
		board[30] = new GoToPrisonSquare();
		board[38] = new LuxuryTaxSquare();
	}

	public Square[] getBoard() {
		return board;
	}

	public void setBoard(Square[] board) {
		this.board = board;
	}
}