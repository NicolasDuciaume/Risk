/*
Author: Kamran Sagheir & Hussain Al-Baidhani
 */
package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.CommandWords;

/*
A test class for the class commandWords
*/

class commandWordsTest {
	String[] commandWords;
	String word;
	@BeforeEach
	void setUp() throws Exception {
		commandWords = new String[] {"help", "attack", "map", "pass", "quit"};
		word = "test";
	}
	@AfterEach
	void tearDown() throws Exception {
		word = "";
		commandWords = new String[] {};	
	}

	@Test
	final void testIsCommand() {
		assertEquals(false, (new CommandWords()).isCommand(word));
	}
}
