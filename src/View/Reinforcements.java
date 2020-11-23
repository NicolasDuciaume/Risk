package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Reinforcements extends JDialog{

    private JPanel reinforcements;
    private JLabel reinforcementsLabel1;
    private JLabel reinforcementsLabel2;
    private JComboBox comboBox;
    private JComboBox comboBox2;

    private JButton reinforceBT;

    public Reinforcements(GameView main){
        super(main);
        setTitle("Reinforcements Menu");
        setSize(300,300);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2,3,2,3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5,5,5,5));
        reinforcements = new JPanel();
        reinforcements.setLayout(new GridLayout(10,1,10,6));

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
        border.add(borderLayout,BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);

    }

    public void addActionListeners(ActionListener listener){
        comboBox2.addActionListener(listener);
        reinforceBT.addActionListener(listener);
    }

    public JLabel getLabel(){
        return reinforcementsLabel2;
    }

    public JPanel getReinforcements() {
        return reinforcements;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }
}

