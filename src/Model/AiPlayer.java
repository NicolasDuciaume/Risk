package Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AiPlayer extends Player {
    private RiskModel model;
    /**
     * Model.Player constructor with one parameter.
     *
     * @param name the name of the player
     */
    public AiPlayer(String name, RiskModel model) {
        super(name);
        this.model = model;
    }

    public void AiMove(){
        AiAttack();
    }

    public int messageToDefender(Country defend){
        JComboBox temp = new JComboBox();
        JPanel a = new JPanel();
        JLabel label = new JLabel(super.getName() + " is attacking " + defend.getName() );
        JLabel label2 = new JLabel("How many dice would you to defend wit");
        if(defend.getArmiesOnCountry() == 1){
            temp.addItem(1);
        }
        else if(defend.getArmiesOnCountry() > 1){
            temp.addItem(1);
            temp.addItem(2);
        }
        temp.setSelectedIndex(0);
        a.setLayout(new GridLayout());
        a.add(label);
        a.add(label2);
        a.add(temp);
        JOptionPane.showMessageDialog( null, a, " Dice selection ", JOptionPane.QUESTION_MESSAGE);
        int t = (int) temp.getSelectedItem();
        return t;
    }

    public int getAttackerDie(Country attacker){
        int z = 0;
        if(attacker.getArmiesOnCountry() == 2){
            z = 1;
        }
        else if (attacker.getArmiesOnCountry() == 3){
            z = 2;
        }
        else if (attacker.getArmiesOnCountry() > 3){
            z = 3;
        }
        return z;
    }

    public void AiAttack(){
        ArrayList<Country> temp = super.getPlacedArmies();
        for(int x = 0; x < temp.size(); x++){
            Country testing = temp.get(x);
            int troops = testing.getArmiesOnCountry();
            if(troops >= 2){
                for(Country neighb : testing.getNeighbors()){
                    if(neighb.getArmiesOnCountry() < testing.getArmiesOnCountry()){
                        model.attack(this, neighb.getPlayerOnCountry(), neighb,testing,getAttackerDie(testing),messageToDefender(neighb));
                    }
                }
            }
        }
    }
}
