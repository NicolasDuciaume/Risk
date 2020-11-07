package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RiskView extends JFrame {

    private JPanel mainMenuPL;
    private JButton newGameBT;
    private JButton quitBT;

    public RiskView(){
        super("Risk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(mainMenu());

        setLocationRelativeTo(null);
        setSize(300,300);
        setVisible(true);
    }

    private JPanel mainMenu(){
        mainMenuPL = new JPanel();
        mainMenuPL.setLayout(new GridLayout(2,1,5,5));

        newGameBT = new JButton("New Game");
        quitBT = new JButton("Quit");

        newGameBT.setActionCommand("newGame");
        quitBT.setActionCommand("quit");

        mainMenuPL.add(newGameBT);
        mainMenuPL.add(quitBT);

        return mainMenuPL;
    }

    public void addActionListener(ActionListener listener){
        newGameBT.addActionListener(listener);
        quitBT.addActionListener(listener);
    }


}
