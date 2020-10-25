public class CommandWords {

    private static final String[] VALID_COMMANDS = {
      "help", "attack", "map", "pass", "quit"
      //, "move"
    };
    /**
     * This function checks if the word is a command or not
     * @param userInput the user entered value that needs to be checked if it is
     * a command or not
     * @return true if the user entered word is a command or not.
     */
    public boolean isCommand(String userInput){
        for(int i = 0; i < VALID_COMMANDS.length; i++){
            if(VALID_COMMANDS[i].equalsIgnoreCase(userInput.trim())){
                return true;
            }
        }
        return false;
    }
    /**
     * This function gets all the command word
     * @return the list of all the commands
     */
    public void getCommandList() {
        for(String command: VALID_COMMANDS) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}
