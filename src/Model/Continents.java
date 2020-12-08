package Model;

import java.util.ArrayList;

public class Continents {
    private ArrayList<Country> CountriesInContinent;
    private String name;
    private int bonus;

    public Continents(String name, ArrayList<Country> CountriesInContinent, int bonus){
        this.name = name;
        this.CountriesInContinent = CountriesInContinent;
        this.bonus = bonus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Country> getCountriesInContinent() {
        return CountriesInContinent;
    }

    public void setCountriesInContinent(ArrayList<Country> countriesInContinent) {
        CountriesInContinent = countriesInContinent;
    }

    public int getBonus() {
        return bonus;
    }

}
