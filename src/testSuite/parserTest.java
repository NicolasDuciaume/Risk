package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Command;
import model.Parser;

class parserTest {
	Parser parser;
	@BeforeEach
	void setUp() throws Exception {
		parser = new Parser();
	}

	@Test
	final void testParser() {
	}

	@Test
	final void testGetCommands() {
		String[] commands = parser.getCommands();
		String command = "";
		for(String s: commands) {
			command += s + " ";
		}
		assertEquals("help attack map pass quit ", command);
	}

	@Test
	final void testGetUserInput() {
		String input = parser.getUserInput();
		assertEquals("help attack map pass quit", input);
	}

}
