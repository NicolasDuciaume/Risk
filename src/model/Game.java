package model;
import java.util.ArrayList;
import java.util.Random;
/**
 * The main class of the Risk Game
 *
 */
public class Game {

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Player player6;

    private ArrayList<Player> PlayersInGame = new ArrayList<Player>();

    private Parser parser;

    private Map map; 
    
    private ArrayList<Country> fullMap;
    private Dice dice;
    /**
     * The default constructor of the Game class
     */
    public Game(){
        parser = new Parser();
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        player3 = new Player("Player 3");
        player4 = new Player("Player 4");
        player5 = new Player("Player 5");
        player6 = new Player("Player 6");

        map = new Map();

        fullMap = new ArrayList<Country>();
        fullMap = map.getCompleteGameMap();
        dice = new Dice();
    }
    /**
     * This class is responsible for adding the armies on the map
     */
    public void Populate(){
        Random rand = new Random();
        PopulateInit(); 
        for(int x = 0; x < PlayersInGame.size(); x++){
            Player play = PlayersInGame.get(x);
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
    public void PopulateInit(){
        while(map.getOccupiedCountries() != 42){
            if(((PlayersInGame.size() == 4 ) || (PlayersInGame.size() == 5)) && (map.getOccupiedCountries() == 40)){ //because they 42 is not divisible by 4 or 5
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
		for (int x = 0; x < PlayersInGame.size(); x++){
		    Player play = PlayersInGame.get(x);
		    Country temp = fullMap.get(rand.nextInt(fullMap.size()));
		    while(temp.getOccupied() != 0)
		    {
		        temp = fullMap.get(rand.nextInt(fullMap.size()));
		    }
		    play.AddCountry(temp);
		    temp.addArmiesOnCountry(1);
		    temp.setOccupied();
		    temp.setPlayerOnCountry(play);
		    play.remArmiesToPlace();
		}
	}
    /**
     * This function is responsible for setting up the game
     * when we have 4 or 5 players and the total number of 
     * countries i.e., 45 is not divisible by 4 or 5
     * @param rand
     */
	private void gameSetUpFornonDevisibleCountriesByPlayersCase() {
		Random rand = new Random();
		for (int x = 0; x < 2; x++){
		    Player play = PlayersInGame.get(x);
		    Country temp = fullMap.get(rand.nextInt(fullMap.size()));
		    while(temp.getOccupied() != 0)
		    {
		        temp = fullMap.get(rand.nextInt(fullMap.size()));
		    }
		    play.AddCountry(temp);
		    temp.addArmiesOnCountry(1);
		    temp.setOccupied();
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
        while(PlayersInGame.size() == 0){
            System.out.println("Please select a valid option:");
            playerSelection(parser.getUserInput());
        }
        System.out.println("You have selected " + PlayersInGame.size());
        System.out.println("Starting Game...");
    }
    /**
     * This method is responsible for interfacing with the user as the game proceeds
     */
    public void play()
    {
    	
        introduction();
        Populate();
        map.printMap();

        while (!checkEnd()){
            for(int x = 0; x < PlayersInGame.size(); x++){
                Player play = PlayersInGame.get(x);
                if(play.getArmies() != 0){
                    System.out.println(play.getName() + "'s turn:");
                    System.out.println("\nSelect a command:");
                    parser.getCommands();
                    boolean endTurn = false;
                    while(!endTurn){
                        Command command = parser.getCommand();
                        endTurn = processCommand(command, play);
                    }
                }
                else{
                    PlayersInGame.remove(x);
                }
            }
        }
        Player play = PlayersInGame.get(0);
        System.out.println(play.getName() + "has won the game!");
    }
    /**
     * This method is responsible for processing the user entered commands and making 
     * calls to appropriate methods based on the entered command
     * @param command the user entered command
     * @param player the player which entered the command
     * @return true if the command was processed successfully
     */
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
	        }*/ 
        }
        return end;
    }

    /**
     * This function checks if the end of the game is reached or not
     * @return
     */
	public boolean checkEnd(){
	    boolean Finished = false;
	    int playersAlive = PlayersInGame.size();
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
                player1.setArmies(50);
                player2.setArmies(50);
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                break;
            case "3":
            case "3 PLAYERS":
                player1.setArmies(35);
                player2.setArmies(35);
                player3.setArmies(35);
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                break;
            case "4":
            case "4 PLAYERS":
                player1.setArmies(30);
                player2.setArmies(30);
                player3.setArmies(30);
                player4.setArmies(30);
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                PlayersInGame.add(player4);
                break;
            case "5":
            case "5 PLAYERS":
                player1.setArmies(25);
                player2.setArmies(25);
                player3.setArmies(25);
                player4.setArmies(25);
                player5.setArmies(25);
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                PlayersInGame.add(player4);
                PlayersInGame.add(player5);
                break;
            case "6":
            case "6 PLAYERS":
                player1.setArmies(20);
                player2.setArmies(20);
                player3.setArmies(20);
                player4.setArmies(20);
                player5.setArmies(20);
                player6.setArmies(20);
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                PlayersInGame.add(player4);
                PlayersInGame.add(player5);
                PlayersInGame.add(player6);
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
     * @param player the player that is about to attack
     * @return true if the attach was made
     */
    private boolean attack(Player player){
        System.out.println("With which Country would you like to attack:");
        ArrayList<Country> playCount = player.getPlacedArmies();
        printCountriesAlongWithArmies(playCount);
        boolean correctSelect = false;
        Country attackerC = null;
        while(!correctSelect){
            String attacker = parser.getUserInput();
            if(attacker.trim().equalsIgnoreCase("back")){
                return true;
            }
            for(int y = 0; y < playCount.size(); y++){
                Country temp = playCount.get(y);
                if(temp.getArmiesOnCountry() > 1){
                    if(temp.getName().equalsIgnoreCase(attacker.trim())){
                        attackerC = temp;
                        correctSelect = true;
                    }
                }
            }
            if(correctSelect == false){
                System.out.println("Please select a valid country that you own with more than 1 army on it");
            }
        }

        boolean noOwnedNeighbors = true;
        ArrayList<Country> neighbors = attackerC.getNeighbors();
        System.out.println(attackerC.getName() + " can attack:");
        for(int x = 0; x < neighbors.size(); x++){
            Country temp = neighbors.get(x);
            if(!temp.getPlayerOnCountry().getName().equals(player.getName())){
                System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
            }
            noOwnedNeighbors = false;
        }

        if (noOwnedNeighbors == true) {
            System.out.println("You have no neighbors to this country that you can attack.");
            return false;
        }

        System.out.println("Which Country do you wish to attack? (input \"back\" if you wish to cancel)");

        boolean correctNeighbor = false;
        Country attackedC = null;
        Player attackedPlayer = null;
        while (!correctNeighbor) {
            String attacked = parser.getUserInput();
            if (attacked.trim().equalsIgnoreCase("back")) {
                return true;
            }
            for (int y = 0; y < neighbors.size(); y++) {
                Country temp = neighbors.get(y);
                if(!temp.getPlayerOnCountry().getName().equals(player.getName())){
                    if (temp.getName().equalsIgnoreCase(attacked.trim())) {
                        attackedC = temp;
                        attackedPlayer = temp.getPlayerOnCountry();
                        correctNeighbor = true;
                    }
                }
            }
            if (correctNeighbor == false) {
                System.out.println("Please select a valid country");
            }
        }

        System.out.println(player.getName() + "'s " + attackerC.getName() + " is attacking " + attackedPlayer.getName() + "'s " + attackedC.getName());
        System.out.println(attackerC.getName() + " has " + attackerC.getArmiesOnCountry() + " armies on it");
        System.out.println(attackedC.getName() + " has " + attackedC.getArmiesOnCountry() + " armies on it");

        System.out.println(player.getName() + " how many dices would you like to have?");
        System.out.println("Between 1 and 3, must have one more army on Country than amount of dice");

        boolean CorrectNumber = false;
        int[] attackerDice = {0};
        while (!CorrectNumber) {
            String ans = parser.getUserInput();
            if (ans.equals("back")){
                return true;
            }
            else if(!isNumeric(ans)){
                System.out.println("Please input a number: ");
            }
            else {
                int numDice = Integer.valueOf(ans);
                if ((numDice < attackerC.getArmiesOnCountry()) && (numDice >= 1) && (numDice <= 3)) {
                    attackerDice = dice.roll(numDice);
                    CorrectNumber = true;
                } else {
                    System.out.println("Please select a valid number of armies to move");
                }
            }
        }

        System.out.println(attackedPlayer.getName() + " how many dices would you like to have?");
        System.out.println("Between 1 and 2. If 2, you must have at least 2 armies on the Country");

        CorrectNumber = false;
        int[] DefenderDice = {0};
        while (!CorrectNumber) {
            String ans = parser.getUserInput();
            if(!isNumeric(ans)){
                System.out.println("Please input a number");
            }
            else {
                int numDice = Integer.valueOf(ans);
                if ((numDice >= 1) && (numDice <= 2)) {
                    if((numDice == 2) && (attackedC.getArmiesOnCountry() < 2)){
                        System.out.println("You do not have enough armies for 2 dices");
                    }
                    else{
                        DefenderDice = dice.roll(numDice);
                        CorrectNumber = true;
                    }
                }
                else {
                    System.out.println("Please select a valid number of dice");
                }
            }
        }

        int s = attackerDice.length - 1;
        int armiesKilledDef = 0;
        int armiesKilledAtt = 0;

        for(int x = (DefenderDice.length - 1); x >= 0; x--){
            if(DefenderDice[x] >= attackerDice[s]){
                attackerC.removeArmiesOnCountry(1);
                player.removeArmies(1);
                armiesKilledAtt++;
            }
            else{
                attackedC.removeArmiesOnCountry(1);
                attackedPlayer.removeArmies(1);
                armiesKilledDef++;
            }

            if(DefenderDice.length > attackerDice.length){
                break;
            }

            s = s - 1;
        }

        System.out.println(armiesKilledDef + " of the defending player's armies were killed");
        System.out.println(armiesKilledAtt + " of the attacking player's armies were killed");

        if(attackedC.getArmiesOnCountry() == 0){
            attackedPlayer.removeCountry(attackedC);
            attackedC.setPlayerOnCountry(player);
            player.AddCountry(attackedC);
            attackedC.addArmiesOnCountry(attackerDice.length);
            attackerC.removeArmiesOnCountry(attackerDice.length);
            System.out.println(attackedPlayer.getName() + " has lost control of " + attackedC.getName());
            System.out.println(player.getName() + " now controls " + attackedC.getName() + " placing " + attackedC.getArmiesOnCountry() + " armies on it");
            System.out.println("while " + attackerC.getName() + " now only has " + attackerC.getArmiesOnCountry() + " armies on it");
        }
        else{
            System.out.println(attackedPlayer.getName() + "'s " + attackedC.getName() + " now has " + attackedC.getArmiesOnCountry() + " on it");
            System.out.println(player.getName() + "'s " + attackerC.getName() + " now has " + attackerC.getArmiesOnCountry() + " on it");
        }

        if(attackedPlayer.getArmies() == 0){
            System.out.println(attackedPlayer.getName() + " has been eliminated");
        }

        return false;
    }
    /**
     * To be provided later
     * This function provides the move functionality to the game.
     * @param player the player that wants to move
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
                		

	/**
	 * This function ends the player turn
	 */
    private void endTurn(){
	    System.out.println("Ending turn...");
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
    /**
     * The main  function that runs the game
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
