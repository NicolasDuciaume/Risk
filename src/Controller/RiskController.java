/*
Author: Nicolas Duciaume
 */
package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



/**
* The controller class for the game
*/
public class RiskController implements ActionListener {

    private RiskModel model;
    private RiskView view;
    private String customMapDirectory = "";

    private SelectPlayerMenu selectPlayerMenu;
    private LoadGameMenu loadGameMenu;

    /**
     * The two-parameter constructor
     * @param model the game model
     * @param view the game view
     */
    public RiskController(RiskModel model,RiskView view){
        this.model = model;
        this.view = view;
        view.addActionListener(this);
    }
    /**
     * The class's action listener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("newGame")){
            System.out.println("Start new game");

            selectPlayerMenu = new SelectPlayerMenu(view);
            selectPlayerMenu.addActionListeners(new SelectPlayerController(selectPlayerMenu,model,view, customMapDirectory));
            selectPlayerMenu.setVisible(true);

        }else if(e.getActionCommand().equals("quit")){
            System.out.println("Quitting game");
            System.exit(0);

        }else if(e.getActionCommand().equals("loadGame")){
            System.out.println("Loading Game");

            try {
                loadGameMenu = new LoadGameMenu(view);
                loadGameMenu.addActionListeners(new LoadGameController(loadGameMenu,model,view));
                loadGameMenu.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
        else if(e.getActionCommand().equals("CUSTOM")){
            JTextField customMapDirectoryTF = new JTextField("Enter custom map Directory");
            JOptionPane.showMessageDialog( null, customMapDirectoryTF, " Custom Map Selection ", JOptionPane.QUESTION_MESSAGE);
            customMapDirectory = customMapDirectoryTF.getText();
            System.out.println("Start new game");
            selectPlayerMenu = new SelectPlayerMenu(view);
            selectPlayerMenu.addActionListeners(new SelectPlayerController(selectPlayerMenu,model,view, customMapDirectory));
            selectPlayerMenu.setVisible(true);
        }
    }
}
