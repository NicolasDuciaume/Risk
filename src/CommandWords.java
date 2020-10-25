public class CommandWords {

    private static final String[] VALID_COMMANDS = {
      "help", "attack", "move", "map", "end turn"
    };
    /**
     * This function checks if the word is a command or not
     * @param userInput the user entered value that needs to be checked if it is
     * a command or not
     * @return true if the user entered word is a command or not.
     */
    public boolean isCommand(String userInput){
        for(int i = 0; i < VALID_COMMANDS.length; i++){
            if(VALID_COMMANDS[i].equals(userInput)){
                return true;
            }
        }
        return false;
    }
    /**
     * This function gets all the command word
     * @return the list of all the commands
     */
    public String getCommandList() {
        StringBuilder s = new StringBuilder();
        for(String command: VALID_COMMANDS) {
            s.append(command + "  ");
        }
        String str = s.toString();
        return str.trim();
    }
}
