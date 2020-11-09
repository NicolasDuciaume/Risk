package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Reinforcements extends JDialog{

    private JPanel Reinforcements;
    private JLabel ReinforcementsLabel1;
    private JLabel ReinforcementsLabel2;

    private JButton test;

    public Reinforcements(GameView main){
        super(main);
        setTitle("Player Select Menu");
        setSize(300,300);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2,3,2,3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5,5,5,5));
        Reinforcements = new JPanel();
        Reinforcements.setLayout(new GridLayout(10,1,10,6));

        ReinforcementsLabel1 = new JLabel("Time for some reinforcements", JLabel.CENTER);
        ReinforcementsLabel2 = new JLabel("", JLabel.CENTER);



        Reinforcements.add(ReinforcementsLabel1);
        Reinforcements.add(ReinforcementsLabel2);


        borderLayout.add(Reinforcements);
        border.add(borderLayout,BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);

    }

    public void addActionListeners(ActionListener listener){

    }

    public JLabel getLabel(){
        return ReinforcementsLabel2;
    }

    public JPanel getReinforcements() {
        return Reinforcements;
    }
}

