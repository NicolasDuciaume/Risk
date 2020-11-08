package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        setPreferredSize(new Dimension(300,200));
        setVisible(true);

        pack();
    }

    private JPanel mainMenu(){
        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2,3,2,3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5,5,5,5));
        mainMenuPL = new JPanel();
        mainMenuPL.setLayout(new GridLayout(2,1,5,5));

        newGameBT = new JButton("New Game");
        quitBT = new JButton("Quit");

        newGameBT.setActionCommand("newGame");
        quitBT.setActionCommand("quit");

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
