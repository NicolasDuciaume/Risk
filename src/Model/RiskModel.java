package Model;
import Model.*;
import Controller.*;
import View.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * The model class of the Risk Game
 *
 */
public class RiskModel {

    private ArrayList<Player> playersInGame = new ArrayList<Player>();

    private Player CurrentPlayer;

    private Parser parser;

    private int cur = 0;

    public Map map;
    
    private ArrayList<Country> fullMap;
    private ArrayList<Country> NorthAmerica;
    private ArrayList<Country> SouthAmerica;
    private ArrayList<Country> Europe;
    private ArrayList<Country> Africa;
    private ArrayList<Country> Asia;
    private ArrayList<Country> Australia;

    private Dice dice;
    /**
     * The default constructor of the Game class
     */
    public RiskModel(){
        parser = new Parser();
        map = new Map();
        NorthAmerica = map.getNorthAmerica();
        SouthAmerica = map.getSouthAmerica();
        Europe = map.getEurope();
        Africa = map.getAfrica();
        Asia = map.getAsia();
        Australia = map.getAustralia();
        fullMap = new ArrayList<Country>();
        fullMap = map.getCompleteGameMap();
        dice = new Dice();
    }
    /**
     * This class is responsible for adding the armies on the map
     */
    public void populate(){
        Random rand = new Random();
        populateInit();
        for(int x = 0; x < playersInGame.size(); x++){
            Player play = playersInGame.get(x);
            ArrayList<Country> PlayCountry = play.getPlacedArmies();
            while(play.getArmiesToPlace() != 0){
                Country temp = PlayCountry.get(rand.nextInt(PlayCountry.size()));
                temp.addArmiesOnCountry(1);
                play.remArmiesToPlace();
            }
        }
    }
    /**
     * This method is responsible for initializing the Risk 
     * game with default settings
     */
    public void populateInit(){
        while(map.getOccupiedCountries() != 42){
            if(((playersInGame.size() == 4 ) || (playersInGame.size() == 5)) && (map.getOccupiedCountries() == 40)){ //because they 42 is not divisible by 4 or 5
                gameSetUpFornonDevisibleCountriesByPlayersCase();
            }
            else{
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
		for (int x = 0; x < playersInGame.size(); x++){
		    Player play = playersInGame.get(x);
		    Country temp = fullMap.get(rand.nextInt(fullMap.size()));
		    while(temp.getPlayerOnCountry() != null)
		    {
		        temp = fullMap.get(rand.nextInt(fullMap.size()));
		    }
		    play.addCountry(temp);
		    temp.addArmiesOnCountry(1);
		    temp.setPlayerOnCountry(play);
		    play.remArmiesToPlace();
		}
	}
    /**
     * This function is responsible for setting up the game
     * when we have 4 or 5 players and the total number of 
     * countries i.e., 45 is not divisible by 4 or 5
     * @param
     **/
	private void gameSetUpFornonDevisibleCountriesByPlayersCase() {
		Random rand = new Random();
		for (int x = 0; x < 2; x++){
		    Player play = playersInGame.get(x);
		    Country temp = fullMap.get(rand.nextInt(fullMap.size()));
		    while(temp.getPlayerOnCountry() != null)
		    {
		        temp = fullMap.get(rand.nextInt(fullMap.size()));
		    }
		    play.addCountry(temp);
		    temp.addArmiesOnCountry(1);
		    temp.setPlayerOnCountry(play);
		    play.remArmiesToPlace();
		}
	}


    /**
     * This method is responsible for instantiating the introduction 
     * of the game upon game start up
     */
    public void introduction()
    {
        System.out.println("Welcome to the game of RISK!\n"
        		+ "The goal is simple: players aim to conquer their enemies' territories\n"
        		+ "by building an army, moving their troops in, and engaging in battle.\n"
        		+ "Depending on the roll of the dice, a player will either defeat the enemy or be defeated.\n\n"
        		+ "select the number of players:");
        
        for(int x = 2; x <= 6; x++){
            System.out.println(x + " Players");
        }
        playerSelection(parser.getUserInput());
        while(playersInGame.size() == 0){
            System.out.println("Please select a valid option:");
            playerSelection(parser.getUserInput());
        }
        System.out.println("You have selected " + playersInGame.size());
        System.out.println("Starting Game...");
    }
    /**
     * This method is responsible for interfacing with the user as the game proceeds
     */
    public void play()
    {
        CurrentPlayer = playersInGame.get(0);

    	/*
        //introduction();
        //populate();
        //map.printMap();

        while (!checkEnd()){
            for(int x = 0; x < playersInGame.size(); x++){
                Player play = playersInGame.get(x);
                if(play.getArmies() != 0){
                    int reinforcements;
                    System.out.println(play.getName() + "'s turn:");
                    if(play.getPlacedArmies().size() < 9){
                        reinforcements = 3;
                    }
                    else{
                        reinforcements = play.getPlacedArmies().size() / 3;
                    }

                    reinforcements = checkHasContinent(play) + reinforcements;

                    System.out.println("You can place " + reinforcements + " troops");

                    reinforcement(reinforcements, play);


                    //System.out.println("\nSelect a command:");
                    //parser.getCommands();
                    boolean endTurn = false;
                    while(!endTurn){
                        //Command command = parser.getCommand();
                        //endTurn = processCommand(command, play);
                    }
                }
                else{
                    playersInGame.remove(x);
                }
            }
        }
        Player play = playersInGame.get(0);
        System.out.println(play.getName() + "has won the game!");*/
    }


    public int reinforce(){
        int reinforcements;
        if(CurrentPlayer.getPlacedArmies().size() < 9){
            reinforcements = 3;
        }
        else{
            reinforcements = CurrentPlayer.getPlacedArmies().size() / 3;
        }

        reinforcements = checkHasContinent(CurrentPlayer) + reinforcements;

        System.out.println("You can place " + reinforcements + " troops");

        return reinforcements;
    }

    public Boolean DoesHeOwn(String s){
        for(Country c: CurrentPlayer.getPlacedArmies()){
            if(c.getName().equals(s)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method is responsible for processing the user entered commands and making 
     * calls to appropriate methods based on the entered command
     * @param command the user entered command
     * @param player the player which entered the command
     * @return true if the command was processed successfully
     */
    /*
    private boolean processCommand(Command command, Player player){
        boolean end = false;
        
        if(command.isUnknown()){
            System.out.println("Please select a valid command");
            return false;
        }
        else {        
        	String commandWord = command.getCommandWord().trim().toLowerCase();
        	switch(commandWord) {
        	case "help":
        		printHelp();
        		break;
        	case "map": 
        		mapPrint();
	            System.out.println("Select a command:");
	            break;
        	case "pass" : 
        		endTurn();
 	            end = true;
 	            player.setMoved(false);
 	            break;
        	case "attack": 
        		attack(player);
 	            System.out.println("Select a command:");
 	            break;
        	case "quit": 
	        	System.out.println("GAME OVER.");
	        	System.exit(0);
	        	break;  		
        	}
	        //Troop movement phase is to be implemented in Milestone 3
	        
	        /*else if(commandWord.equals("move")){
	            if (!player.isMoved()){
	                move(player);
	            }
	            else{
	                System.out.println("You have already moved armies this turn");
	            }
	            System.out.println("Select a command:");
	        }
        }
        return end;
    }*/

    /**
     * This function checks if the end of the game is reached or not
     * @return
     */
	public boolean checkEnd(){
	    boolean Finished = false;
	    int playersAlive = playersInGame.size();
        if(playersAlive == 1){
            Finished = true;
        }
        return Finished;
    }
	/**
	 * This function takes a number representing the number of players that will be
	 * playing the game and initializes the game for them
	 * @param numberOfPlayers the number of players that will be playing the game
	 */


    public void playerSelection(String numberOfPlayers){
		//toUpperCase to make it case insensitive.
        switch (numberOfPlayers.toUpperCase().trim()){
            case "2":
            case "2 PLAYERS":
                for(int x = 0; x < 2;x++){
                    playersInGame.add(new Player("Player " + (x+1)));
                    playersInGame.get(x).setInitArmies(50);
                }
                break;
            case "3":
            case "3 PLAYERS":
                for(int x = 0; x < 3;x++){
                    playersInGame.add(new Player("Player " + (x+1)));
                    playersInGame.get(x).setInitArmies(35);
                }
                break;
            case "4":
            case "4 PLAYERS":
                for(int x = 0; x < 4;x++){
                    playersInGame.add(new Player("Player " + (x+1)));
                    playersInGame.get(x).setInitArmies(30);
                }
                break;
            case "5":
            case "5 PLAYERS":
                for(int x = 0; x < 5;x++){
                    playersInGame.add(new Player("Player " + (x+1)));
                    playersInGame.get(x).setInitArmies(25);
                }
                break;
            case "6":
            case "6 PLAYERS":
                for(int x = 0; x < 6;x++){
                    playersInGame.add(new Player("Player " + (x+1)));
                    playersInGame.get(x).setInitArmies(20);
                }
                break;
        }

    }
    /**
     * This function is responsible for printing out the help 
     */
    private void printHelp(){
	    System.out.println("The possible commands are:");
	    parser.getCommands(); //prints out the available commands 
    }
    /**
     * This function is responsible for making an attack
     * @param //player the player that is about to attack
     * @return true if the attach was made
     */
    public int[] attack(Player attackPlayer, Player defendPlayer, Country Defend, Country Attack, int att, int def){
        int[] DefenderDice = {0};
        int[] attackerDice = {0};
        attackerDice = dice.roll(att);
        DefenderDice = dice.roll(def);


        int s = attackerDice.length - 1;
        int armiesKilledDef = 0;
        int armiesKilledAtt = 0;

        for(int x = (DefenderDice.length - 1); x >= 0; x--){
            if(DefenderDice[x] >= attackerDice[s]){
                Attack.removeArmiesOnCountry(1);
                attackPlayer.removeArmies(1);
                armiesKilledAtt++;
            }
            else{
                Defend.removeArmiesOnCountry(1);
                defendPlayer.removeArmies(1);
                armiesKilledDef++;
            }

            if(DefenderDice.length > attackerDice.length){
                break;
            }

            s = s - 1;
        }

        System.out.println(armiesKilledDef + " of the defending player's armies were killed");
        System.out.println(armiesKilledAtt + " of the attacking player's armies were killed");

        int[] finalRes = {armiesKilledAtt,armiesKilledDef,0, 0};



        if(Defend.getArmiesOnCountry() == 0){
            defendPlayer.removeCountry(Defend);
            Defend.setPlayerOnCountry(attackPlayer);
            attackPlayer.addCountry(Defend);
            Defend.addArmiesOnCountry(attackerDice.length);
            Attack.removeArmiesOnCountry(attackerDice.length);
            finalRes[2] = 1;
        }

        if(defendPlayer.getArmies() == 0){
            finalRes[3] = 1;
        }

        return finalRes;
    }
    /**
     * To be provided later
     * This function provides the move functionality to the game.
     * @param //player the player that wants to move
     * @return true if move has been made
     */
    /*
    private boolean move(Player player) {
        System.out.println("With which Country would you like to move armies from:");
        ArrayList<Country> playCount = player.getPlacedArmies();
        for (int x = 0; x < playCount.size(); x++) {
            Country temp = playCount.get(x);
            System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
        }

        boolean correctSelect = false;
        Country mover = null;
        while (!correctSelect) {
            String attackerInput = parser.getUserInput();
            if (attackerInput.equals("back")) {
                return true;
            }
            for (int y = 0; y < playCount.size(); y++) {
                Country temp = playCount.get(y);
                if (temp.getName().equals(attackerInput)) {
                    mover = temp;
                    correctSelect = true;
                }
            }
            if (correctSelect == false) {
                System.out.println("Please select a valid country");
            }
        }

        ArrayList<Country> neighbors = mover.getNeighbors();
        System.out.println("Neighbor Countries you can move to:");
        boolean noOwnedNeighbors = true;
        for (int x = 0; x < neighbors.size(); x++) {
            Country temp = neighbors.get(x);
            if (mover.getPlayerOnCountry() == temp.getPlayerOnCountry()) {
                System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
                noOwnedNeighbors = false;
            }
        }

        if (noOwnedNeighbors == true) {
            System.out.println("You have know neighbors to this country that you can move troops to");
            return false;
        }

        System.out.println("Which Country would you like to move your troops to");
        boolean correctNeighbor = false;
        Country moving = null;
        while (!correctNeighbor) {
            String neighbor = parser.getUserInput();
            if (neighbor.equals("back")) {
                return true;
            }
            for (int y = 0; y < playCount.size(); y++) {
                Country temp = playCount.get(y);
                if (temp.getName().equals(neighbor)) {
                    moving = temp;
                    correctNeighbor = true;
                }
            }
            if (correctNeighbor == false) {
                System.out.println("Please select a valid country");
            }
        }

        System.out.println("How many armies would you like to move? (must leave 1 army)");
        boolean CorrectNumber = false;
        while (!CorrectNumber) {
            String ans = parser.getUserInput();
            if (ans.equals("back")){
                return true;
            }
            else if(!isNumeric(ans)){
                System.out.println("Please input a number");
            }
            else {
                int num = mover.getArmiesOnCountry();
                int numToMove = Integer.valueOf(ans);
                if ((numToMove < num) && (numToMove >= 0)) {
                    System.out.println("Moving armies...");
                    mover.removeArmiesOnCountry(numToMove);
                    moving.addArmiesOnCountry(numToMove);
                    System.out.println(mover.getName() + " now has " + mover.getArmiesOnCountry());
                    System.out.println(moving.getName() + " now has " + moving.getArmiesOnCountry());
                    CorrectNumber = true;
                } else {
                    System.out.println("Please select a valid number of armies to move");
                }
            }
        }

        player.setMoved(true);

        return false;
    } */

    public void reinforcement(int rein, String C){
       for(Country c: CurrentPlayer.getPlacedArmies()){
           if(C.equals(c.getName())){
               c.addArmiesOnCountry(rein);
               CurrentPlayer.setArmies(rein);
           }
       }
    }

    /**
     * This function prints out the countries along with the armies on on it.
     * @param countries 
     */
	private void printCountriesAlongWithArmies(ArrayList<Country> countries) {
		for(int x = 0; x < countries.size(); x++){
            Country temp = countries.get(x);
            System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
        }
	}

    public ArrayList<Country> getFullMap() {
        return fullMap;
    }

    /**
	 * This function ends the player turn
	 */
    public void endTurn(){
        if(cur == playersInGame.size() - 1){
            cur = 0;
            CurrentPlayer = playersInGame.get(cur);
        }
        else{
            cur = cur + 1;
            CurrentPlayer = playersInGame.get(cur);
        }

    }

    public Player getCurrentPlayer(){
        return CurrentPlayer;
    }

    public String getCurrentPlayerName(){
        return CurrentPlayer.getName();
    }
    /**
     * This function checks if the value is numeric or not
     * @param strNum number with String as its type
     * @return true if the value is numeric or not
     */
    public static boolean isNumeric(String strNum) {
        try{
            Integer.parseInt(strNum);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * This function prints out the map
     */
    private void mapPrint(){
	    System.out.println("The current map is: ");
        map.printMap();
    }

    private int checkHasContinent(Player player){
        int hasNA = 0;
        int hasSA = 0;
        int hasE = 0;
        int hasAF = 0;
        int hasA = 0;
        int hasAUS = 0;
        int bonus = 0;
        ArrayList<Country> temp = player.getPlacedArmies();
        System.out.println("Reinforcement Stage!");
        for(int x = 0; x < temp.size(); x++){
            Country pt = temp.get(x);
            for(int y = 0; y < NorthAmerica.size(); y++){
                Country tt = NorthAmerica.get(y);
                if(tt.getName().equals(pt.getName())){
                    hasNA++;
                }
            }
            for(int y = 0; y < SouthAmerica.size(); y++){
                Country tt = SouthAmerica.get(y);
                if(tt.getName().equals(pt.getName())){
                    hasSA++;
                }
            }
            for(int y = 0; y < Europe.size(); y++){
                Country tt = Europe.get(y);
                if(tt.getName().equals(pt.getName())){
                    hasE++;
                }
            }
            for(int y = 0; y < Asia.size(); y++){
                Country tt = Asia.get(y);
                if(tt.getName().equals(pt.getName())){
                    hasA++;
                }
            }
            for(int y = 0; y < Africa.size(); y++){
                Country tt = Africa.get(y);
                if(tt.getName().equals(pt.getName())){
                    hasAF++;
                }
            }
            for(int y = 0; y < Australia.size(); y++){
                Country tt = Australia.get(y);
                if(tt.getName().equals(pt.getName())){
                    hasAUS++;
                }
            }
        }

        if(hasNA == 9){
            bonus = bonus + 5;
            System.out.println("You own North America thus get 5 additional reinforcement troops");
        }
        else if(hasSA == 4){
            bonus = bonus + 2;
            System.out.println("You own South America thus get 2 additional reinforcement troops");
        }
        else if(hasE == 7){
            bonus = bonus + 5;
            System.out.println("You own Europe thus get 5 additional reinforcement troops");
        }
        else if(hasAF == 6){
            bonus = bonus + 3;
            System.out.println("You own Africa thus get 3 additional reinforcement troops");
        }
        else if(hasA == 12){
            bonus = bonus + 7;
            System.out.println("You own Asia thus get 7 additional reinforcement troops");
        }
        else if(hasAUS == 4){
            bonus = bonus + 2;
            System.out.println("You own Australia thus get 2 additional reinforcement troops");
        }

        return bonus;
    }

    /**
     * The main  function that runs the game
     */
    public static void main(String[] args) {
        RiskModel game = new RiskModel();
        game.play();
    }
}
