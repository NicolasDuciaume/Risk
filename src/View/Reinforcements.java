/*
Author: Nicolas Duciaume
 */
package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Reinforcements extends JDialog {

    private JPanel reinforcements;
    private JLabel reinforcementsLabel1;
    private JLabel reinforcementsLabel2;
    private JComboBox comboBox;
    private JComboBox comboBox2;

    private JButton reinforceBT;

    /**
     * The default constructor for the Reinforcements class
     *
     * @param main - the main view of the game
     */
    public Reinforcements(GameView main) {
        super(main);
        setTitle("Reinforcements Menu");
        setSize(300, 300);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        reinforcements = new JPanel();
        reinforcements.setLayout(new GridLayout(10, 1, 10, 6));

        reinforcementsLabel1 = new JLabel("Time for some reinforcements", JLabel.CENTER);
        reinforcementsLabel2 = new JLabel("", JLabel.CENTER);
        comboBox = new JComboBox();
        comboBox2 = new JComboBox();
        reinforceBT = new JButton("Reinforce!");

        reinforceBT.setActionCommand("Reinforce!");

        reinforcements.add(reinforcementsLabel1);
        reinforcements.add(reinforcementsLabel2);
        reinforcements.add(comboBox);
        reinforcements.add(comboBox2);
        reinforcements.add(reinforceBT);

        borderLayout.add(reinforcements);
        border.add(borderLayout, BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);

    }

    /**
     * The acitonListener for the class
     *
     * @param listener the action listener
     */
    public void addActionListeners(ActionListener listener) {
        comboBox2.addActionListener(listener);
        reinforceBT.addActionListener(listener);
    }

    /**
     * This function returns the label that says how many troops you can move left
     *
     * @return label of amount of troops to move
     */
    public JLabel getLabel() {
        return reinforcementsLabel2;
    }

    /**
     * This function returns the jpanel for the reinforcement
     *
     * @return JPanel for the reinforcments
     */
    public JPanel getReinforcements() {
        return reinforcements;
    }

    /**
     * This function returns the combo box of the name of countries you own that you can reinforce
     *
     * @return combo box of names of countries you own
     */
    public JComboBox getComboBox() {
        return comboBox;
    }

    /**
     * This function returns the combo box of the amount of troops you want to send to the specified country
     *
     * @return combo box of number of troops you want to send
     */
    public JComboBox getComboBox2() {
        return comboBox2;
    }
}

