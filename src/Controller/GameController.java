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
import java.util.ArrayList;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

import javax.swing.JOptionPane;

/**
* The class responsible for the game control
*/
public class GameController implements ActionListener {

    private RiskModel model;
    private GameView view;
    private Reinforcements reinforcements;
    private MovementView movementView;
    private AttackView attack;
    private ArrayList<String> countries;

    /**
     * The constructor with two parameters for the GameController class
     *
     * @param model the moddel class
     * @param view  the view class
     */
    public GameController(RiskModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.countries = view.getCountries();

        //checks to see if the player has already reinforced in the case you load a save
        if (!model.getCurrentPlayer().getReinforced()) {
            reinforcements = new Reinforcements(this.view);
            reinforcements.addActionListeners(new ReinforcementsController(reinforcements, model, view));
            reinforcements.setVisible(true);
        }
        view.addActionListener(this);
    }

    /**
     * Gets the number of saved files in the working directory
     * @return file number
     */
    private int getFileNumber() {
        File f = new File(System.getProperty("user.dir"));
        FilenameFilter filterFiles = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase(Locale.ROOT).endsWith(".txt");
            }
        };
        File[] files = f.listFiles(filterFiles);

        return files.length + 1;
    }

    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("EndTurn")) {
            movementView = new MovementView(this.view);
            movementView.addActionListeners(new MovementController(movementView, model, view));
            movementView.setVisible(true);

        } else if (e.getActionCommand().equals("SaveGame")) {
            //Model serialization
            int decision = JOptionPane.showConfirmDialog(view, "Are you sure you would like to save this game?", "Save Game", JOptionPane.YES_NO_OPTION);
            if (decision == JOptionPane.YES_OPTION) {
                String filename = "Risk " + getFileNumber() + ".txt";
                model.save(filename);
                JOptionPane.showMessageDialog(view, "File saved in working directory with file name " + filename);
                int continueDialog = JOptionPane.showConfirmDialog(view, "Would you like to continue playing?", "Continue", JOptionPane.YES_NO_OPTION);
                if (continueDialog == JOptionPane.NO_OPTION) {
                    view.dispose();
                    new RiskController(new RiskModel(), new RiskView());
                }
            }
        } else {
            for (int i = 0; i < countries.size(); i++) {
                if (e.getActionCommand().equals(countries.get(i))) {
                    if (model.isOwned(countries.get(i))) {
                        attack = new AttackView(this.view);
                        attack.addActionListeners(new AttackController(attack, model, view, countries.get(i)));
                        attack.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(view, "You do not own this country!");
                    }
                }
            }
        }
    }


}
