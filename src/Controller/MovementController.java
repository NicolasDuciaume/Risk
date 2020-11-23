package Controller;

import Model.*;
import View.*;
import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovementController implements ActionListener {

    private MovementView movement;
    private Reinforcements reinforcements;
    private RiskModel model;
    private GameView view;
    private int numberR;
    private ArrayList<Country> temp;
    private ArrayList<String> names;
    private JComboBox comboBox;
    private JComboBox comboBox2;
    private JComboBox number;
    private int s = 1;
    private Country moveFrom;
    private Country moveTo;

    public MovementController(MovementView movement, RiskModel model, GameView view){
        this.movement = movement;
        this.model = model;
        this.view = view;

        comboBox = movement.getComboBox();
        comboBox2 = movement.getMoveBox();
        number = movement.getNumber();

        temp = model.getCurrentPlayer().getPlacedArmies();

        for(Country c: temp){
            if(c.getArmiesOnCountry() > 1){
                comboBox.addItem(c.getName());
            }
        }

        check();

        comboBox.setSelectedIndex(0);
        StepTwo((String) comboBox.getSelectedItem());

        StepOne();


        StepThree((String) comboBox2.getSelectedItem());

    }

    public void check(){
        if(temp.size() == 1){
            JOptionPane.showMessageDialog(view,"Skipping movement phase because you only have 1 country");
            view.UpdateMap();
            movement.dispose();
            switchToReinforcement();
        }
        else{
            if(comboBox.getSelectedItem() == null){
                JOptionPane.showMessageDialog(view,"Skipping movement phase because all owned countries don't have enough troops on it");
                view.UpdateMap();
                movement.dispose();
                switchToReinforcement();
            }
        }
    }

    public void StepOne(){
        comboBox2.removeAllItems();
        for(Country c: moveFrom.getNeighbors()){
            if(c.getPlayerOnCountry().getName().equals(model.getCurrentPlayerName())){
                comboBox2.addItem(c.getName());
            }
        }
        //comboBox2.setSelectedIndex(0);
    }

    public void StepTwo(String count){
        number.removeAllItems();
        for(Country c: temp){
            if(count.equals(c.getName())){
                moveFrom = c;
            }
        }

        s = moveFrom.getArmiesOnCountry();
        for(int x = 1; x < s; x++){
            number.addItem(x);
        }

        number.setSelectedIndex(0);
    }

    public void StepThree(String count){
        s = (int) number.getSelectedItem();

        if(count == null){
            JOptionPane.showMessageDialog(view, "Skipping movement phase because you do not have any connected owned countries");
            view.UpdateMap();
            movement.dispose();
            switchToReinforcement();
        }
        else{
            for(Country c: moveFrom.getNeighbors()){
                if(count.equals(c.getName())){
                    moveTo = c;
                }
            }
        }
    }

    public void switchToReinforcement(){
        while(model.isNextPlayAi()){
            model.endTurn();
            //ai do something
            AiPlayer p = (AiPlayer) model.getCurrentPlayer();
            p.AiMove(view);
            JOptionPane.showMessageDialog(view,"Ai has played!");
            view.UpdateMap();
        }
        model.endTurn();
        view.UpdateTurn(model.getCurrentPlayerName());
        reinforcements = new Reinforcements(this.view);
        reinforcements.addActionListeners(new ReinforcementsController(reinforcements,model,view));
        reinforcements.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox){
            StepTwo((String) comboBox.getSelectedItem());
            StepOne();
        }
        else{
            if(e.getActionCommand().equals("Move")){
                StepThree((String) comboBox2.getSelectedItem());
                model.movement(moveFrom,moveTo,s);
                JOptionPane.showMessageDialog(view,moveFrom.getName() + " now has " + moveFrom.getArmiesOnCountry() + " troops and " + moveTo.getName() + " now has " + moveTo.getArmiesOnCountry() + " troops");
                view.UpdateMap();
                movement.dispose();
            }
            else if(e.getActionCommand().equals("Cancel")){
                view.UpdateMap();
                movement.dispose();
            }
            switchToReinforcement();
        }
    }
}