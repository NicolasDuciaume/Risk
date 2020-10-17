import java.util.ArrayList;

public class Player {
    private String name;
    private int armies;
    private int armiesToPlace;
    private ArrayList<Country> armiesOn;

    public Player(String name)
    {
        this.name = name;
        armies = 0;
        armiesToPlace = 0;
        armiesOn = new ArrayList<Country>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArmies(int armies) {
        this.armies = armies;
        armiesToPlace = armies;
    }

    public int getArmies() {
        return armies;
    }

    public void removeArmies(int x){
        armies = armies - x;
    }

    public void AddCountry(Country a){
        armiesOn.add(a);
    }

    public void removeCountry(Country a){
        for(int x = 0; x < armiesOn.size(); x++){
            Country temp = armiesOn.get(x);
            if(a.getName() == temp.getName()){
                armiesOn.remove(x);
            }
        }
    }

    public void setArmiesOn(ArrayList<Country> armiesOn) {
        this.armiesOn = armiesOn;
    }

    public ArrayList<Country> getArmiesOn() {
        return armiesOn;
    }

    public int getArmiesToPlace() {
        return armiesToPlace;
    }

    public void remArmiesToPlace() {
        armiesToPlace = armiesToPlace - 1;
    }
}
