/*
Author: Nicolas Duciaume & Christopher D'silva
Refactoring: Kamran Sagheir & Hussain Al-Baidhani
Comments: Hussain Al-Baidhani
 */
package Model;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * This class is responsible for dealing with the data
 * belonging to the class, country.
 */
public class Country implements Serializable {

    private String name;
    private ArrayList<Country> neighbors;
    private Player playerOnCountry;
    private int armiesOnCountry;
    private ArrayList<String> stringOfNeighbors;

    /**
     * The constructor with one parameter
     *
     * @param name the name of the country
     */
    public Country(String name) {
        this.name = name;
        neighbors = new ArrayList<Country>();
        armiesOnCountry = 0;
    }

    /**
     * This function gets array of strings of the name of the neighboring countries to be added as neighbors later
     *
     * @return the array of strings containing the names of the neighbors
     */
    public ArrayList<String> getStringOfNeighbors() {
        return stringOfNeighbors;
    }

    /**
     * This function sets array of strings of the name of the neighboring countries to be added as neighbors later
     *
     * @param t - The array of strings of the names of the neighboring country
     */
    public void setStringOfNeighbors(ArrayList<String> t) {
        stringOfNeighbors = t;
    }

    /**
     * This function adds the neighbors to the current country
     *
     * @param neighboringCountry
     */
    public void addNeighbor(Country neighboringCountry) {
        neighbors.add(neighboringCountry);
    }

    /**
     * This function returns the neighbors
     *
     * @return the neighbors
     */
    public ArrayList<Country> getNeighbors() {
        return neighbors;
    }

    /**
     * This function sets the country name
     *
     * @param name the name of the country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function gets the name of the country
     *
     * @return the name of the country
     */
    public String getName() {
        return name;
    }

    /**
     * This person sets the player on the country
     *
     * @param playerOnCountry that player present on the country
     */
    public void setPlayerOnCountry(Player playerOnCountry) {
        this.playerOnCountry = playerOnCountry;
    }

    /**
     * Thus function gets the player that is located on the country
     *
     * @return the player located on the country
     */
    public Player getPlayerOnCountry() {
        return playerOnCountry;
    }

    /**
     * This function is responsible for adding armies to the country
     *
     * @param numOfArmy the number of armies to be added
     */
    public void addArmiesOnCountry(int numOfArmy) {
        armiesOnCountry = armiesOnCountry + numOfArmy;
    }

    /**
     * This funciton removes the armies from a country
     *
     * @param numOfArmy the number of armies to be removed from the country
     */
    public void removeArmiesOnCountry(int numOfArmy) {
        armiesOnCountry = armiesOnCountry - numOfArmy;
    }

    /**
     * This function gets the armies located on a country
     *
     * @return the armies located on the country
     */
    public int getArmiesOnCountry() {
        return armiesOnCountry;
    }

}
