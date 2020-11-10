package Controller;

import Model.*;
import View.*;
import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReinforcementsController implements ActionListener {

    private Reinforcements reinforcements;
    private RiskModel model;
    private GameView view;
    private JLabel num;
    private int numberR;
    private ArrayList<Country> temp;
    private ArrayList<String> names;
    private JComboBox comboBox;
    private JComboBox comboBox2;

    public ReinforcementsController(Reinforcements reinforcements, RiskModel model, GameView view){
        this.reinforcements = reinforcements;
        this.model = model;
        this.view = view;

        numberR = model.reinforce();
        num = reinforcements.getLabel();
        num.setText("You can place " + numberR + " troops");
        comboBox = reinforcements.getComboBox();
        comboBox2 = reinforcements.getComboBox2();

        temp = model.getCurrentPlayer().getPlacedArmies();

        for(Country c: temp){
           comboBox.addItem(c.getName());
        }
        for(int x = 1; x <= numberR; x++){
            comboBox2.addItem(x);
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String S = (String) comboBox.getSelectedItem();
        int s = (int) comboBox2.getSelectedItem();
        model.reinforcement(s,S);
        numberR = numberR - s;
        num.setText("You can place " + numberR + " troops");
        comboBox2.removeAllItems();
        for(int x = 1; x <= numberR; x++){
            comboBox2.addItem(x);
        }
        if(numberR == 0){
            reinforcements.dispose();
        }
        view.UpdateMap();
    }


}