package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.RiskModel;
import Model.Player;

class riskModelTest {

	RiskModel game;
	Player player;
	@BeforeEach
	void setUp() throws Exception {
		game = new RiskModel();
		
	}

	@Test
	final void testGame() {
	}


	@Test
	final void testCheckEnd() {
		boolean value = game.checkEnd();
		assertFalse(value);
	}


	@Test
	final void testIsNumeric() {
		boolean value = game.isNumeric("2");
		assertTrue(value);
	}

}
