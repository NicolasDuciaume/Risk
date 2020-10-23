import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Player player5;
    Player player6;

    ArrayList<Player> PlayersInGame = new ArrayList<Player>();

    Parser parser;

    Map map;

    ArrayList<Country> fullMap;

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
        fullMap = map.getFullMap();
    }

    public void Populate(){
        Random rand = new Random();
        PopulateInit();
        for(int x = 0; x < PlayersInGame.size(); x++){
            Player play = PlayersInGame.get(x);
            ArrayList<Country> PlayCountry = play.getArmiesOn();
            while(play.getArmiesToPlace() != 0){
                Country temp = PlayCountry.get(rand.nextInt(PlayCountry.size()));
                temp.addArmiesOnCountry(1);
                play.remArmiesToPlace();
            }
        }
    }

    public void PopulateInit(){
        Random rand = new Random();
        while(map.getCountriesOcc() != 42){
            if(((PlayersInGame.size() == 4 ) || (PlayersInGame.size() == 5)) && (map.getCountriesOcc() == 40)){ //because they 42 is not divisible by 4 or 5
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
            else{
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
    }}

    public void Introduction()
    {
        System.out.println("Welcome to the game of Risk!");
        System.out.println("Select the number of players:");
        for(int x = 2; x <= 6; x++){
            System.out.println(x + " Players");
        }
        PlayerSelection(parser.getIntroSelect());
        while(PlayersInGame.size() == 0){
            System.out.println("Please select a valid option:");
            PlayerSelection(parser.getIntroSelect());
        }
        System.out.println("You have selected " + PlayersInGame.size());
        System.out.println("Starting Game...");
    }

    public void Play()
    {
    	Dice dice = new Dice();
    	
        Introduction();
        Populate();
        map.PrintMap();
        
        


        while (!CheckEnd()){
            for(int x = 0; x < PlayersInGame.size(); x++){
                Player play = PlayersInGame.get(x);
                if(play.getArmies() != 0){
                    System.out.println(play.getName() + "'s turn:");
                    System.out.println("Select a command:");
                    System.out.println(parser.getCommands());
                    boolean endTurn = false;
                    while(!endTurn){
                        Command command = parser.getCommand();
                        endTurn = processCommand(command, play);
                    }
                }
                //check if finished
            }
        }
    }

    private boolean processCommand(Command command, Player player){
        boolean end = false;
        if(command.isUnknown()){
            System.out.println("Please select a valid command");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("map")){
            MapPrint();
            System.out.println("Select a command:");
        }
        else if (commandWord.equals("end turn"))
        {
            endTurn();
            end = true;
            player.setMoved(false);
        }
        else if(commandWord.equals("attack")){
            attack(player);
            System.out.println("Select a command:");
        }
        else if(commandWord.equals("move")){
            if (!player.isMoved()){
                move(player);
            }
            else{
                System.out.println("You have already moved armies this turn");
            }
            System.out.println("Select a command:");
        }
        return end;
    }


	private int[] RollDice(int dices) {
	    int[] rolledValues = new int[dices];
	    for(int x = 0; x < dices; x++){
	        Dice temp = new Dice();
	        temp.rollDice();
	        rolledValues[x] = temp.getRoll();
        }

        Arrays.sort(rolledValues);

		for(int i = 0; i < rolledValues.length; i++) {
			System.out.println("Got value: " + rolledValues[i]);
		}
        return rolledValues;
	}



	public boolean CheckEnd(){
	    boolean Finished = false;
	    int playersAlive = PlayersInGame.size();
	    for(int x = 0; x < PlayersInGame.size(); x++){
	        Player play = PlayersInGame.get(x);
	        if(play.getArmies() == 0){
	            playersAlive = playersAlive - 1;
            }
        }
        if(playersAlive == 1){
            Finished = true;
        }
        return Finished;
    }

    public void PlayerSelection(String selection){
        switch (selection){
            case "2":
            case "2 Players":
                player1.setArmies(50);
                player2.setArmies(50);
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                break;
            case "3":
            case "3 Players":
                player1.setArmies(35);
                player2.setArmies(35);
                player3.setArmies(35);
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                break;
            case "4":
            case "4 Players":
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
            case "5 Players":
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
            case "6 Players":
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

    private void printHelp(){
	    System.out.println("The possible commands are:");
        System.out.println(parser.getCommands());
    }

    private boolean attack(Player player){
        System.out.println("With which Country would you like to attack:");
        ArrayList<Country> playCount = player.getArmiesOn();
        for(int x = 0; x < playCount.size(); x++){
            Country temp = playCount.get(x);
            System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
        }
        boolean correctSelect = false;
        Country attackerC = null;
        while(!correctSelect){
            String attacker = parser.getIntroSelect();
            if(attacker.equals("back")){
                return true;
            }
            for(int y = 0; y < playCount.size(); y++){
                Country temp = playCount.get(y);
                if(temp.getArmiesOnCountry() != 1){
                    if(temp.getName().equals(attacker)){
                        attackerC = temp;
                        correctSelect = true;
                    }
                }
            }
            if(correctSelect == false){
                System.out.println("Please select a valid country that you own with more then 1 army on it");
            }
        }

        boolean noOwnedNeighbors = true;
        ArrayList<Country> neighbors = attackerC.getNeighbors();
        System.out.println(attackerC.getName() + " can attack:");
        for(int x = 0; x < neighbors.size(); x++){
            Country temp = neighbors.get(x);
            if(temp.getPlayerOnCountry().getName() != player.getName()){
                System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
            }
            noOwnedNeighbors = false;
        }

        if (noOwnedNeighbors == true) {
            System.out.println("You have know neighbors to this country that you can attack");
            return false;
        }

        System.out.println("Which Country do you wish to attack?");

        boolean correctNeighbor = false;
        Country attackedC = null;
        Player attackedPlayer = null;
        while (!correctNeighbor) {
            String attacked = parser.getIntroSelect();
            if (attacked.equals("back")) {
                return true;
            }
            for (int y = 0; y < neighbors.size(); y++) {
                Country temp = neighbors.get(y);
                if(temp.getPlayerOnCountry().getName() != player.getName()){
                    if (temp.getName().equals(attacked)) {
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
        System.out.println("Between 1 and 3, must have one more army on Country then amount of dice");

        boolean CorrectNumber = false;
        int[] attackerDice = {0};
        while (!CorrectNumber) {
            String ans = parser.getIntroSelect();
            if (ans.equals("back")){
                return true;
            }
            else if(!isNumeric(ans)){
                System.out.println("Please input a number");
            }
            else {
                int numDice = Integer.valueOf(ans);
                if ((numDice < attackerC.getArmiesOnCountry()) && (numDice >= 1) && (numDice <= 3)) {
                    attackerDice = RollDice(numDice);
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
            String ans = parser.getIntroSelect();
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
                        DefenderDice = RollDice(numDice);
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

        return false;
    }

    private boolean move(Player player) {
        System.out.println("With which Country would you like to move armies from:");
        ArrayList<Country> playCount = player.getArmiesOn();
        for (int x = 0; x < playCount.size(); x++) {
            Country temp = playCount.get(x);
            System.out.println(temp.getName() + " which has " + temp.getArmiesOnCountry() + " on it");
        }

        boolean correctSelect = false;
        Country mover = null;
        while (!correctSelect) {
            String attacker = parser.getIntroSelect();
            if (attacker.equals("back")) {
                return true;
            }
            for (int y = 0; y < playCount.size(); y++) {
                Country temp = playCount.get(y);
                if (temp.getName().equals(attacker)) {
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
            String neighbor = parser.getIntroSelect();
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
            String ans = parser.getIntroSelect();
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
    }

    private void endTurn(){
	    System.out.println("Ending turn...");
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void MapPrint(){
	    System.out.println("The current map is:");
        map.PrintMap();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.Play();
    }
}
