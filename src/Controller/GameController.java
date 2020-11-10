package Controller;

import Model.*;
import View.*;
import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;
    private Reinforcements reinforcements;

    private SelectPlayerMenu selectPlayerMenu;

    public GameController(RiskModel model,GameView view){
        this.model = model;
        this.view = view;

        reinforcements = new Reinforcements(this.view);
        reinforcements.addActionListeners(new ReinforcementsController(reinforcements,model,view));
        reinforcements.setVisible(true);


        view.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Player play = model.getCurrentPlayer();

        if(e.getActionCommand().equals("EndTurn")){

            model.endTurn();
            view.UpdateTurn(model.getCurrentPlayerName());
            reinforcements = new Reinforcements(this.view);
            reinforcements.addActionListeners(new ReinforcementsController(reinforcements,model,view));
            reinforcements.setVisible(true);

        }else if(e.getActionCommand().equals("NT")){
            if(model.DoesHeOwn("Northwest Territory")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }



    }


}