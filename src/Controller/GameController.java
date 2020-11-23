/*
Author: Nicolas Duciaume
Refactoring: Kamran Sagheir
Comments: Hussain Al-Baidhani
 */

package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;
    private Reinforcements reinforcements;
    private MovementView movementView;
    private AttackView attack;

    /**
     * The constructor with two parameters for the GameController class
     * @param model the moddel class
     * @param view the view class
     */
    public GameController(RiskModel model,GameView view){
        this.model = model;
        this.view = view;

        reinforcements = new Reinforcements(this.view);
        reinforcements.addActionListeners(new ReinforcementsController(reinforcements,model,view));
        reinforcements.setVisible(true);

        view.addActionListener(this);
    }


    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("EndTurn")){
            movementView = new MovementView(this.view);
            movementView.addActionListeners(new MovementController(movementView,model,view));
            movementView.setVisible(true);


        }else if(e.getActionCommand().equals("Alaska")){
            if(model.isOwned("Alaska")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view,"Alaska"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Alberta")){
            if(model.isOwned("Alberta")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Alberta"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("CA")){
            if(model.isOwned("Central America")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Central America"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EUS")){
            if(model.isOwned("Eastern United States")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Eastern United States"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Greenland")){
            if(model.isOwned("Greenland")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Greenland"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NT")){
            if(model.isOwned("Northwest Territory")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Northwest Territory"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ontario")){
            if(model.isOwned("Ontario")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ontario"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Quebec")){
            if(model.isOwned("Quebec")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Quebec"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WUS")){
            if(model.isOwned("Western United States")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Western United States"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Argentina")){
            if(model.isOwned("Argentina")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Argentina"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Brazil")){
            if(model.isOwned("Brazil")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Brazil"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Venezuela")){
            if(model.isOwned("Venezuela")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Venezuela"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Peru")){
            if(model.isOwned("Peru")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Peru"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("GB")){
            if(model.isOwned("Great Britain")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Great Britain"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Iceland")){
            if(model.isOwned("Iceland")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Iceland"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NE")){
            if(model.isOwned("Northern Europe")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Northern Europe"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Scandinavia")){
            if(model.isOwned("Scandinavia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Scandinavia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Congo")){
            if(model.isOwned("Congo")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Congo"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("SE")){
            if(model.isOwned("Southern Europe")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Southern Europe"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ukraine")){
            if(model.isOwned("Ukraine")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ukraine"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WE")){
            if(model.isOwned("Western Europe")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Western Europe"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ukraine")){
            if(model.isOwned("Ukraine")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ukraine"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EA")){
            if(model.isOwned("East Africa")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "East Africa"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Egypt")){
            if(model.isOwned("Egypt")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Egypt"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Madagascar")){
            if(model.isOwned("Madagascar")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Madagascar"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NA")){
            if(model.isOwned("North Africa")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "North Africa"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("SA")){
            if(model.isOwned("South Africa")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "South Africa"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Afghanistan")){
            if(model.isOwned("Afghanistan")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Afghanistan"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("China")){
            if(model.isOwned("China")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "China"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("India")){
            if(model.isOwned("India")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "India"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Irkutsk")){
            if(model.isOwned("Irkutsk")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Irkutsk"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Japan")){
            if(model.isOwned("Japan")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Japan"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Kamchatka")){
            if(model.isOwned("Kamchatka")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Kamchatka"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("ME")){
            if(model.isOwned("Middle East")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Middle East"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Mongolia")){
            if(model.isOwned("Mongolia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Mongolia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Siam")){
            if(model.isOwned("Siam")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Siam"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Siberia")){
            if(model.isOwned("Siberia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Siberia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ural")){
            if(model.isOwned("Ural")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ural"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Yakutsk")){
            if(model.isOwned("Yakutsk")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Yakutsk"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EAUS")){
            if(model.isOwned("Eastern Australia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Eastern Australia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Indonesia")){
            if(model.isOwned("Indonesia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Indonesia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NG")){
            if(model.isOwned("New Guinea")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "New Guinea"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WAUS")){
            if(model.isOwned("Western Australia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Western Australia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }



    }


}