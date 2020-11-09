package Controller;

import Model.*;
import View.*;
import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiskController implements ActionListener {

    private RiskModel model;
    private RiskView view;

    private SelectPlayerMenu selectPlayerMenu;

    public RiskController(RiskModel model,RiskView view){
        this.model = model;
        this.view = view;

        view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("newGame")){
            System.out.println("Start new game");

            selectPlayerMenu = new SelectPlayerMenu(view);
            selectPlayerMenu.addActionListeners(new SelectPlayerController(selectPlayerMenu));
            selectPlayerMenu.setVisible(true);


        }else if(e.getActionCommand().equals("quit")){
            System.out.println("Quitting game");
            System.exit(0);
        }



    }
}
