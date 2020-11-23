package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReinforcementsController implements ActionListener {

    private Reinforcements reinforcements;
    private RiskModel model;
    private GameView view;
    private JLabel num;
    private int numOfReinforcements;
    private ArrayList<Country> temp;
    private ArrayList<String> names;
    private JComboBox comboBox;
    private JComboBox comboBox2;
    private int s = 1;

    public ReinforcementsController(Reinforcements reinforcements, RiskModel model, GameView view){
        this.reinforcements = reinforcements;
        this.model = model;
        this.view = view;

        numOfReinforcements = model.reinforce();
        num = reinforcements.getLabel();
        num.setText("You can place " + numOfReinforcements + " troops");
        comboBox = reinforcements.getComboBox();
        comboBox2 = reinforcements.getComboBox2();

        temp = model.getCurrentPlayer().getPlacedArmies();

        for(Country c: temp){
           comboBox.addItem(c.getName());
        }
        for(int x = 1; x <= numOfReinforcements; x++){
            comboBox2.addItem(x);
        }




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reinforce!")){
            String S = (String) comboBox.getSelectedItem();
            s = (int) comboBox2.getSelectedItem();
            model.reinforcement(s,S);
            numOfReinforcements = numOfReinforcements - s;
            num.setText("You can place " + numOfReinforcements + " troops");
            comboBox2.removeAllItems();
            for(int x = 1; x <= numOfReinforcements; x++){
                comboBox2.addItem(x);
            }
            if(numOfReinforcements == 0){
                reinforcements.dispose();
            }
            view.updateMap();
        }

    }


}