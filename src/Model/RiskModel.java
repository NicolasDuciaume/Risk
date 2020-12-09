/*
Author: Nicolas Duciaume & Christopher D'silva
Refactoring: Kamran Sagheir & Hussain Al-Baidhani
Comments: Hussain Al-Baidhani & Christopher D'silva
 */
package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
/**
 * The model class of the Risk Game
 *
 */
public class RiskModel implements Serializable{

    private ArrayList<Player> playersInGame = new ArrayList<Player>();
    private Player currentPlayer;
    private transient Parser parser;
    private transient int cur = 0;
    public Map map;
    private transient Dice dice;

    private ArrayList<Country> fullMap;
    private transient ArrayList<Country> NorthAmerica;
    private transient ArrayList<Country> SouthAmerica;
    private transient ArrayList<Country> Europe;
    private transient ArrayList<Country> Africa;
    private transient ArrayList<Country> Asia;
    private transient ArrayList<Country> Australia;

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
        while(temp.getPlayerOnCountry() != null)
        {
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
		for (int x = 0; x < 2; x++){
            setUpGame(rand, x);
        }
	}


    /**
     * This method is responsible for instantiating the introduction
     * of the game upon game start up
     */
    /*public void introduction()
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
    }*/
    /**
     * This method is responsible for interfacing with the user as the game proceeds
     */
    public void play()
    {
        currentPlayer = playersInGame.get(0);

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

    /**
     * Determines the number of reinforcements to be placed
     * @return
     */
    public int reinforce(){
        int reinforcements;
        if(currentPlayer.getPlacedArmies().size() < 9){
            reinforcements = 3;
        }
        else{
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
    public Boolean isOwned(String s){
        for(Country country: currentPlayer.getPlacedArmies()){
            if(country.getName().equals(s)){
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
	 * @param //numberOfPlayers the number of players that will be playing the game
	 */

	public void playerAddition(int num , int arms){
        for(int x = 0; x < num ;x++){
            playersInGame.add(new Player("Player " + (x+1)));
            playersInGame.get(x).setInitArmies(arms);
        }
    }

    /**
     * Adds an AI player to the game
     * @param num
     * @param arms
     */
    public void aiPlayerAddition(int num, int arms){
        for(int x = 0; x < num ;x++){
            playersInGame.add(new AiPlayer("Ai " + (x+1) , this));
        }
        int temp = playersInGame.size() - 1;
        for(int y = temp; y >= (temp - num); y--){
            playersInGame.get(y).setInitArmies(arms);
        }
    }

    /**
     * Chooses how many players & AI players are going to be
     * playing
     * @param numberOfPlayers
     * @param Ai
     */
    public void playerSelection(String numberOfPlayers , int Ai){
		//toUpperCase to make it case insensitive.
        switch (numberOfPlayers.toUpperCase().trim()){
            case "2":
            case "2 PLAYERS":
                switch (Ai){
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
                switch (Ai){
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
                switch (Ai){
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
                switch (Ai){
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
                switch (Ai){
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
     * @return
     */
    public boolean isNextPlayAi(){
	    for(int x = 0; x < playersInGame.size(); x++){
	        if(playersInGame.get(x).getName().equals(getCurrentPlayerName())){
	            if(playersInGame.get(x) != playersInGame.get(playersInGame.size() -1 )){
                    String sub = playersInGame.get(x + 1).getName().substring(0,2);
                    if(sub.equals("Ai")){
                        return true;
                    }
                }
	            else{
                    String sub = playersInGame.get(0).getName().substring(0,2);
                    if(sub.equals("Ai")){
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
            playersInGame.remove(defendPlayer);
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

    /**
     * Troop movement method that moves armies from one country to another
     * @param moveFrom
     * @param moveTo
     * @param troopMoved
     */
    public void movement(Country moveFrom, Country moveTo, int troopMoved){
        System.out.println("Moving armies...");
        moveFrom.removeArmiesOnCountry(troopMoved);
        moveTo.addArmiesOnCountry(troopMoved);
        System.out.println(moveFrom.getName() + " now has " + moveFrom.getArmiesOnCountry());
        System.out.println(moveTo.getName() + " now has " + moveTo.getArmiesOnCountry());
    }

    /**
     * Adds the reinforcements to the appropriate country
     * @param rein
     * @param C
     */
    public void reinforcement(int rein, String C){
       for(Country c: currentPlayer.getPlacedArmies()){
           if(C.equals(c.getName())){
               c.addArmiesOnCountry(rein);
               currentPlayer.setArmies(rein);
           }
       }
    }

    /**
     * This function prints out the countries along with the armies on on it.
     * @param countries
     */
	@SuppressWarnings("unused")
	private void printCountriesAlongWithArmies(ArrayList<Country> countries) {
		for(int x = 0; x < countries.size(); x++){
            Country temp = countries.get(x);
            System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
        }
	}

    /**
     * Gets the current full map
     * @return
     */
    public ArrayList<Country> getFullMap() {
        return fullMap;
    }

    /**
	 * This function ends the player turn
	 */
    public void endTurn(){
        if(cur == playersInGame.size() - 1){
            cur = 0;
            currentPlayer = playersInGame.get(cur);
        }
        else{
            cur = cur + 1;
            currentPlayer = playersInGame.get(cur);
        }

    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public String getCurrentPlayerName(){
        return currentPlayer.getName();
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
    @SuppressWarnings("unused")
	private void mapPrint(){
	    System.out.println("The current map is: ");
        map.printMap();
    }

    /**
     * Checks if a player has earned a continent, that is owned all
     * the countries within that continent
     * @param player
     * @return
     */
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

    public void save(String fileName){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(this);
            outputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static RiskModel load(String fileName){
        RiskModel riskModel = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            riskModel = (RiskModel) inputStream.readObject();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return riskModel;
    }

    /**
     * The main  function that runs the game
     */
    public static void main(String[] args) throws IOException {
        RiskModel game = new RiskModel();
        game.playersInGame = new ArrayList<>();
        game.playersInGame.add(new Player("Derrick"));

        System.out.println(game.playersInGame.get(0).getName());

//        game.play();

        //Testing serialization
        game.save("Test.txt");

        //Testing deserialization
        RiskModel newModel = RiskModel.load("Test.txt");

        System.out.println(newModel.playersInGame.get(0).getName());

        //Testing FileFilter

        File f = new File(System.getProperty("user.dir"));
        FilenameFilter filterFiles = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase(Locale.ROOT).endsWith(".txt");
            }
        };
        File[] files = f.listFiles(filterFiles);
        for(File file : files){
            if(file.isDirectory()){
                System.out.print("directory:");
            }else{
                System.out.print("     file:");
            }
            System.out.println(file.getCanonicalPath());
        }

    }
}
