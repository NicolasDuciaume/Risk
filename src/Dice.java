import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Represents a dice with a specified number of sides (1-6)
 *
 */
public class Dice {

	private int roll;
	private Random dice;

	/**
	 * Default constructor
	 */
	public Dice() {
		dice = new Random();
	}

	public void rollDice(){
		roll = dice.nextInt(5) + 1;
	}

	public int getRoll(){
		return roll;
	}

}
