package Controller;

import Model.*;
import View.*;
import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;

    private SelectPlayerMenu selectPlayerMenu;

    public GameController(RiskModel model,GameView view){
        this.model = model;
        this.view = view;

        view.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("newGame")){
            System.out.println("Start new game");

            //selectPlayerMenu = new SelectPlayerMenu(view);
            //selectPlayerMenu.addActionListeners(new SelectPlayerController(selectPlayerMenu,model,view));
            //selectPlayerMenu.setVisible(true);



        }else if(e.getActionCommand().equals("quit")){
            System.out.println("Quitting game");
            System.exit(0);
        }



    }
}