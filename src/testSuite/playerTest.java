/*
Author: Kamran Sagheir & Hussain Al-Baidhani
 */
package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Country;
import Model.Player;

class playerTest {
	
	Player player;
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player("player 1");
	}

	@Test
	void testPlayer() {
	}

	@Test
	void testGetName() {
		assertEquals("player 1", player.getName());
	}

	@Test
	void testSetName() {
		player.setName("player 2");
		assertEquals("player 2", player.getName());
	}
	
	@Test
	void testSetArmies() {
		player.setArmies(3);
		assertEquals(3, player.getArmies());
	}
	
	@Test
	void testGetArmies() {
		player.setArmies(3);
		assertEquals(3, player.getArmies());
	}

	@Test
	void testRemoveArmies() {
		player.setArmies(3);
		player.removeArmies(1);
		assertEquals(2,player.getArmies());
	}

	@Test
	void testAddCountry() {
		player.addCountry((new Country("country")));
		assertEquals("country",player.getPlacedArmies().get(0).getName());
	}
	
	@Test
	void testRemoveCountry() {
		
		Country countryTest = new Country("country");
		Country countryTest2 = new Country("country2");
		player.addCountry(countryTest);
		player.addCountry(countryTest2);
		player.removeCountry(countryTest); //country2 should be at index 0 now
		
		assertEquals(countryTest2,player.getPlacedArmies().get(0));
		
	}

	@Test
	void testSetArmiesOn(){
		ArrayList<Country> placedArmiestest = null;
		
		player.setArmiesOn(placedArmiestest);
		
		assertEquals(player.getPlacedArmies(),placedArmiestest);
	}
	
	@Test
	void testGetPlacedArmies() {
		
		ArrayList<Country> placedArmiestest = new ArrayList<>();
		player.setArmiesOn(placedArmiestest);
		
		assertEquals(player.getPlacedArmies(),placedArmiestest);
		
	}
	
	@Test
	void testGetArmiesToPlace() {
		
		player.setInitArmies(2);
		int armies = player.getArmies();
		int expected = 2;
		assertEquals(armies, expected);
	}
	
	
	@Test
	void testRemArmiesToPlace() {
		
		player.setInitArmies(3);
		player.remArmiesToPlace();
		assertEquals(player.getArmiesToPlace(),2);
	}
	

	@Test
	void testIsMoved() {
		player.setMoved(true);
		assertEquals(true,player.isMoved());
	}

	@Test
	void testSetMoved() {
		player.setMoved(false);
		assertEquals(player.isMoved(),false);
	}
	

}