package Model;

import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AiPlayer extends Player {
    private RiskModel model;
    private int numberR = 0;
    /**
     * Model.Player constructor with one parameter.
     *
     * @param name the name of the player
     */
    public AiPlayer(String name, RiskModel model) {
        super(name);
        this.model = model;
    }

    public void AiMove(GameView view){
        AiReinforce(view);
        AiAttack(view);
        AiMovement(view);
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

    public void AiReinforce(GameView view){
        numberR = model.reinforce();
        int difference = 0;
        Country CountryToReinforce = null;
        for(Country owned : this.getPlacedArmies()){
            ArrayList<Country> temp = owned.getNeighbors();
            for(Country neighb : temp){
                if(!neighb.getPlayerOnCountry().getName().equals(this.getName())){
                    if(neighb.getArmiesOnCountry() >= owned.getArmiesOnCountry()){
                        if(difference < (neighb.getArmiesOnCountry() - owned.getArmiesOnCountry())){
                            difference = neighb.getArmiesOnCountry() - owned.getArmiesOnCountry();
                            CountryToReinforce = owned;
                        }
                    }
                }
            }
        }
        if(CountryToReinforce == null){
            CountryToReinforce = this.getPlacedArmies().get(0);
        }
        model.reinforcement(numberR,CountryToReinforce.getName());
        JOptionPane.showMessageDialog(view,this.getName() + " placed " + numberR + " reinforcement troops on " + CountryToReinforce.getName());
        view.UpdateMap();
    }

    public void AiMovement(GameView view){
        int difference = 0;
        int difference2 = 0;
        int difference3 = 0;
        Country threat = null;
        Country CountryToMove = null;
        Country CountryToGet = null;
        for(Country owned : this.getPlacedArmies()){
            for(Country neigh: owned.getNeighbors()){
                if(!neigh.getPlayerOnCountry().getName().equals(this.getName())){
                    if(neigh.getArmiesOnCountry() > difference){
                        difference = neigh.getArmiesOnCountry();
                        threat = neigh;
                    }
                }
            }
        }
        if (threat != null) {
            for(Country o: threat.getNeighbors()){
                if(o.getPlayerOnCountry().getName().equals(this.getName())){
                    if(threat.getArmiesOnCountry() >= o.getArmiesOnCountry()){
                        if(difference2 < (threat.getArmiesOnCountry() - o.getArmiesOnCountry())){
                            difference2 = threat.getArmiesOnCountry() - o.getArmiesOnCountry();
                            CountryToGet = o;
                        }
                    }
                }
            }
            if(CountryToGet != null){
                for(Country neighGood: CountryToGet.getNeighbors()){
                    if(neighGood.getPlayerOnCountry().getName().equals(this.getName())){
                        if((neighGood.getArmiesOnCountry() > 1) && (neighGood.getArmiesOnCountry() > difference3)){
                            difference3 = neighGood.getArmiesOnCountry();
                            CountryToMove = neighGood;
                        }
                    }
                }
                if(CountryToMove != null){
                    model.movement(CountryToMove,CountryToGet,difference3 - 1);
                    JOptionPane.showMessageDialog(view,this.getName() + " moved " + (difference3 - 1) + " from " + CountryToMove.getName() + " to " + CountryToGet.getName());
                    view.UpdateMap();
                }
            }
        }

    }

    public void AiAttack(GameView view){
        ArrayList<Country> temp = this.getPlacedArmies();
        for(int x = 0; x < temp.size(); x++){
            Country testing = temp.get(x);
            int troops = testing.getArmiesOnCountry();
            if(troops >= 2){
                for(Country neighb : testing.getNeighbors()){
                    if(!neighb.getPlayerOnCountry().getName().equals(this.getName())){
                        if(neighb.getArmiesOnCountry() < testing.getArmiesOnCountry()){
                            int [] zz = model.attack(this, neighb.getPlayerOnCountry(), neighb,testing,getAttackerDie(testing),messageToDefender(neighb));
                            JOptionPane.showMessageDialog(view,testing.getName() + " Lost " +zz[0] + "Troops \r\n" + neighb.getName() + " Lost " + zz[1] + " Troops \r\n");
                            if(zz[2] == 1){
                                JOptionPane.showMessageDialog(view,this.getName() + " took control of " + neighb.getName());
                            }
                            if(zz[3] == 1){
                                JOptionPane.showMessageDialog(view,neighb.getPlayerOnCountry().getName() + " has been eliminated");
                            }
                            view.UpdateMap();
                            if(model.checkEnd()){
                                JOptionPane.showMessageDialog(view,this.getName() + " has won the game!");
                                System.exit(0);
                            }
                            view.UpdateMap();
                        }
                    }
                }
            }
        }
    }
}
