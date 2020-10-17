import java.util.ArrayList;
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

    public Game(){
        parser = new Parser();
        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
        player4 = new Player();
        player5 = new Player();
        player6 = new Player();
    }

    public void Populate(){

    }

    public void Introduction()
    {
        System.out.println("Welcome to the game of Risk!");
        System.out.println("Select the number of players:");
        for(int x = 2; x <= 6; x++){
            System.out.println(x + " Players");
        }
        PlayerSelection(parser.getCommand());
        while(PlayersInGame.size() == 0){
            System.out.println("Please select a valid option:");
            PlayerSelection(parser.getCommand());
        }
        System.out.println("You have selected " + PlayersInGame.size());
        System.out.println("Starting Game...");
    }

    public void Play()
    {
        Introduction();
        boolean Finished = false;
        while (! Finished){

        }

    }

    public void PlayerSelection(String selection){
        switch (selection){
            case "2":
            case "2 Players":
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                break;
            case "3":
            case "3 Players":
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                break;
            case "4":
            case "4 Players":
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                PlayersInGame.add(player4);
                break;
            case "5":
            case "5 Players":
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                PlayersInGame.add(player4);
                PlayersInGame.add(player5);
                break;
            case "6":
            case "6 Players":
                PlayersInGame.add(player1);
                PlayersInGame.add(player2);
                PlayersInGame.add(player3);
                PlayersInGame.add(player4);
                PlayersInGame.add(player5);
                PlayersInGame.add(player6);
                break;
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.Play();
    }
}
