public class CommandWords {

    private static final String[] VALID_COMMANDS = {
      "help", "attack", "move", "map", "end turn"
    };

    public boolean isCommand(String aString){
        for(int i = 0; i < VALID_COMMANDS.length; i++){
            if(VALID_COMMANDS[i].equals(aString)){
                return true;
            }
        }
        return false;
    }

    public String getCommandList() {
        // let's use a StringBuilder (not required)
        StringBuilder s = new StringBuilder();
        for(String command: VALID_COMMANDS) {
            s.append(command + "  ");
        }
        String str = s.toString();
        return str.trim(); // removes spaces from beginning/end
    }
}
