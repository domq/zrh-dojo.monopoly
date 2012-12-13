package com.google.dojo.monopoly;

public class MonopolyPlayer {

	private int pos;
	
	MonopolyPlayer() {
		pos = 0;
	}

	public void MoveByDice(int i, int j) {
		pos  = (pos + i + j) % 40;
	}

	public int GetSquare() {
		// TODO Auto-generated method stub
		return pos;
	}

	public void SetPosition(int i) {
		pos = i;
		
	}
	
	

}
