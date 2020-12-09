/*
Author: Nicolas Duciaume
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is responsible for dealing with the data
 * belonging to the class, Continents.
 */
public class Continents implements Serializable {
    private ArrayList<Country> countriesInContinent;
    private String name;
    private int bonus;

    /**
     * The constructor with three parameter
     *
     * @param name                 - name of the continent
     * @param countriesInContinent - The array of country which the continent has
     * @param bonus                - The integer value associated with owning the entire continent
     */
    public Continents(String name, ArrayList<Country> countriesInContinent, int bonus) {
        this.name = name;
        this.countriesInContinent = countriesInContinent;
        this.bonus = bonus;
    }

    /**
     * This function sets the name of the continent
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function gets the name of the continent
     *
     * @return the name of the continent
     */
    public String getName() {
        return name;
    }

    /**
     * This function gets the array containing the countries in the continent
     *
     * @return the array of countries in the continent
     */
    public ArrayList<Country> getCountriesInContinent() {
        return countriesInContinent;
    }

    /**
     * This function sets the array containing the countries in the continent
     *
     * @param countriesInContinent array of countries to be set into the continent
     */
    public void setCountriesInContinent(ArrayList<Country> countriesInContinent) {
        this.countriesInContinent = countriesInContinent;
    }

    /**
     * This function gets the bonus amount of troops you get for owning the continent
     *
     * @return int of bonus reinforcement troops
     */
    public int getBonus() {
        return bonus;
    }

}
