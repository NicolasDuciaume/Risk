public class Command {
    
    private String commandWord;

    public Command(String commandWord){
        this.commandWord = commandWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public boolean isUnknown(){
        return (commandWord == null);
    }
}
