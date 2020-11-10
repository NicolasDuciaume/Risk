package Controller;

import Model.*;
import View.*;
import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;
    private Reinforcements reinforcements;
    private AttackView attack;


    private SelectPlayerMenu selectPlayerMenu;

    public GameController(RiskModel model,GameView view){
        this.model = model;
        this.view = view;

        reinforcements = new Reinforcements(this.view);
        reinforcements.addActionListeners(new ReinforcementsController(reinforcements,model,view));
        reinforcements.setVisible(true);


        view.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Player play = model.getCurrentPlayer();

        if(e.getActionCommand().equals("EndTurn")){

            model.endTurn();
            view.UpdateTurn(model.getCurrentPlayerName());
            reinforcements = new Reinforcements(this.view);
            reinforcements.addActionListeners(new ReinforcementsController(reinforcements,model,view));
            reinforcements.setVisible(true);

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
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EUS")){
            if(model.DoesHeOwn("Eastern United States")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Greenland")){
            if(model.DoesHeOwn("Greenland")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NT")){
            if(model.DoesHeOwn("Northwest Territory")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ontario")){
            if(model.DoesHeOwn("Ontario")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Quebec")){
            if(model.DoesHeOwn("Quebec")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WUS")){
            if(model.DoesHeOwn("Western United States")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Argentina")){
            if(model.DoesHeOwn("Argentina")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Brazil")){
            if(model.DoesHeOwn("Brazil")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Venezuela")){
            if(model.DoesHeOwn("Venezuela")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Peru")){
            if(model.DoesHeOwn("Peru")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("GB")){
            if(model.DoesHeOwn("Great Britain")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Iceland")){
            if(model.DoesHeOwn("Iceland")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NE")){
            if(model.DoesHeOwn("Northern Europe")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Scandinavia")){
            if(model.DoesHeOwn("Scandinavia")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Congo")){
            if(model.DoesHeOwn("Congo")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("SE")){
            if(model.DoesHeOwn("Southern Europe")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ukraine")){
            if(model.DoesHeOwn("Ukraine")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WE")){
            if(model.DoesHeOwn("Western Europe")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ukraine")){
            if(model.DoesHeOwn("Ukraine")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EA")){
            if(model.DoesHeOwn("East Africa")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Egypt")){
            if(model.DoesHeOwn("Egypt")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Madagascar")){
            if(model.DoesHeOwn("Madagascar")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NA")){
            if(model.DoesHeOwn("North Africa")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("SA")){
            if(model.DoesHeOwn("South Africa")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Afghanistan")){
            if(model.DoesHeOwn("Afghanistan")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("China")){
            if(model.DoesHeOwn("China")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("India")){
            if(model.DoesHeOwn("India")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Irkutsk")){
            if(model.DoesHeOwn("Irkutsk")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Japan")){
            if(model.DoesHeOwn("Japan")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Kamchatka")){
            if(model.DoesHeOwn("Kamchatka")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("ME")){
            if(model.DoesHeOwn("Middle East")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Mongolia")){
            if(model.DoesHeOwn("Mongolia")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Siam")){
            if(model.DoesHeOwn("Siam")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Siberia")){
            if(model.DoesHeOwn("Siberia")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Ural")){
            if(model.DoesHeOwn("Ural")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Yakutsk")){
            if(model.DoesHeOwn("Yakutsk")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("EAUS")){
            if(model.DoesHeOwn("Eastern Australia")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("Indonesia")){
            if(model.DoesHeOwn("Indonesia")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("NG")){
            if(model.DoesHeOwn("New Guinea")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }
        else if(e.getActionCommand().equals("WAUS")){
            if(model.DoesHeOwn("Western Australia")){
                JOptionPane.showMessageDialog(view,"Test");
            }
            else{
                JOptionPane.showMessageDialog(view,"You do not own this country!");
            }
        }



    }


}