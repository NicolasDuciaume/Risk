package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;
    /**
     * The constructor with two parameters for the GameController class
     * @param model the moddel class
     * @param view the view class
     */
    public GameController(RiskModel model,GameView view){
        this.model = model;
        this.view = view;

        view.addActionListener(this);
    }

    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("EndTurn")){

            model.endTurn();
            view.UpdateTurn(model.getCurrentPlayerName());


        }else if(e.getActionCommand().equals("quit")){
            System.out.println("Quitting game");
            System.exit(0);
        }



    }
}