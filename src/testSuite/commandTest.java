package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Command;

class commandTest {
	String command;
	String unknown;
	@BeforeEach
	void setUp() throws Exception {
		command = "quit";
		unknown = "test";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testCommand() {
		
	}

	@Test
	final void testGetCommandWord() {
		String commandWord = (new Command(command)).getCommandWord();
		assertEquals("quit", commandWord);
	}

	@Test
	final void testIsUnknown() {
		String commandWord = (new Command(unknown)).getCommandWord();
		assertEquals(unknown, commandWord);
	}

}
