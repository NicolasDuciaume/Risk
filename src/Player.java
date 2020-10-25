import java.util.ArrayList;

/**
 * This class is responsible for creating an instance of player for the Risk game.
 */
public class Player {

    private String name;
    private int armies;
    private int armiesToPlace;
    private ArrayList<Country> armiesOn;
    private boolean moved = false;
    /**
     * Player constructor with one parameter.
     * @param name the name of the player
     */
    public Player(String name)
    {
        this.name = name;
        armies = 0;
        armiesToPlace = 0;
        armiesOn = new ArrayList<Country>();
    }
    /**
     * This function gets the name of the Player
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * This function sets the name of the Player
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This function sets the armies
     * @param armies the number of armies to set
     */
    public void setArmies(int armies) {
        this.armies = armies;
        armiesToPlace = armies;
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
     * @param x the number of armies to be removed.
     */
    public void removeArmies(int x){
        armies = armies - x;
    }
    /**
     * This function is responsible for adding the country to the players controlled countries
     * @param a the country to add armies to in order to claim it
     */
    public void AddCountry(Country a){
        armiesOn.add(a);
    }
    /**
     * This function is responsible for removing the country i.e., removing the hold of the 
     * player on the country
     * @param a the country to be removed i.e., the country for which the current player lost hold of
     */
    public void removeCountry(Country a){
        for(int x = 0; x < armiesOn.size(); x++){
            Country temp = armiesOn.get(x);
            if(a.getName() == temp.getName()){
                armiesOn.remove(x);
            }
        }
    }
	/**
	 * 
	 * @param armiesOn
	 */
    public void setArmiesOn(ArrayList<Country> armiesOn) {
        this.armiesOn = armiesOn;
    }
    /**
     * This function gets the armies that are present on a country
     * @return the armies that are present on a country
     */
    public ArrayList<Country> getArmiesOn() {
        return armiesOn;
    }
    /**
     * This function gets the number of remaining armies that needs to be placed 
     * @return the number of remaining armies that needs to be placed 
     */
    public int getArmiesToPlace() {
        return armiesToPlace;
    }
    /**
     * This function updates the number of armies that are left to be placed
     */
    public void remArmiesToPlace() {
        armiesToPlace = armiesToPlace - 1;
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
