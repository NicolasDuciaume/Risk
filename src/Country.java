import java.util.ArrayList;

public class Country {
    private String name;
    private ArrayList<Country> neighbors;

    public Country(String name){
        this.name = name;
        neighbors = new ArrayList<Country>();
    }

    public void addNeighbor(Country n){
        neighbors.add(n);
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
}
