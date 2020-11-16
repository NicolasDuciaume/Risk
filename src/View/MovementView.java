package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MovementView extends JDialog{

    private JPanel Move;
    private JLabel MoveLabel1;
    private JLabel MoveLabel2;
    private JLabel MoveLabel3;
    private JLabel MoveLabel4;
    private JLabel MoveLabel5;
    private JComboBox comboBox;
    private JComboBox MoveBox;
    private JComboBox number;
    private JButton m;
    private JButton dont;

    private JButton test;

    public MovementView(GameView main){
        super(main);
        setTitle("Movement Menu");
        setSize(600,600);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2,3,2,3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5,5,5,5));
        m = new JButton("Move!");
        m.setActionCommand("Move");
        dont = new JButton("Cancel");
        dont.setActionCommand("Cancel");
        Move = new JPanel();
        JPanel buttonBorder = new JPanel();
        Move.setLayout(new GridLayout(10,1,10,6));
        buttonBorder.setLayout(new GridLayout(1,2,10,6));

        MoveLabel1 = new JLabel("You can move troops from one country to a connected country before ending your turn ", JLabel.CENTER);
        MoveLabel2 = new JLabel("Select country to move troops from:", JLabel.CENTER);
        MoveLabel3 = new JLabel("Select connected country to move troops to", JLabel.CENTER);
        MoveLabel4 = new JLabel("Press move to move troops or cancel to not move at all", JLabel.CENTER);
        MoveLabel5 = new JLabel("Select the number of troops you want to move", JLabel.CENTER);

        comboBox = new JComboBox();
        MoveBox = new JComboBox();
        number = new JComboBox();



        Move.add(MoveLabel1);
        Move.add(MoveLabel2);
        Move.add(comboBox);
        Move.add(MoveLabel3);
        Move.add(MoveBox);
        Move.add(MoveLabel5);
        Move.add(number);
        Move.add(MoveLabel4);

        buttonBorder.add(m);
        buttonBorder.add(dont);

        Move.add(buttonBorder);

        borderLayout.add(Move);
        border.add(borderLayout,BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);


    }

    public JComboBox getComboBox(){
        return comboBox;
    }

    public JComboBox getMoveBox() {
        return MoveBox;
    }

    public JComboBox getNumber() {
        return number;
    }

    public void addActionListeners(ActionListener listener){
        comboBox.addActionListener(listener);
        m.addActionListener(listener);
        dont.addActionListener(listener);
    }


}
