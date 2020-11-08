package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Country;
import model.Map;

class mapTest {
	Map gameMap;
	@BeforeEach
	void setUp() throws Exception {
		gameMap = new Map();
	}

	@Test
	final void testMap() {
	}


	@Test
	final void testGetCompleteGameMap() {
		ArrayList<Country> map = new ArrayList<Country>();
		int size = 42;
		map = gameMap.getCompleteGameMap();		
		assertEquals(size, map.size());
	}

	@Test
	final void testGetOccupiedCountries() {
		int occupied = gameMap.getOccupiedCountries();
		int size = 0;
		assertEquals(size, occupied);
	}

}
