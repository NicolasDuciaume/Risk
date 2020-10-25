public class CommandWords {

    private static final String[] VALID_COMMANDS = {
      "help", "attack", "map", "pass", "quit"
      //, "move"
    };

    public boolean isCommand(String aString){
        for(int i = 0; i < VALID_COMMANDS.length; i++){
            if(VALID_COMMANDS[i].equalsIgnoreCase(aString.trim())){
                return true;
            }
        }
        return false;
    }

    public void getCommandList() { //prints out all the valid commands

        for(String command: VALID_COMMANDS) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}
