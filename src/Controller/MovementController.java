/*
Author: Nicolas Duciaume and Christopher D'silva
Refactoring: Kamran Sagheir
 */

package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovementController implements ActionListener {

    private MovementView movement;
    private Reinforcements reinforcements;
    private RiskModel model;
    private GameView view;
    private ArrayList<Country> temp;
    private ArrayList<String> names;
    private JComboBox comboBox;
    private JComboBox comboBox2;
    private JComboBox number;
    private int s = 1;
    private Country moveFrom;
    private Country moveTo;

    /**
     * The constructor with two parameters for the GameController class
     *
     * @param movement the view class of the movement view
     * @param model    the model class
     * @param view     the view class
     */
    public MovementController(MovementView movement, RiskModel model, GameView view) {
        this.movement = movement;
        this.model = model;
        this.view = view;

        comboBox = movement.getComboBox();
        comboBox2 = movement.getMoveBox();
        number = movement.getNumber();

        temp = model.getCurrentPlayer().getPlacedArmies();

        for (Country c : temp) {
            if (c.getArmiesOnCountry() > 1) {
                comboBox.addItem(c.getName());
            }
        }

        check();

        comboBox.setSelectedIndex(0);
        stepTwo((String) comboBox.getSelectedItem());

        stepOne();

        stepThree((String) comboBox2.getSelectedItem());

    }

    public void check() {
        if (temp.size() == 1) {
            JOptionPane.showMessageDialog(view, "Skipping movement phase because you only have 1 country");
            view.updateMap();
            movement.dispose();
            switchToReinforcement();
        } else {
            if (comboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(view, "Skipping movement phase because all owned countries don't have enough troops on it");
                view.updateMap();
                movement.dispose();
                switchToReinforcement();
            }
        }
    }

    public void stepOne() {
        comboBox2.removeAllItems();
        for (Country c : moveFrom.getNeighbors()) {
            if (c.getPlayerOnCountry().getName().equals(model.getCurrentPlayerName())) {
                comboBox2.addItem(c.getName());
            }
        }
        //comboBox2.setSelectedIndex(0);
    }

    public void stepTwo(String count) {
        number.removeAllItems();
        for (Country c : temp) {
            if (count.equals(c.getName())) {
                moveFrom = c;
            }
        }

        s = moveFrom.getArmiesOnCountry();
        for (int x = 1; x < s; x++) {
            number.addItem(x);
        }

        number.setSelectedIndex(0);
    }

    public void stepThree(String count) {
        s = (int) number.getSelectedItem();

        if (count == null) {
            JOptionPane.showMessageDialog(view, "Skipping movement phase because you do not have any connected owned countries");
            view.updateMap();
            movement.dispose();
            switchToReinforcement();
        } else {
            for (Country c : moveFrom.getNeighbors()) {
                if (count.equals(c.getName())) {
                    moveTo = c;
                }
            }
        }
    }

    public void switchToReinforcement() {
        while (model.isNextPlayAi()) {
            model.endTurn();
            //ai do something
            AiPlayer p = (AiPlayer) model.getCurrentPlayer();
            p.aiMove(view);
            JOptionPane.showMessageDialog(view, "Ai has played!");
            view.updateMap();
        }
        model.endTurn();
        view.updateTurn(model.getCurrentPlayerName());
        reinforcements = new Reinforcements(this.view);
        reinforcements.addActionListeners(new ReinforcementsController(reinforcements, model, view));
        reinforcements.setVisible(true);

    }

    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            stepTwo((String) comboBox.getSelectedItem());
            stepOne();
        } else {
            if (e.getActionCommand().equals("Move")) {
                stepThree((String) comboBox2.getSelectedItem());
                model.movement(moveFrom, moveTo, s);
                JOptionPane.showMessageDialog(view, moveFrom.getName() + " now has " + moveFrom.getArmiesOnCountry() + " troops and " + moveTo.getName() + " now has " + moveTo.getArmiesOnCountry() + " troops");
                view.updateMap();
                movement.dispose();
            } else if (e.getActionCommand().equals("Cancel")) {
                view.updateMap();
                movement.dispose();
            }
            switchToReinforcement();
        }
    }
}