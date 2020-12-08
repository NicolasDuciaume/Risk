/*
Author: Nicolas Duciaume
Refactoring: Kamran Sagheir
Comments: Hussain Al-Baidhani
 */

package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;
    private Reinforcements reinforcements;
    private MovementView movementView;
    private AttackView attack;
    private ArrayList<String> countries;

    /**
     * The constructor with two parameters for the GameController class
     * @param model the moddel class
     * @param view the view class
     */
    public GameController(RiskModel model,GameView view){
        this.model = model;
        this.view = view;
        this.countries = view.getCountries();

        reinforcements = new Reinforcements(this.view);
        reinforcements.addActionListeners(new ReinforcementsController(reinforcements,model,view));
        reinforcements.setVisible(true);

        view.addActionListener(this);
    }


    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("EndTurn")){
            movementView = new MovementView(this.view);
            movementView.addActionListeners(new MovementController(movementView,model,view));
            movementView.setVisible(true);


        }
        else{
            for(int i = 0; i < countries.size(); i++){
                if(e.getActionCommand().equals(countries.get(i))){
                    if(model.isOwned(countries.get(i))){
                        attack = new AttackView(this.view);
                        attack.addActionListeners(new AttackController(attack,model,view,countries.get(i)));
                        attack.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(view,"You do not own this country!");
                    }
                }
            }
        }
    }


}