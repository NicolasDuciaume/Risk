import java.util.Scanner;

public class Parser {
    private Scanner reader;

    public Parser()
    {
        reader = new Scanner(System.in);
    }

    public String getCommand()
    {
        String input;

        input = reader.nextLine();

        return input;
    }
}
