package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Command;
import Model.Parser;

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


}
