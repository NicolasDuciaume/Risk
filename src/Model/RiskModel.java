/*
Author: Nicolas Duciaume & Christopher D'silva
Refactoring: Kamran Sagheir & Hussain Al-Baidhani
Comments: Hussain Al-Baidhani & Christopher D'silva
 */
package Model;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Locale;

/**
 * The model class of the RISK Game
 */
public class RiskModel implements Serializable {

    private ArrayList<Player> playersInGame = new ArrayList<Player>();
    private Player currentPlayer;
    private transient Parser parser;
    private int cur = 0;
    public Map map;
    private Dice dice;
    private int numOfCountries;
    private String custom = "./testRisk.json";

    private ArrayList<Country> fullMap;

    /**
     * The default constructor of the Game class
     */
    public RiskModel() {
        parser = new Parser();
        map = new Map();
        fullMap = new ArrayList<Country>();
        dice = new Dice();
    }

    /**
     * This function sets the string which contains the file, from which  to load the map.
     * @param cust - the string of the file location to load the map
     */
    
    public void setCustom(String cust) {
        custom = cust;
    }

    /**
     * This function gets the string which contains the file to load the map from
     *
     * @return the string of the file location to load the map
     */
    
    public String getCustom() {
        return custom;
    }

    /**
     * This function gets the map of the game
     * @return the map of the game
     */
    
    public Map getMap() {
        return map;
    }

    /**
     * This function sets the full map of the game
     */
    
    public void setFullMap() {
        
        fullMap = map.getCompleteGameMap();
        numOfCountries = fullMap.size();
    }

    /**
     * This class is responsible for adding the armies on the map
     */
    public void populate() {
        
        Random rand = new Random();
        populateInit();
        for (int x = 0; x < playersInGame.size(); x++) {
            Player play = playersInGame.get(x);
            ArrayList<Country> PlayCountry = play.getPlacedArmies();
            while (play.getArmiesToPlace() != 0) {
                Country country = PlayCountry.get(rand.nextInt(PlayCountry.size()));
                country.addArmiesOnCountry(1);
                play.remArmiesToPlace();
            }
        }
    }

    /**
     * This method is responsible for initializing the Risk
     * game with default settings
     */
    public void populateInit() {
        while (map.getOccupiedCountries() != numOfCountries) {
            if (((numOfCountries % playersInGame.size() != 0)) && (map.getOccupiedCountries() == (numOfCountries - (numOfCountries % playersInGame.size())))) { //because they 42 is not divisible by 4 or 5
                gameSetUpFornonDevisibleCountriesByPlayersCase();
            } else {
                standardCaseGameSetup();
            }
        }
    }

    /**
     * This function is responsible for the case when we have have to set up the game
     * such that the number of countries are divisible by the number of players i.e., 2 and 42
     */
    private void standardCaseGameSetup() {
        Random rand = new Random();
        for (int x = 0; x < playersInGame.size(); x++) {
            setUpGame(rand, x);
        }
    }

    /**
     * Inner method within gameSetUps
     * @param rand
     * @param x
     */
    private void setUpGame(Random rand, int x) {
        Player play = playersInGame.get(x);
        Country temp = fullMap.get(rand.nextInt(fullMap.size()));
        while (temp.getPlayerOnCountry() != null) {
            temp = fullMap.get(rand.nextInt(fullMap.size()));
        }
        play.addCountry(temp);
        temp.addArmiesOnCountry(1);
        temp.setPlayerOnCountry(play);
        play.remArmiesToPlace();
    }

    /**
     * This function is responsible for setting up the game
     * when we have 4 or 5 players and the total number of
     * countries i.e., 45 is not divisible by 4 or 5
     * @param
     **/
    private void gameSetUpFornonDevisibleCountriesByPlayersCase() {
        Random rand = new Random();
        for (int x = 0; x < 2; x++) {
            setUpGame(rand, x);
        }
    }


    /**
     * This method is responsible for interfacing the user as the game proceeds
     */
    public void play() {
        currentPlayer = playersInGame.get(0);
    }

    /**
     * Determines the number of reinforcements to be placed at the begining of each round
     *
     * @return
     */
    public int reinforce() {
        int reinforcements;
        if (currentPlayer.getPlacedArmies().size() < 9) {
            reinforcements = 3;
        } else {
            reinforcements = currentPlayer.getPlacedArmies().size() / 3;
        }

        reinforcements = checkHasContinent(currentPlayer) + reinforcements;

        System.out.println("You can place " + reinforcements + " troops");

        return reinforcements;
    }

    /**
     * Checks if the current player owns the country
     * @param s
     * @return
     */
    
    public Boolean isOwned(String s) {
        for (Country country : currentPlayer.getPlacedArmies()) {
            if (country.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }


    /**
     * This function checks if the end of the game is reached or not
     *
     * @return
     */
    public boolean checkEnd() {
        boolean Finished = false;
        int playersAlive = playersInGame.size();
        if (playersAlive == 1) {
            Finished = true;
        }
        return Finished;
    }
    
    /**
     * This function initializes the game and takes a number representing the number of players that will be playing
     *
     * @param //numberOfPlayers the number of players that will be playing the game
     */

    public void playerAddition(int num, int arms) {
        for (int x = 0; x < num; x++) {
            playersInGame.add(new Player("Player " + (x + 1)));
            playersInGame.get(x).setInitArmies(arms);
        }
    }

    /**
     * Adds an AI player to the game
     *
     * @param num
     * @param arms
     */
    
    public void aiPlayerAddition(int num, int arms) {
        for (int x = 0; x < num; x++) {
            playersInGame.add(new AiPlayer("Ai " + (x + 1), this));
        }
        
        int temp = playersInGame.size() - 1;
        for (int y = temp; y >= (temp - num); y--) {
            playersInGame.get(y).setInitArmies(arms);
        }
    }

    /**
     * Chooses how many players & AI players are going to be
     * playing
     *
     * @param numberOfPlayers
     * @param Ai
     */
    
    public void playerSelection(String numberOfPlayers, int Ai) {
        //toUpperCase to make it case insensitive.
        switch (numberOfPlayers.toUpperCase().trim()) {
            case "2":
            case "2 PLAYERS":
                switch (Ai) {
                    case 0:
                        playerAddition(2, 50);
                        break;
                    case 1:
                        playerAddition(1, 50);
                        aiPlayerAddition(1, 50);
                        break;
                }
                break;
            case "3":
            case "3 PLAYERS":
                switch (Ai) {
                    case 0:
                        playerAddition(3, 35);
                        break;
                    case 1:
                        playerAddition(2, 35);
                        aiPlayerAddition(1, 35);
                        break;
                    case 2:
                        playerAddition(1, 35);
                        aiPlayerAddition(2, 35);
                        break;
                }
                break;
            case "4":
            case "4 PLAYERS":
                switch (Ai) {
                    case 0:
                        playerAddition(4, 30);
                        break;
                    case 1:
                        playerAddition(3, 30);
                        aiPlayerAddition(1, 30);
                        break;
                    case 2:
                        playerAddition(2, 30);
                        aiPlayerAddition(2, 30);
                        break;
                    case 3:
                        playerAddition(1, 30);
                        aiPlayerAddition(3, 30);
                        break;
                }
                break;
            case "5":
            case "5 PLAYERS":
                switch (Ai) {
                    case 0:
                        playerAddition(5, 25);
                        break;
                    case 1:
                        playerAddition(4, 25);
                        aiPlayerAddition(1, 25);
                        break;
                    case 2:
                        playerAddition(3, 25);
                        aiPlayerAddition(2, 25);
                        break;
                    case 3:
                        playerAddition(2, 25);
                        aiPlayerAddition(3, 25);
                        break;
                    case 4:
                        playerAddition(1, 25);
                        aiPlayerAddition(4, 25);
                        break;
                }
                break;
            case "6":
            case "6 PLAYERS":
                switch (Ai) {
                    case 0:
                        playerAddition(6, 20);
                        break;
                    case 1:
                        playerAddition(5, 20);
                        aiPlayerAddition(1, 20);
                        break;
                    case 2:
                        playerAddition(4, 20);
                        aiPlayerAddition(2, 20);
                        break;
                    case 3:
                        playerAddition(3, 20);
                        aiPlayerAddition(3, 20);
                        break;
                    case 4:
                        playerAddition(2, 20);
                        aiPlayerAddition(4, 20);
                        break;
                    case 5:
                        playerAddition(1, 20);
                        aiPlayerAddition(5, 20);
                        break;
                }
                break;
        }

    }

    /**
     * Determines if the next turn if an AI's turn
     *
     * @return
     */
    public boolean isNextPlayAi() {
        for (int x = 0; x < playersInGame.size(); x++) {
            if (playersInGame.get(x).getName().equals(getCurrentPlayerName())) {
                if (playersInGame.get(x) != playersInGame.get(playersInGame.size() - 1)) {
                    String sub = playersInGame.get(x + 1).getName().substring(0, 2);
                    if (sub.equals("Ai")) {
                        return true;
                    }
                } else {
                    String sub = playersInGame.get(0).getName().substring(0, 2);
                    if (sub.equals("Ai")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This function is responsible for printing out the help
     */
    @SuppressWarnings("unused")
    private void printHelp() {
        System.out.println("The possible commands are:");
        parser.getCommands(); //prints out the available commands
    }

    /**
     * This function is responsible for making an attack
     *
     * @param //player the player that is about to attack
     * @return true if the attach was made
     */
    public int[] attack(Player attackPlayer, Player defendPlayer, Country defend, Country attack, int att, int def) {
        int[] DefenderDice = {0};
        int[] attackerDice = {0};
        attackerDice = dice.roll(att);
        DefenderDice = dice.roll(def);


        int s = attackerDice.length - 1;
        int armiesKilledDef = 0;
        int armiesKilledAtt = 0;

        for (int x = (DefenderDice.length - 1); x >= 0; x--) {
            if (DefenderDice[x] >= attackerDice[s]) {
                attack.removeArmiesOnCountry(1);
                attackPlayer.removeArmies(1);
                armiesKilledAtt++;
            } else {
                defend.removeArmiesOnCountry(1);
                defendPlayer.removeArmies(1);
                armiesKilledDef++;
            }

            if (DefenderDice.length > attackerDice.length) {
                break;
            }

            s = s - 1;
        }

        System.out.println(armiesKilledDef + " of the defending player's armies were killed");
        System.out.println(armiesKilledAtt + " of the attacking player's armies were killed");

        int[] finalRes = {armiesKilledAtt, armiesKilledDef, 0, 0};


        if (defend.getArmiesOnCountry() == 0) {
            defendPlayer.removeCountry(defend);
            defend.setPlayerOnCountry(attackPlayer);
            attackPlayer.addCountry(defend);
            defend.addArmiesOnCountry(attackerDice.length);
            attack.removeArmiesOnCountry(attackerDice.length);
            finalRes[2] = 1;
        }


        if (defendPlayer.getArmies() == 0) {
            finalRes[3] = 1;
            playersInGame.remove(defendPlayer);
        }

        return finalRes;
    }


    /**
     * Troop movement method that moves armies from one country to another
     *
     * @param moveFrom
     * @param moveTo
     * @param troopMoved
     */
    public void movement(Country moveFrom, Country moveTo, int troopMoved) {
        System.out.println("Moving armies...");
        moveFrom.removeArmiesOnCountry(troopMoved);
        moveTo.addArmiesOnCountry(troopMoved);
        System.out.println(moveFrom.getName() + " now has " + moveFrom.getArmiesOnCountry());
        System.out.println(moveTo.getName() + " now has " + moveTo.getArmiesOnCountry());
    }

    /**
     * Adds the reinforcements to the appropriate country
     *
     * @param rein
     * @param C
     */
    public void reinforcement(int rein, String C) {
        for (Country c : currentPlayer.getPlacedArmies()) {
            if (C.equals(c.getName())) {
                c.addArmiesOnCountry(rein);
                currentPlayer.setArmies(rein);
            }
        }
        currentPlayer.setReinforced(true);
    }

    /**
     * This function prints out the countries along with the armies on on it.
     *
     * @param countries
     */
    @SuppressWarnings("unused")
    private void printCountriesAlongWithArmies(ArrayList<Country> countries) {
        for (int x = 0; x < countries.size(); x++) {
            Country temp = countries.get(x);
            System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
        }
    }

    /**
     * Gets the current full map
     *
     * @return
     */
    public ArrayList<Country> getFullMap() {
        return fullMap;
    }

    /**
     * This function ends the player turn
     */
    public void endTurn() {
        if (cur == playersInGame.size() - 1) {
            cur = 0;
            currentPlayer.setReinforced(false);
            currentPlayer = playersInGame.get(cur);
        } else {
            cur = cur + 1;
            currentPlayer.setReinforced(false);
            currentPlayer = playersInGame.get(cur);
        }

    }

    /**
     * This function returns the current player
     *
     * @return current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        return currentPlayer.getName();
    }

    /**
     * This function checks if the value is numeric or not
     *
     * @param strNum number with String as its type
     * @return true if the value is numeric or not
     */
    public static boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This function prints out the map
     */
    @SuppressWarnings("unused")
    private void mapPrint() {
        System.out.println("The current map is: ");
        map.printMap();
    }

    /**
     * Checks if a player has earned a continent, that is owned all
     * the countries within that continent
     *
     * @param player
     * @return
     */
    private int checkHasContinent(Player player) {
        int bonus = 0;
        ArrayList<Country> temp = player.getPlacedArmies();
        System.out.println("Reinforcement Stage!");

        ArrayList<Continents> continents = map.getContinents();

        for (Continents t : continents) {
            boolean hasCountinent = true;
            ArrayList<Country> temp2 = t.getCountriesInContinent();
            for (Country t2 : temp2) {
                if (!temp.contains(t2)) {
                    hasCountinent = false;
                }
            }
            if (hasCountinent) {
                System.out.println("You own " + t.getName());
                bonus = bonus + t.getBonus();
            }
        }

        return bonus;
    }

    /**
     * This function saves the current game to a file
     *
     * @param fileName - the name of the file to save to
     */
    public void save(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(this);
            outputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function loads a saved game
     *
     * @param fileName - the name of the file to load from
     * @return the model saved
     */
    public static RiskModel load(String fileName) {
        RiskModel riskModel = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            riskModel = (RiskModel) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return riskModel;
    }


    /**
     * The main  function that runs the game.
     */
    public static void main(String[] args) throws IOException {

    }
}
