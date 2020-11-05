package model;
import java.util.ArrayList;
/**
 * This class is responsible for dealing with the data
 * belonging to the class, country.
 *
 */
public class Country {

    private String name;
    private ArrayList<Country> neighbors;
    private Player playerOnCountry;
    private int armiesOnCountry;
    private int occupied;
    /**
     * The constructor with one parameter
     * @param name the name of the country
     */
    public Country(String name){
        this.name = name;
        neighbors = new ArrayList<Country>();
        armiesOnCountry = 0;
        occupied = 0;
    }
    /**
     * This function adds the neighbors to the current country
     * @param neighboringCountry 
     */
    public void addNeighbor(Country neighboringCountry){
        neighbors.add(neighboringCountry);
    }
    /**
     * This function returns the neighbors
     * @return the neighbors
     */
    public ArrayList<Country> getNeighbors(){
        return neighbors;
    }
    /**
     * This function sets the country name
     * @param name the name of the country
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * This function gets the name of the country
     * @return the name of the country
     */
    public String getName(){
        return name;
    }
    /**
     * This person sets the player on the country
     * @param playerOnCountry that player present on the country
     */
    public void setPlayerOnCountry(Player playerOnCountry){
        this.playerOnCountry = playerOnCountry;
    }
    /**
     * Thus function gets the player that is located on the country 
     * @return the player located on the country
     */
    public Player getPlayerOnCountry(){
        return playerOnCountry;
    }
    /**
     * This function is responsible for adding armies to the country
     * @param numOfArmy the number of armies to be added
     */
    public void addArmiesOnCountry(int numOfArmy){
        armiesOnCountry = armiesOnCountry + numOfArmy;
    }
    /**
     * This funciton removes the armies from a country
     * @param numOfArmy the number of armies to be removed from the country
     */
    public void removeArmiesOnCountry(int numOfArmy){
        armiesOnCountry = armiesOnCountry - numOfArmy;
    }
    /**
     * This function gets the armies located on a country
     * @return the armies located on the country
     */
    public int getArmiesOnCountry(){
        return armiesOnCountry;
    }
    /**
     * This function sets a flag the country has been occupied
     */
    public void setOccupied() {
        occupied = 1;
    }
    /**
     * This function checks if the country has been occupied or not
     */
    public int getOccupied() {
        return occupied;
    }
}
