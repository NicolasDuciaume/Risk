package Controller;

import View.RiskView;
import View.SelectPlayerMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiskController implements ActionListener {

    private RiskView view;

    private SelectPlayerMenu selectPlayerMenu;

    public RiskController(RiskView view){
        this.view = view;

        view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("newGame")){
            System.out.println("start new game");

            selectPlayerMenu = new SelectPlayerMenu(view);
            selectPlayerMenu.addActionListeners(new SelectPlayerController(selectPlayerMenu));
            selectPlayerMenu.setVisible(true);


        }else if(e.getActionCommand().equals("quit")){
            System.out.println("quitting game");
            System.exit(0);
        }



    }
}
