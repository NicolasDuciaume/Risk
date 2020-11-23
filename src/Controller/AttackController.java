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
    private JLabel label1;
    private JLabel label2;

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
        label1 = attack.getAttackLabel4();
        label2 = attack.getAttackLabel5();


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

        if(comboBox.getSelectedItem() != null){
            comboBox.setSelectedIndex(0);
            String C = (String) comboBox.getSelectedItem();
            for(Country c: Attacker.getNeighbors()){
                if(C.equals(c.getName())){
                    Defender = c;
                }
            }

            doAttackStepThree();
        }


    }


    private void doAttackStepOne(String Country){

        for(Country c: Attacker.getNeighbors()){
            if(c.getPlayerOnCountry() != player){
                comboBox.addItem(c.getName());
            }
        }

        if(comboBox.getSelectedItem() == null){
            JOptionPane.showMessageDialog(view,"You have no neighbors that you can attack from this country");
            attack.dispose();

        }
    }

    private void doAttackStepThree(){

        attackBox.removeAllItems();
        defendBox.removeAllItems();

        int tempNum1 = Attacker.getArmiesOnCountry();
        if(tempNum1 == 2){
            numAttackerOptions = 1;
        }
        else if(tempNum1 == 3){
            numAttackerOptions = 2;
        }
        else if(tempNum1 > 3){
            numAttackerOptions = 3;
        }
        for(int x = 1; x <= numAttackerOptions; x++){
            String s = "" + x;
            attackBox.addItem(s);
        }

        int tempNum = Defender.getArmiesOnCountry();
        String subName = Defender.getPlayerOnCountry().getName().substring(0,2);
        if(subName.equals("Ai")){
            label1.setVisible(false);
            label2.setText("Ai player has selected his amount of dice");
            if(tempNum == 1){
                defendBox.addItem("1");
            }else{
                defendBox.addItem("2");
            }
            defendBox.setSelectedIndex(0);
            defendBox.setEnabled(false);
        }
        else{
            label1.setVisible(true);
            label2.setText("Between 1 and 2. If 2, you must have at least 2 armies on the Country");
            if(tempNum == 1){
                numDefenderOptions = 1;
            }
            else if(tempNum == 2){
                numDefenderOptions = 2;
            }
            else if(tempNum >= 3){
                numDefenderOptions = 2;
            }
            for(int x = 1; x <= numDefenderOptions; x++){
                String s = "" + x;
                defendBox.addItem(s);
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == comboBox){
            String C = (String) comboBox.getSelectedItem();
            for(Country c: Attacker.getNeighbors()){
                if(C.equals(c.getName())){
                    Defender = c;
                }
            }
            doAttackStepThree();
        }

        if(e.getActionCommand().equals("ATTACK")){
            String A = (String) attackBox.getSelectedItem();
            numDAtt = Integer.parseInt(A);
            playDefend = Defender.getPlayerOnCountry();

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