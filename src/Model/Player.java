/*
Author: Nicolas Duciaume & Hussain Al-Baidhani
Refactoring: Kamran Sagheir
Comments: Hussain Al-Baidhani
 */
package Model;

import java.util.ArrayList;

/**
 * This class is responsible for creating an instance of player for the Risk game.
 */
public class Player {

    private String name;
    private int armies;
    private int numberOfArmiesToMove;
    private ArrayList<Country> placedArmies;
    private boolean moved = false;
    /**
     * Model.Player constructor with one parameter.
     * @param name the name of the player
     */
    public Player(String name)
    {
        this.name = name;
        armies = 0;
        numberOfArmiesToMove = 0;
        placedArmies = new ArrayList<Country>();
    }
    /**
     * This function gets the name of the Model.Player
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * This function sets the name of the Model.Player
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This function sets the armies
     * @param armies the number of armies to set
     */
    public void setInitArmies(int armies) {
        this.armies = armies;
        numberOfArmiesToMove = armies;
    }

    public void setArmies(int arm){
        armies = armies + arm;
    }
    /**
     * This function gets the armies 
     * @return the number of armies
     */
    public int getArmies() {
        return armies;
    }
    /**
     * This function removes the armies
     * @param numberOfArmies the number of armies to be removed.
     */
    public void removeArmies(int numberOfArmies){
        armies = armies - numberOfArmies;
    }
    /**
     * This function is responsible for adding the country to the players controlled countries
     * @param countryName the country to add armies to in order to claim it
     */
    public void addCountry(Country countryName){
        placedArmies.add(countryName);
    }
    /**
     * This function is responsible for removing the country i.e., removing the hold of the 
     * player on the country
     * @param countryName the country to be removed i.e., the country for which the current player lost hold of
     */
    public void removeCountry(Country countryName){
        for(int x = 0; x < placedArmies.size(); x++){
            Country temp = placedArmies.get(x);
            if(countryName.getName() == temp.getName()){
                placedArmies.remove(x);
            }
        }
    }
	/**
	 * This function places the armies on a country
	 * @param placedArmies
	 */
    public void setArmiesOn(ArrayList<Country> placedArmies) {
        this.placedArmies = placedArmies;
    }
    /**
     * This function gets the armies that are present on a country
     * @return the armies that are present on a country
     */
    public ArrayList<Country> getPlacedArmies() {
        return placedArmies;
    }
    /**
     * This function gets the number of remaining armies that needs to be placed 
     * @return the number of remaining armies that needs to be placed 
     */
    public int getArmiesToPlace() {
        return numberOfArmiesToMove;
    }
    /**
     * This function updates the number of armies that are left to be placed
     */
    public void remArmiesToPlace() {
        numberOfArmiesToMove = numberOfArmiesToMove - 1;
    }
    /**
     * This function checks if the player has moved or not
     * @return the value of moved flag
     */
    public boolean isMoved() {
        return moved;
    }
    /**
     * This function checks the flag that player has moved or not
     * @param moved the value of moved flag
     */
    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
