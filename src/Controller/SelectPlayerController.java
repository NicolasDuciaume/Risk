/*
Author: Kamran Sagheir & Hussain Al-Baidhani
comments: Hussain Al-Baidhani
 */
package Controller;

import Model.*;
import View.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
* The controller class for the player selection
*/
public class SelectPlayerController implements ActionListener {

    private SelectPlayerMenu selectPlayerMenu;
    private RiskModel model;
    private RiskView view;
    private String customMap;


    /**
     * The constructor with three parameters
     *
     * @param selectPlayerMenu the player menu
     * @param model            the game model
     * @param view             the game view
     * @param customMap             the string of file holding the map being used
     */
    public SelectPlayerController(SelectPlayerMenu selectPlayerMenu, RiskModel model, RiskView view, String customMap) {
        this.selectPlayerMenu = selectPlayerMenu;
        this.model = model;
        this.view = view;
        this.customMap = customMap;
    }

    public int setAis(int num) {
        JComboBox temp = new JComboBox();
        JPanel p = new JPanel();
        JLabel label = new JLabel("Select the amount of Ai players you want:");
        p.add(label);
        for (int x = 0; x < num; x++) {
            temp.addItem(x);
        }
        p.add(temp);
        JOptionPane.showMessageDialog(null, p, "AI Selection", JOptionPane.QUESTION_MESSAGE);
        int t = (int) temp.getSelectedItem();
        return t;
    }

    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionEvent = e.getActionCommand();

        if (actionEvent.equals("twoPlayersSelected")) {
            System.out.println("2 Players Selected");
            model.playerSelection("2", setAis(2));
        } else if (actionEvent.equals("threePlayersSelected")) {
            System.out.println("3 Players Selected");
            model.playerSelection("3", setAis(3));
        } else if (actionEvent.equals("fourPlayersSelected")) {
            System.out.println("4 Players Selected");
            model.playerSelection("4", setAis(4));
        } else if (actionEvent.equals("fivePlayersSelected")) {
            System.out.println("5 Players Selected");
            model.playerSelection("5", setAis(5));
        } else if (actionEvent.equals("sixPlayersSelected")) {
            System.out.println("6 Players Selected");
            model.playerSelection("6", setAis(6));
        } else if (actionEvent.equals("backButtonSelected")) {
            selectPlayerMenu.dispose();
        }

        selectPlayerMenu.setVisible(false);
        view.dispose();
        if (!customMap.equals("")) {
            try {
                model.setCustom(customMap);
                new GameView(model, customMap, false);
            } catch (IOException | ParserConfigurationException | SAXException ioException) {
                ioException.printStackTrace();
            }
        } else {
            try {
                new GameView(model, model.getCustom(), false);
            } catch (IOException | ParserConfigurationException | SAXException ioException) {
                ioException.printStackTrace();
            }
        }


    }
}
