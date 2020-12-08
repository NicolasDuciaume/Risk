/*
Author: Nicolas Duciaume & Christopher D'silva
Refactoring: Hussain Al-Baidhani
Comments: Kamran Sagheir
 */
package Model;

import java.util.ArrayList;
/**
 * The class is responsible for creating the map of the game
 *
 */
public class Map {


    private ArrayList<Country> completeGameMap;
    private ArrayList<Continents> continents;
    /**
     * Default constructor of the Model.Map class
     */
    public Map(){
        completeGameMap = new ArrayList<Country>();
        continents = new ArrayList<>();

    }


	public void addToMap(String t, ArrayList<String> neighborsString){
	    Country temp = new Country(t);
	    temp.setStringOfNeighbors(neighborsString);
	    completeGameMap.add(temp);
    }

    public void SetNeighbors(){
	    for(Country c: completeGameMap){
	        ArrayList<String> neighbString = c.getStringOfNeighbors();
	        for(String s: neighbString){
	            for(Country temp: completeGameMap){
	                if(s.equals(temp.getName())){
	                    c.addNeighbor(temp);
                    }
                }
            }
        }
    }

    public ArrayList<Continents> getContinents() {
        return continents;
    }

    public void addContinents(String name, ArrayList<String> t, int bonus){
        ArrayList<Country> temp = new ArrayList<>();
        for(String s: t){
            for(Country c: completeGameMap){
                if(s.equals(c.getName())){
                    temp.add(c);
                }
            }
        }
        continents.add(new Continents(name,temp,bonus));
    }

    /**
     * This function is responsible for returning the current map 
     * state i.e., the country name and the armies on it
     */
    public void printMap(){
        for (int x = 0; x < completeGameMap.size(); x++){
            Country temp = completeGameMap.get(x);
            Player play = temp.getPlayerOnCountry();
            System.out.println(temp.getName() + " has " + temp.getArmiesOnCountry() + " armies owned by " + play.getName() + " on it");
            
        }
        System.out.println();
    }
    /**
     * This function gets the entire game map
     * @return the complete map of the game
     */
    public ArrayList<Country> getCompleteGameMap(){
        return completeGameMap;
    }

    /**
     * This function returns the occupied countries
     * @return the occupied countries
     */
    public int getOccupiedCountries() {
        int countriesOcc = 0;
        for(int x = 0; x < completeGameMap.size(); x++){
            Country temp = completeGameMap.get(x);
            if(temp.getPlayerOnCountry() != null){
                countriesOcc = countriesOcc + 1;
            }
        }
        return countriesOcc;
    }

}
