package Model;

import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AiPlayer extends Player {
    private RiskModel model;
    private int numOfReinforcements = 0;
    /**
     * Model.Player constructor with one parameter.
     *
     * @param name the name of the player
     */
    public AiPlayer(String name, RiskModel model) {
        super(name);
        this.model = model;
    }

    public void aiMove(GameView view){
        aiReinforce(view);
        aiAttack(view);
        aiMovement(view);
    }

    public int messageToDefender(Country defender, Country attacker){
        JComboBox temp = new JComboBox();
        JPanel a = new JPanel();
        JLabel label = new JLabel(super.getName() +"'s " + attacker.getName() + " is attacking " + defender.getName() );
        JLabel label2 = new JLabel("How many dice would you to defend with");
        if(defender.getArmiesOnCountry() == 1){
            temp.addItem(1);
        }
        else if(defender.getArmiesOnCountry() > 1){
            temp.addItem(1);
            temp.addItem(2);
        }
        temp.setSelectedIndex(0);
        a.setLayout(new GridLayout(3,1));
        a.add(label);
        a.add(label2);
        a.add(temp);
        JOptionPane.showMessageDialog( null, a, " Dice selection ", JOptionPane.QUESTION_MESSAGE);
        int t = (int) temp.getSelectedItem();
        return t;
    }

    public int getAttackerDie(Country attacker){
        int attackerDie = 0;
        if(attacker.getArmiesOnCountry() == 2){
            attackerDie = 1;
        }
        else if (attacker.getArmiesOnCountry() == 3){
            attackerDie = 2;
        }
        else if (attacker.getArmiesOnCountry() > 3){
            attackerDie = 3;
        }
        return attackerDie;
    }

    public void aiReinforce(GameView view){
        numOfReinforcements = model.reinforce();
        int difference = 0;
        Country countryToReinforce = null;
        for(Country owned : this.getPlacedArmies()){
            ArrayList<Country> temp = owned.getNeighbors();
            for(Country neighbour : temp){
                if(!neighbour.getPlayerOnCountry().getName().equals(this.getName())){
                    if(neighbour.getArmiesOnCountry() >= owned.getArmiesOnCountry()){
                        if(difference < (neighbour.getArmiesOnCountry() - owned.getArmiesOnCountry())){
                            difference = neighbour.getArmiesOnCountry() - owned.getArmiesOnCountry();
                            countryToReinforce = owned;
                        }
                    }
                }
            }
        }
        if(countryToReinforce == null){
            countryToReinforce = this.getPlacedArmies().get(0);
        }
        model.reinforcement(numOfReinforcements,countryToReinforce.getName());
        JOptionPane.showMessageDialog(view,this.getName() + " placed " + numOfReinforcements + " reinforcement troops on " + countryToReinforce.getName());
        view.updateMap();
    }

    public void aiMovement(GameView view){
        int difference = 0;
        int difference2 = 0;
        int difference3 = 0;
        Country threat = null;
        Country CountryToMove = null;
        Country CountryToGet = null;
        for(Country owned : this.getPlacedArmies()){
            for(Country neighbouring: owned.getNeighbors()){
                if(!neighbouring.getPlayerOnCountry().getName().equals(this.getName())){
                    if(neighbouring.getArmiesOnCountry() > difference){
                        difference = neighbouring.getArmiesOnCountry();
                        threat = neighbouring;
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
                    view.updateMap();
                }
            }
        }

    }

    public void aiAttack(GameView view){
        ArrayList<Country> placedArmies = this.getPlacedArmies();
        for(int x = 0; x < placedArmies.size(); x++){
            Country country = placedArmies.get(x);
            int troops = country.getArmiesOnCountry();
            if(troops >= 2){
                for(Country neighbour : country.getNeighbors()){
                    if(!neighbour.getPlayerOnCountry().getName().equals(this.getName())){
                        if(neighbour.getArmiesOnCountry() < country.getArmiesOnCountry()){
                            int [] zz = model.attack(this, neighbour.getPlayerOnCountry(), neighbour,country,getAttackerDie(country),messageToDefender(neighbour, country));
                            JOptionPane.showMessageDialog(view,country.getName() + " Lost " +zz[0] + "Troops \r\n" + neighbour.getName() + " Lost " + zz[1] + " Troops \r\n");
                            if(zz[2] == 1){
                                JOptionPane.showMessageDialog(view,this.getName() + " took control of " + neighbour.getName());
                            }
                            if(zz[3] == 1){
                                JOptionPane.showMessageDialog(view,neighbour.getPlayerOnCountry().getName() + " has been eliminated");
                            }
                            view.updateMap();
                            if(model.checkEnd()){
                                JOptionPane.showMessageDialog(view,this.getName() + " has won the game!");
                                System.exit(0);
                            }
                            view.updateMap();
                        }
                    }
                }
            }
        }
    }
}
