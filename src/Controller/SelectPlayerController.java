package Controller;

import View.*;
import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPlayerController implements ActionListener {

    private SelectPlayerMenu selectPlayerMenu;

    public SelectPlayerController(SelectPlayerMenu selectPlayerMenu){
        this.selectPlayerMenu = selectPlayerMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionEvent = e.getActionCommand();

        if(actionEvent.equals("twoPlayersSelected")){
            System.out.println("2 Players Selected");
        }else if(actionEvent.equals("threePlayersSelected")){
            System.out.println("3 Players Selected");
        }else if(actionEvent.equals("fourPlayersSelected")){
            System.out.println("4 Players Selected");
        }else if(actionEvent.equals("fivePlayersSelected")){
            System.out.println("5 Players Selected");
        }else if (actionEvent.equals("sixPlayersSelected")){
            System.out.println("6 Players Selected");
        }else if(actionEvent.equals("backButtonSelected")){
            selectPlayerMenu.dispose();
        }

        selectPlayerMenu.setVisible(false);
    }
}
