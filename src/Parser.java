import java.util.Scanner;

public class Parser {
    private Scanner reader;
    private CommandWords commands;

    public Parser()
    {
        reader = new Scanner(System.in);
        commands = new CommandWords();
    }

    public Command getCommand()
    {
        String input;

        input = reader.nextLine();

        if(commands.isCommand(input)){
            return new Command(input);
        }
        return new Command(null);
    }

    public void getCommands(){
        commands.getCommandList();
    }

    public String getIntroSelect(){
        String input;

        input = reader.nextLine();

        return input;
    }
}
