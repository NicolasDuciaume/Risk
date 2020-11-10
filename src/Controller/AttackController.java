package Controller;

import Model.*;
import View.*;
import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AttackController implements ActionListener {

    private AttackView attack;
    private RiskModel model;
    private GameView view;
    private String Country;
    private JComboBox comboBox;
    private JComboBox attackBox;
    private JComboBox defendBox;
    private Player player;
    private Player playDefend;
    private Country Attacker;
    private Country Defender;
    int numAttackerOptions;
    int numDefenderOptions;

    int numDAtt;
    int numDDef;


    public AttackController(AttackView attack, RiskModel model, GameView view, String Country){
        this.attack = attack;
        this.model = model;
        this.view = view;
        this.Country = Country;
        player = model.getCurrentPlayer();
        comboBox = attack.getComboBox();
        attackBox = attack.getAttackBox();
        defendBox = attack.getDefendBox();


        for(Country c: player.getPlacedArmies()){
            if(c.getName().equals(Country)){
                Attacker = c;
            }
        }
        if(Attacker.getArmiesOnCountry() == 1){
            JOptionPane.showMessageDialog(view,"You do not own have enough troops on this country to attack");
        }
        else{
            doAttackStepOne(Country);
        }


    }

    private void doAttackStepOne(String Country){

        for(Country c: Attacker.getNeighbors()){
            if(c.getPlayerOnCountry() != player){
                comboBox.addItem(c.getName());
            }
        }
    }

    private void doAttackStepTwo(){
        int tempNum = Attacker.getArmiesOnCountry();
        if(tempNum == 2){
            numAttackerOptions = 1;
        }
        else if(tempNum == 3){
            numAttackerOptions = 2;
        }
        else if(tempNum > 3){
            numAttackerOptions = 3;
        }
        for(int x = 1; x <= numAttackerOptions; x++){
            String s = "" + x;
            attackBox.addItem(s);
        }
    }

    private void doAttackStepThree(){
        int tempNum = Defender.getArmiesOnCountry();
        if(tempNum == 1){
            numDefenderOptions = 1;
        }
        else if(tempNum == 2){
            numDefenderOptions = 2;
        }
        else if(tempNum > 3){
            numDefenderOptions = 2;
        }
        for(int x = 1; x <= numAttackerOptions; x++){
            String s = "" + x;
            defendBox.addItem(s);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox){
            String C = (String) comboBox.getSelectedItem();
            JLabel temp = attack.getAttackLabel2();
            JLabel temp2 = attack.getAttackLabel3();
            temp.setText(player.getName() + " how many dices would you like?");
            temp2.setText("Between 1 and 3, must have one more army on Country than amount of dice");
            temp.setVisible(true);
            temp2.setVisible(true);
            attackBox.setVisible(true);
            for(Country c: Attacker.getNeighbors()){
                if(c.getName().equals(C)){
                    Defender = c;
                }
            }
            doAttackStepTwo();

        }
        else if(e.getSource() == attackBox){
            String A = (String) attackBox.getSelectedItem();
            JLabel temp3 = attack.getAttackLabel4();
            JLabel temp4 = attack.getAttackLabel5();
            numDAtt = Integer.parseInt(A);
            playDefend = Defender.getPlayerOnCountry();
            temp3.setText(playDefend.getName() + " how many dices would you like?");
            temp4.setText("Between 1 and 2. If 2, you must have at least 2 armies on the Country");
            temp3.setVisible(true);
            temp4.setVisible(true);
            defendBox.setVisible(true);
            doAttackStepThree();

        }
        else if(e.getSource() == defendBox){
            String D = (String) defendBox.getSelectedItem();
            numDDef = Integer.parseInt(D);
            int [] zz = model.attack(player,playDefend,Defender,Attacker,numDAtt,numDDef);
            JOptionPane.showMessageDialog(view,Attacker.getName() + " Lost " +zz[0] + "Troops \r\n" + Defender.getName() + " Lost " + zz[1] + " Troops \r\n");
            if(zz[2] == 1){
                JOptionPane.showMessageDialog(view,player.getName() + " took control of " + Defender.getName());
            }
            if(zz[3] == 1){
                JOptionPane.showMessageDialog(view,playDefend.getName() + " has been eliminated");
            }
            view.UpdateMap();
            if(model.checkEnd()){
                JOptionPane.showMessageDialog(view,player.getName() + " has won the game!");
                System.exit(0);
            }
            attack.dispose();
        }

    }


}