package Controller;

import Model.*;
import View.*;
import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPlayerController implements ActionListener {

    private SelectPlayerMenu selectPlayerMenu;
    private RiskModel model;
    private RiskView view;

    public SelectPlayerController(SelectPlayerMenu selectPlayerMenu, RiskModel model, RiskView view){
        this.selectPlayerMenu = selectPlayerMenu;
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionEvent = e.getActionCommand();

        if(actionEvent.equals("twoPlayersSelected")){
            System.out.println("2 Players Selected");
            model.playerSelection("2");
        }else if(actionEvent.equals("threePlayersSelected")){
            System.out.println("3 Players Selected");
            model.playerSelection("3");
        }else if(actionEvent.equals("fourPlayersSelected")){
            System.out.println("4 Players Selected");
            model.playerSelection("4");
        }else if(actionEvent.equals("fivePlayersSelected")){
            System.out.println("5 Players Selected");
            model.playerSelection("5");
        }else if (actionEvent.equals("sixPlayersSelected")){
            System.out.println("6 Players Selected");
            model.playerSelection("6");
        }else if(actionEvent.equals("backButtonSelected")){
            selectPlayerMenu.dispose();
        }

        selectPlayerMenu.setVisible(false);
        model.populate();
        view.dispose();
        GameView game = new GameView();

    }
}
