package com.google.dojo.monopoly;

public class MonopolyPlayer {

	private int pos;
	private boolean in_prison;
	private int turns_in_jail;
	
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
				}
			}
		}

		// Normal movement rules.
		in_prison = false;
		pos  = (pos + i + j) % 40;
		if (pos == 30) { 
				pos = 10;
				in_prison = true;
				turns_in_jail = 0;
		}
	}

	public int GetSquare() {
		// TODO Auto-generated method stub
		return pos;
	}

	public void SetPosition(int i) {
		pos = i;
	}
	
}
