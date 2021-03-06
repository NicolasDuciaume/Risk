/*
Author: Christopher D'silva
Refactoring:
Comments:
 */
package Controller;

import Model.RiskModel;
import View.GameView;
import View.LoadGameMenu;
import View.RiskView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
* THe class responsible for game loading controller
*/
public class LoadGameController implements ActionListener {

    private LoadGameMenu loadGameMenu;
    private RiskModel model;
    private RiskView view;

    /**
     * The constructor with two parameters for the GameController class
     *
     * @param loadGameMenu the view class of the loading game menu
     * @param model        the moddel class
     * @param view         the view class
     */
    public LoadGameController(LoadGameMenu loadGameMenu, RiskModel model, RiskView view) {
        this.loadGameMenu = loadGameMenu;
        this.model = model;
        this.view = view;
    }

    /**
     * The action listener for the class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Load 1")) {
            RiskModel newModel = RiskModel.load("Risk 1.txt");
            this.model = newModel;
        }
        if (e.getActionCommand().equals("Load 2")) {
            RiskModel newModel = RiskModel.load("Risk 2.txt");
            this.model = newModel;
        }
        if (e.getActionCommand().equals("Load 3")) {
            RiskModel newModel = RiskModel.load("Risk 3.txt");
            this.model = newModel;
        }
        if (e.getActionCommand().equals("Load 4")) {
            RiskModel newModel = RiskModel.load("Risk 4.txt");
            this.model = newModel;
        }
        if (e.getActionCommand().equals("Load 5")) {
            RiskModel newModel = RiskModel.load("Risk 5.txt");
            this.model = newModel;
        }
        loadGameMenu.setVisible(false);
        view.dispose();
        try {
            new GameView(model, model.getCustom(), true);
        } catch (IOException | ParserConfigurationException | SAXException ioException) {
            ioException.printStackTrace();
        }
    }
}
