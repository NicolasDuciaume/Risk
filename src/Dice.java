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
	/**
	 * this function rolls a dice
	 */
	public void rollDice(){
		roll = dice.nextInt(5) + 1;
	}
	/**
	 *
	 * @return the value that is obtained as a result of rolling the dice
	 */
	public int getRoll(){
		return roll;
	}

	/**
	 * Replicates the dice roll.
	 * 
	 * Takes in the total number of dices that needs to be rolled. The number of
	 * dices that can be rolled at a time ranges from 1 - 3 inclusive.
	 * 
     * @param dices the number of dices to be rolled
     * @return the dice roll value
     */
	protected int[] roll(int dices) {
	    int[] rolledValues = new int[dices];
	    for(int x = 0; x < dices; x++){
	        Dice temp = new Dice();
	        temp.rollDice();
	        rolledValues[x] = temp.getRoll();
        }

        Arrays.sort(rolledValues);

		for(int i = 0; i < rolledValues.length; i++) {
			System.out.println("Got value: " + rolledValues[i]);
		}
        return rolledValues;
	}
}
