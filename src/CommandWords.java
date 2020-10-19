public class CommandWords {

    private static final String[] validCommands = {
      "help", "attack", "move", "map", "end turn"
    };

    public CommandWords(){}

    public boolean isCommand(String aString){
        for(int i = 0; i < validCommands.length; i++){
            if(validCommands[i].equals(aString)){
                return true;
            }
        }
        return false;
    }

    public String getCommandList() {
        // let's use a StringBuilder (not required)
        StringBuilder s = new StringBuilder();
        for(String command: validCommands) {
            s.append(command + "  ");
        }
        String str = s.toString();
        return str.trim(); // removes spaces from beginning/end
    }
}
