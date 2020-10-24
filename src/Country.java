import java.util.ArrayList;

public class Country {

    private String name;
    private ArrayList<Country> neighbors;
    private Player playerOnCountry;
    private int armiesOnCountry;
    private int occupied;

    public Country(String name){
        this.name = name;
        neighbors = new ArrayList<Country>();
        armiesOnCountry = 0;
        occupied = 0;
    }

    public void addNeighbor(Country country){
        neighbors.add(country);
    }

    public ArrayList<Country> getNeighbors(){
        return neighbors;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPlayerOnCountry(Player playerOnCountry){
        this.playerOnCountry = playerOnCountry;
    }

    public Player getPlayerOnCountry(){
        return playerOnCountry;
    }

    public void addArmiesOnCountry(int numOfArmy){
        armiesOnCountry = armiesOnCountry + numOfArmy;
    }

    public void removeArmiesOnCountry(int numOfArmy){
        armiesOnCountry = armiesOnCountry - numOfArmy;
    }

    public int getArmiesOnCountry(){
        return armiesOnCountry;
    }

    public void setOccupied() {
        occupied = 1;
    }

    public int getOccupied() {
        return occupied;
    }
}
