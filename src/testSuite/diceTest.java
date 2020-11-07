package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Dice;

class diceTest {

	Dice dice;
	@BeforeEach
	void setUp() throws Exception {
		dice = new Dice();
	}

	@Test
	final void testDice() {
	}

	@Test
	final void testRollDice() {
		dice.rollDice();
		int size = dice.getRoll();
		
		assertEquals(1, size);
	}
	@Test
	final void testGetRoll() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		dice.rollDice();
		assertTrue(numbers.contains(dice.getRoll()));
	}
	
	@Test
	final void testRoll() {
		int[] numbers = dice.roll(2);
		int size = numbers.length;
		assertEquals(2, size);
	}
}
