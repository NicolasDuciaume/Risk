/*
Author: Nicolas Duciaume
Refactoring: Kamran Sagheir
Comments: Kamran Sagheir
 */
package Model;

import java.util.Scanner;

/**
 * The parser class is responsible for parsing the user entered commands
 */
public class Parser {
    private Scanner reader;
    private CommandWords commands;

    /**
     * Default constructor for the Model.Parser class
     */
    public Parser() {
        reader = new Scanner(System.in);
        commands = new CommandWords();
    }

    /**
     * This function gets the user entered command
     *
     * @return the user entered command
     */
    public Command getCommand() {
        String input;

        input = reader.nextLine();

        if (commands.isCommand(input)) {
            return new Command(input);
        }
        return new Command(null);
    }

    /**
     * This function returns all the user entered commands
     *
     * @return all the user entered commands
     */
    public String[] getCommands() {
        return commands.getCommandList();
    }

    /**
     * This function is responsible for getting the user entered input
     *
     * @return the user entered input
     */
    public String getUserInput() {
        String input;

        input = reader.nextLine();

        return input;
    }
}
