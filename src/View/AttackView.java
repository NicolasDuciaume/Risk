package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AttackView extends JDialog{

    private JPanel Attack;
    private JLabel AttackLabel1;
    private JLabel AttackLabel2;
    private JLabel AttackLabel3;
    private JLabel AttackLabel4;
    private JLabel AttackLabel5;
    private JComboBox comboBox;
    private JComboBox attackBox;
    private JComboBox defendBox;

    private JButton test;

    public AttackView(GameView main){
        super(main);
        setTitle("Attack Menu");
        setSize(600,600);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2,3,2,3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5,5,5,5));
        Attack = new JPanel();
        Attack.setLayout(new GridLayout(10,1,10,6));

        AttackLabel1 = new JLabel("Who do you Wish to attack", JLabel.CENTER);
        AttackLabel2 = new JLabel("", JLabel.CENTER);
        AttackLabel3 = new JLabel("", JLabel.CENTER);
        AttackLabel4 = new JLabel("", JLabel.CENTER);
        AttackLabel5 = new JLabel("", JLabel.CENTER);
        comboBox = new JComboBox();
        attackBox = new JComboBox();
        defendBox = new JComboBox();

        attackBox.setVisible(false);
        defendBox.setVisible(false);

        Attack.add(AttackLabel1);
        Attack.add(comboBox);
        Attack.add(AttackLabel2);
        Attack.add(AttackLabel3);
        Attack.add(attackBox);
        Attack.add(AttackLabel4);
        Attack.add(AttackLabel5);
        Attack.add(defendBox);

        borderLayout.add(Attack);
        border.add(borderLayout,BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);


    }

    public JComboBox getComboBox(){
        return comboBox;
    }

    public JComboBox getAttackBox() {
        return attackBox;
    }

    public JComboBox getDefendBox() {
        return defendBox;
    }

    public JLabel getAttackLabel2() {
        return AttackLabel2;
    }
    public JLabel getAttackLabel3() {
        return AttackLabel3;
    }
    public JLabel getAttackLabel4() {
        return AttackLabel4;
    }
    public JLabel getAttackLabel5() {
        return AttackLabel5;
    }

    public void addActionListeners(ActionListener listener){
        comboBox.addActionListener(listener);
        attackBox.addActionListener(listener);
    }


}