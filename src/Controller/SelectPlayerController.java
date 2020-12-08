/*
Author: Kamran Sagheir & Hussain Al-Baidhani
comments: Hussain Al-Baidhani
 */
package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SelectPlayerController implements ActionListener {

    private SelectPlayerMenu selectPlayerMenu;
    private RiskModel model;
    private RiskView view;
    private String cust;


    /**
     * The constructor with three parameters
     * @param selectPlayerMenu the player menu
     * @param model the game model
     * @param view the game view
     */
    public SelectPlayerController(SelectPlayerMenu selectPlayerMenu, RiskModel model, RiskView view, String cust){
        this.selectPlayerMenu = selectPlayerMenu;
        this.model = model;
        this.view = view;
        this.cust = cust;
    }

    public int setAis(int num){
        JComboBox temp = new JComboBox();
        JPanel p = new JPanel();
        JLabel label = new JLabel("Select the amount of Ai players you want:");
        p.add(label);
        for(int x = 0; x < num; x++){
            temp.addItem(x);
        }
        p.add(temp);
        JOptionPane.showMessageDialog( null, p, "AI Selection", JOptionPane.QUESTION_MESSAGE);
        int t = (int) temp.getSelectedItem();
        return t;
    }

    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionEvent = e.getActionCommand();

        if(actionEvent.equals("twoPlayersSelected")){
            System.out.println("2 Players Selected");
            model.playerSelection("2" , setAis(2));
        }else if(actionEvent.equals("threePlayersSelected")){
            System.out.println("3 Players Selected");
            model.playerSelection("3", setAis(3));
        }else if(actionEvent.equals("fourPlayersSelected")){
            System.out.println("4 Players Selected");
            model.playerSelection("4",setAis(4));
        }else if(actionEvent.equals("fivePlayersSelected")){
            System.out.println("5 Players Selected");
            model.playerSelection("5",setAis(5));
        }else if (actionEvent.equals("sixPlayersSelected")){
            System.out.println("6 Players Selected");
            model.playerSelection("6",setAis(6));
        }else if(actionEvent.equals("backButtonSelected")){
            selectPlayerMenu.dispose();
        }

        selectPlayerMenu.setVisible(false);
        //model.populate(cust.isCustom());
        view.dispose();
        if(!cust.equals("")){
            try {
                new GameView(model, cust);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else{
            try {
                new GameView(model, "/RiskMile4/src/View/testRisk.json");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }
}
