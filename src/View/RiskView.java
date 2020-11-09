package View;
import View.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RiskView extends JFrame {

    private JPanel mainMenuPL;
    private JPanel GameView;
    private JButton newGameBT;
    private JButton quitBT;

    public RiskView(){
        super("Risk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainMenu());

        setLocationRelativeTo(null);
        //setPreferredSize(new Dimension(500,600));
        setVisible(true);

        pack();
    }

    private JPanel mainMenu(){
        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2,3,2,3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5,5,5,5));
        mainMenuPL = new JPanel();
        mainMenuPL.setLayout(new GridLayout(6,1,5,5));

        JLabel label1 = new JLabel("Welcome to the game of RISK!", JLabel.CENTER);
        label1.setFont(new Font("Serif",Font.BOLD,20));
        JLabel label2 = new JLabel("The goal is simple: players aim to conquer their enemies' territories", JLabel.CENTER);
        JLabel label3 = new JLabel("by building an army, moving their troops in, and engaging in battle.", JLabel.CENTER);
        JLabel label4 = new JLabel("Depending on the roll of the dice, a player will either defeat the enemy or be defeated.", JLabel.CENTER);
        newGameBT = new JButton("New Game");
        quitBT = new JButton("Quit");

        newGameBT.setActionCommand("newGame");
        quitBT.setActionCommand("quit");

        mainMenuPL.add(label1);
        mainMenuPL.add(label2);
        mainMenuPL.add(label3);
        mainMenuPL.add(label4);
        mainMenuPL.add(newGameBT);
        mainMenuPL.add(quitBT);

        borderLayout.add(mainMenuPL);
        border.add(borderLayout,BorderLayout.CENTER);


        return border;
    }


    public void addActionListener(ActionListener listener){
        newGameBT.addActionListener(listener);
        quitBT.addActionListener(listener);
    }


}
