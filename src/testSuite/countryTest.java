package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import model.Country;
import model.Player;

class countryTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testCountry() {
	}

	@Test
	final void testAddNeighbor() {
		Country country = new Country("Canada");
		Country neighbour = new Country("USA");
		country.addNeighbor(neighbour);
		ArrayList<Country> neighbours = new ArrayList<Country>();
		neighbours.add(neighbour);
		assertEquals(neighbours, country.getNeighbors());
	}

	@Test
	final void testGetNeighbors() {
		Country country = new Country("Canada");
		Country neighbour = new Country("USA");
		country.addNeighbor(neighbour);
		ArrayList<Country> neighbours = new ArrayList<Country>();
		neighbours.add(neighbour);
		assertEquals(neighbours, country.getNeighbors());
		

	}
	
	@Test
	final void testGetName() {
		Country canada = new Country("Canda");
		canada.setName("Canada");
		assertEquals("Canada", canada.getName());
	}
	
	@Test
	final void testSetPlayerOnCountry() {
		Player player = new Player("test");
		Country canada = new Country("Canada");
		canada.setPlayerOnCountry(player);
		canada.getPlayerOnCountry();
		assertEquals(player, canada.getPlayerOnCountry());
	}

	@Test
	final void testGetPlayerOnCountry() {
		Player player = new Player("test");
		Country canada = new Country("Canada");
		canada.setPlayerOnCountry(player);
		canada.getPlayerOnCountry();
		assertEquals(player, canada.getPlayerOnCountry());
	}

	@Test
	final void testAddArmiesOnCountry() {
		Country canada  = new Country("Test");
		canada.addArmiesOnCountry(2);
		assertEquals(2, canada.getArmiesOnCountry());
	}

	@Test
	final void testRemoveArmiesOnCountry() {
		Country canada  = new Country("Test");
		canada.addArmiesOnCountry(2);
		canada.removeArmiesOnCountry(1);
		assertEquals(1, canada.getArmiesOnCountry());
	}

	@Test
	final void testGetArmiesOnCountry() {
		Country canada = new Country("Canda");
		canada.addArmiesOnCountry(2);
		assertEquals(2, canada.getArmiesOnCountry());
	}
}
