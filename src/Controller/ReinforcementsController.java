package Controller;

import Model.*;
import View.*;
import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReinforcementsController implements ActionListener {

    private Reinforcements reinforcements;
    private RiskModel model;
    private GameView view;
    private JLabel num;

    public ReinforcementsController(Reinforcements reinforcements, RiskModel model, GameView view){
        this.reinforcements = reinforcements;
        this.model = model;
        this.view = view;

        num = reinforcements.getLabel();
        num.setText("You can place " + model.reinforce() + " troops");

        JPanel j = reinforcements.getReinforcements();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionEvent = e.getActionCommand();



    }
}