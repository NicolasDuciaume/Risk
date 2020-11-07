package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPlayerMenu extends JDialog{

    private JPanel selectPlayerMenu;
    private JLabel selectPlayerMenuLabel;

    private JButton twoPlayersBT;
    private JButton threePlayersBT;
    private JButton fourPlayersBT;
    private JButton fivePlayersBT;
    private JButton sixPlayersBT;
    private JButton backBT;

    public SelectPlayerMenu(RiskView main){
        super(main);
        setTitle("Player Select Menu");
        setSize(200,200);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        selectPlayerMenu = new JPanel();
        selectPlayerMenu.setLayout(new GridLayout(5,1,5,5));

        selectPlayerMenuLabel = new JLabel("Select the number of Players:");

        twoPlayersBT = new JButton("2 Players");
        threePlayersBT = new JButton("3 Players");
        fourPlayersBT = new JButton("4 Players");
        fivePlayersBT = new JButton("5 Players");
        sixPlayersBT = new JButton("6 Players");
        backBT = new JButton("Back");

        twoPlayersBT.setActionCommand("twoPlayersSelected");
        threePlayersBT.setActionCommand("threePlayersSelected");
        fourPlayersBT.setActionCommand("fourPlayersSelected");
        fivePlayersBT.setActionCommand("fivePlayersSelected");
        sixPlayersBT.setActionCommand("sixPlayersSelected");
        backBT.setActionCommand("backButtonSelected");

        selectPlayerMenu.add(twoPlayersBT);
        selectPlayerMenu.add(threePlayersBT);
        selectPlayerMenu.add(fourPlayersBT);
        selectPlayerMenu.add(fivePlayersBT);
        selectPlayerMenu.add(sixPlayersBT);
        selectPlayerMenu.add(backBT);

        add(selectPlayerMenu);

        setLocationRelativeTo(null);

    }

    public void addActionListeners(ActionListener listener){
        twoPlayersBT.addActionListener(listener);
        threePlayersBT.addActionListener(listener);
        fourPlayersBT.addActionListener(listener);
        fivePlayersBT.addActionListener(listener);
        sixPlayersBT.addActionListener(listener);
        backBT.addActionListener(listener);
    }

}
