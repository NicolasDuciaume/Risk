package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;
    /**
     * The constructor with two parameters for the GameController class
     * @param model the moddel class
     * @param view the view class
     */
    private Reinforcements reinforcements;
    private MovementView movementView;
    private AttackView attack;

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
            if(model.DoesHeOwn("Alaska")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view,"Alaska"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Alberta")){
            if(model.DoesHeOwn("Alberta")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Alberta"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("CA")){
            if(model.DoesHeOwn("Central America")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Central America"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EUS")){
            if(model.DoesHeOwn("Eastern United States")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Eastern United States"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Greenland")){
            if(model.DoesHeOwn("Greenland")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Greenland"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NT")){
            if(model.DoesHeOwn("Northwest Territory")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Northwest Territory"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ontario")){
            if(model.DoesHeOwn("Ontario")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ontario"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Quebec")){
            if(model.DoesHeOwn("Quebec")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Quebec"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WUS")){
            if(model.DoesHeOwn("Western United States")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Western United States"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Argentina")){
            if(model.DoesHeOwn("Argentina")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Argentina"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Brazil")){
            if(model.DoesHeOwn("Brazil")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Brazil"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Venezuela")){
            if(model.DoesHeOwn("Venezuela")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Venezuela"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Peru")){
            if(model.DoesHeOwn("Peru")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Peru"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("GB")){
            if(model.DoesHeOwn("Great Britain")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Great Britain"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Iceland")){
            if(model.DoesHeOwn("Iceland")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Iceland"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NE")){
            if(model.DoesHeOwn("Northern Europe")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Northern Europe"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Scandinavia")){
            if(model.DoesHeOwn("Scandinavia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Scandinavia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Congo")){
            if(model.DoesHeOwn("Congo")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Congo"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("SE")){
            if(model.DoesHeOwn("Southern Europe")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Southern Europe"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ukraine")){
            if(model.DoesHeOwn("Ukraine")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ukraine"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WE")){
            if(model.DoesHeOwn("Western Europe")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Western Europe"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ukraine")){
            if(model.DoesHeOwn("Ukraine")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ukraine"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EA")){
            if(model.DoesHeOwn("East Africa")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "East Africa"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Egypt")){
            if(model.DoesHeOwn("Egypt")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Egypt"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Madagascar")){
            if(model.DoesHeOwn("Madagascar")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Madagascar"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NA")){
            if(model.DoesHeOwn("North Africa")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "North Africa"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("SA")){
            if(model.DoesHeOwn("South Africa")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "South Africa"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Afghanistan")){
            if(model.DoesHeOwn("Afghanistan")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Afghanistan"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("China")){
            if(model.DoesHeOwn("China")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "China"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("India")){
            if(model.DoesHeOwn("India")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "India"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Irkutsk")){
            if(model.DoesHeOwn("Irkutsk")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Irkutsk"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Japan")){
            if(model.DoesHeOwn("Japan")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Japan"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Kamchatka")){
            if(model.DoesHeOwn("Kamchatka")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Kamchatka"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("ME")){
            if(model.DoesHeOwn("Middle East")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Middle East"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Mongolia")){
            if(model.DoesHeOwn("Mongolia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Mongolia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Siam")){
            if(model.DoesHeOwn("Siam")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Siam"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Siberia")){
            if(model.DoesHeOwn("Siberia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Siberia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ural")){
            if(model.DoesHeOwn("Ural")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Ural"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Yakutsk")){
            if(model.DoesHeOwn("Yakutsk")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Yakutsk"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EAUS")){
            if(model.DoesHeOwn("Eastern Australia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Eastern Australia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Indonesia")){
            if(model.DoesHeOwn("Indonesia")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "Indonesia"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NG")){
            if(model.DoesHeOwn("New Guinea")){
                attack = new AttackView(this.view);
                attack.addActionListeners(new AttackController(attack,model,view, "New Guinea"));
                attack.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WAUS")){
            if(model.DoesHeOwn("Western Australia")){
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