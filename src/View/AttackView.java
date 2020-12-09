/*
Author: Nicolas Duciaume
 */
package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AttackView extends JDialog {

    private JPanel attack;
    private JLabel attackLabel1;
    private JLabel attackLabel2;
    private JLabel attackLabel3;
    private JLabel attackLabel4;
    private JLabel attackLabel5;
    private JComboBox comboBox;
    private JComboBox attackBox;
    private JComboBox defendBox;
    private JButton attackBT;

    /**
     * The default constructor for the attackView class
     *
     * @param main - the main view of the game
     */
    public AttackView(GameView main) {
        super(main);
        setTitle("Attack Menu");
        setSize(600, 600);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        attackBT = new JButton("ATTACK!");
        attackBT.setActionCommand("ATTACK");
        attack = new JPanel();
        attack.setLayout(new GridLayout(10, 1, 10, 6));

        attackLabel1 = new JLabel("Who do you Wish to attack", JLabel.CENTER);
        attackLabel2 = new JLabel("Attacker how many dices would you like", JLabel.CENTER);
        attackLabel3 = new JLabel("Between 1 and 3, must have one more army on Country than amount of dice", JLabel.CENTER);
        attackLabel4 = new JLabel("Defender how many dices would you like", JLabel.CENTER);
        attackLabel5 = new JLabel("Between 1 and 2. If 2, you must have at least 2 armies on the Country", JLabel.CENTER);

        comboBox = new JComboBox();
        attackBox = new JComboBox();
        defendBox = new JComboBox();

        attack.add(attackLabel1);
        attack.add(comboBox);
        attack.add(attackLabel2);
        attack.add(attackLabel3);
        attack.add(attackBox);
        attack.add(attackLabel4);
        attack.add(attackLabel5);
        attack.add(defendBox);
        attack.add(attackBT);

        borderLayout.add(attack);
        border.add(borderLayout, BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);

    }

    /**
     * This function returns the combo box of the country you wish to attack
     *
     * @return combo box of enemies
     */
    public JComboBox getComboBox() {
        return comboBox;
    }

    /**
     * This function returns the combo box of the amount of dice the attacker wants
     *
     * @return combo box of amount of dice
     */
    public JComboBox getAttackBox() {
        return attackBox;
    }

    /**
     * This function returns the combo box of the amount of dice the defender wants
     *
     * @return combo box of amount of dice
     */
    public JComboBox getDefendBox() {
        return defendBox;
    }

    public JLabel getAttackLabel2() {
        return attackLabel2;
    }

    public JLabel getAttackLabel3() {
        return attackLabel3;
    }

    public JLabel getAttackLabel4() {
        return attackLabel4;
    }

    public JLabel getAttackLabel5() {
        return attackLabel5;
    }

    /**
     * The acitonListener for the class
     *
     * @param listener the action listener
     */
    public void addActionListeners(ActionListener listener) {
        comboBox.addActionListener(listener);
        attackBT.addActionListener(listener);
    }


}