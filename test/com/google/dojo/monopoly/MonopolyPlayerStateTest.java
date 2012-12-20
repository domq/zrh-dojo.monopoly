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

	}
	
	public void PutInJail(MonopolyPlayer p) {
		p.SetPosition(23);
		p.MoveByDice(6, 1);
		assertEquals("Now in jail", p.GetSquare(), 10);
	}
	
	@Test
	public void JailTestsSquare() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		PutInJail(player1);
		player1.MoveByDice(1, 2);
		assertEquals("Still in jail", player1.GetSquare(), 10);
		
		player1.MoveByDice(2, 2);
		assertEquals("Free at last!", player1.GetSquare(), 14);	
		
		player1.MoveByDice(2, 3);
		assertEquals("should move here", player1.GetSquare(), 19);
	}
	@Test
	public void JailTestsChances() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		PutInJail(player1);
		player1.MoveByDice(1, 2);
		assertEquals("Still in jail", player1.GetSquare(), 10);
		player1.MoveByDice(1, 2);
		assertEquals("Still in jail", player1.GetSquare(), 10);
		
		// Third time no double; player has to pay out of jail,
		// and keep the same dice to play.
		player1.MoveByDice(1, 2);
		assertEquals("Had to pay his way out, but keeps the same dice",
				player1.GetSquare(), 13);
	}
	
	@Test
	public void PlayerStartsWith1500Bucks() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		assertEquals(player1.GetMoney(), 1500);
	}

	@Test
	public void JailTestsGoingOutCostsMoney() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		PutInJail(player1);
		player1.MoveByDice(1, 2);
		player1.MoveByDice(1, 2);
		
		// Third time no double; player has to pay out of jail,
		// and keep the same dice to play.
		// TODO: check balance went down by $50.
		player1.MoveByDice(1, 2);
		assertEquals("Amount of money after pay out.", player1.GetMoney(), 1450);
	}
	
	@Test
	public void SimpleVisit() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		player1.SetPosition(7);
		player1.MoveByDice(2, 1);
		assertEquals(player1.GetSquare(), 10);
		player1.MoveByDice(1, 2);
		assertEquals("This was a simple visit", player1.GetSquare(), 13);
	}
	
	/////////////////////////////////////////////////////////
	@Test
	public void IncomeTax() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		player1.MoveByDice(1, 3);
		assertEquals("Income tax costs $200 to rich people", player1.GetMoney(), 1300);
	}
	
	@Test
	public void LuxoryTax() {
		MonopolyPlayer player1 = new MonopolyPlayer();
		player1.SetPosition(30);
		player1.MoveByDice(2, 6);
		assertEquals("Luxory tax costs $100.", player1.GetMoney(), 1400);
	}
}
