import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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


	/**
	 * Replicates the dice roll.
	 * 
	 * Takes in the total number of dices that needs to be rolled. The number of
	 * dices that can be rolled at a time ranges from 1 - 3 inclusive.
	 * 
	 * Returns the dice roll value
	 * 
	 **/
	/*public int[] roll(int numberOfDice) {

		dices = new int[numberOfDice];
		// go through the dices one by one
		for (int i = 0; i < dices.length; i++) {
			dice = new Random();
			// roll the dice
			roll = dice.nextInt(5) + 1;
			dices[i] = roll;
		}

		// sort the values in ascending order
		Arrays.sort(dices);

		return dices;
	}*/
}
