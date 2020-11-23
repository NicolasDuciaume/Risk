package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MovementView extends JDialog{

    private JPanel move;
    private JLabel moveLabel1;
    private JLabel moveLabel2;
    private JLabel moveLabel3;
    private JLabel moveLabel4;
    private JLabel moveLabel5;
    private JComboBox comboBox;
    private JComboBox moveBox;
    private JComboBox number;
    private JButton moveBT;
    private JButton cancelBT;

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
        moveBT = new JButton("Move!");
        moveBT.setActionCommand("Move");
        cancelBT = new JButton("Cancel");
        cancelBT.setActionCommand("Cancel");
        move = new JPanel();
        JPanel buttonBorder = new JPanel();
        move.setLayout(new GridLayout(10,1,10,6));
        buttonBorder.setLayout(new GridLayout(1,2,10,6));

        moveLabel1 = new JLabel("You can move troops from one country to a connected country before ending your turn ", JLabel.CENTER);
        moveLabel2 = new JLabel("Select country to move troops from:", JLabel.CENTER);
        moveLabel3 = new JLabel("Select connected country to move troops to", JLabel.CENTER);
        moveLabel4 = new JLabel("Press move to move troops or cancel to not move at all", JLabel.CENTER);
        moveLabel5 = new JLabel("Select the number of troops you want to move", JLabel.CENTER);

        comboBox = new JComboBox();
        moveBox = new JComboBox();
        number = new JComboBox();



        move.add(moveLabel1);
        move.add(moveLabel2);
        move.add(comboBox);
        move.add(moveLabel3);
        move.add(moveBox);
        move.add(moveLabel5);
        move.add(number);
        move.add(moveLabel4);

        buttonBorder.add(moveBT);
        buttonBorder.add(cancelBT);

        move.add(buttonBorder);

        borderLayout.add(move);
        border.add(borderLayout,BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);


    }

    public JComboBox getComboBox(){
        return comboBox;
    }

    public JComboBox getMoveBox() {
        return moveBox;
    }

    public JComboBox getNumber() {
        return number;
    }

    public void addActionListeners(ActionListener listener){
        comboBox.addActionListener(listener);
        moveBT.addActionListener(listener);
        cancelBT.addActionListener(listener);
    }


}
