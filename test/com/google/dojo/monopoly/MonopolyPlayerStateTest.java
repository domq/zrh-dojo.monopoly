package com.google.dojo.monopoly;

import static org.junit.Assert.*;
import com.google.dojo.monopoly.MonopolyPlayer;

import org.junit.Test;

public class MonopolyPlayerStateTest {

	@Test
	public void BasicMovement() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		// Player one starts from "Go" and rolls 5-1.
		player1.MoveByDice(5,1);
		assertEquals(player1.GetSquare(), 6);
		
		
		player1.SetPosition(39);
		player1.MoveByDice(5,1);
		assertEquals(player1.GetSquare(), 5);
		
		MonopolyPlayer player2 = new MonopolyPlayer();
		// Player 2 starts from position 35 and rolls 3-2
		player2.SetPosition(35);
		player2.MoveByDice(3,2);
		assertEquals(player2.GetSquare(), 0);
		
		/*
		player1_position = 
		assertEquals(6, player1_position);
		// Player one rolls 5-1.
		player1_position = MonopolyPlayer.RollDice(player1_position,5,1);
		assertEquals(12, player1_position);
		// Assuming Player one went all the way to 39 somehow,
		player1_position = 39;
		// he rolls 5-1.
		player1_position = MonopolyPlayer.RollDice(player1_position,5,1);
		assertEquals(5, player1_position);
	
		// Player 2 rolls 5-1.
		player2_position = MonopolyPlayer.RollDice(player2_position,5,1);
		assertEquals(6, player2_position);
		// Player one rolls 3-4.
		player1_position = MonopolyPlayer.RollDice(player1_position,3,4);
		assertEquals(12, player1_position);
		*/
	}

}
