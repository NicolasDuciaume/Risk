package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Game;
import model.Player;

class gameTest {

	Game game;
	Player player;
	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
		
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
	final void testPlayerSelection() {
		game.playerSelection("2");
		int expectedSize = 2;
		int size  = game.PlayersInGame.size();
		assertEquals(expectedSize, size);
	}

	@Test
	final void testIsNumeric() {
		boolean value = game.isNumeric("2");
		assertTrue(value);
	}

}
