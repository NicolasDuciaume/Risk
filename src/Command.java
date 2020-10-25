public class Command {
    
    private String commandWord;
    /**
     * The constructor of the class with one parameter
     * @param commandWord the commandWord
     */
    public Command(String commandWord){
        this.commandWord = commandWord;
    }
    /**
     * This function gets the command word
     * @return the command word
     */
    public String getCommandWord() {
        return commandWord;
    }
    /**
     * This function checks if the command is unknown or not
     * @return true if the command is unknown or not
     */
    public boolean isUnknown(){
        return (commandWord == null);
    }
}
