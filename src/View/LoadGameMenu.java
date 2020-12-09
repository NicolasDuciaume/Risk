/*
Author: Christopher D'silva
Comments: Nicolas Duciaume
 */

package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;


public class LoadGameMenu extends JDialog {

    private JPanel loadGameMenu;
    private JLabel loadGameMenuLabel;
    private JButton[] numOfSavedGames;

    /**
     * The default constructor for the LoadGameMenu class
     *
     * @param main - the main view of the game
     */
    public LoadGameMenu(RiskView main) throws IOException {
        super(main);
        setTitle("Load Game Menu");
        setSize(300, 300);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JPanel border = new JPanel(new BorderLayout());
        border.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel borderLayout = new JPanel(new GridBagLayout());
        borderLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        loadGameMenu = new JPanel();
        loadGameMenu.setLayout(new GridLayout(10, 1, 10, 6));

        loadGameMenuLabel = new JLabel("Select the game you would like to load:");

        numOfSavedGames = new JButton[5];

        File f = new File(System.getProperty("user.dir"));
        FilenameFilter filterFiles = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase(Locale.ROOT).endsWith(".txt");
            }
        };
        File[] files = f.listFiles(filterFiles);
        int i = 0;
        for (File file : files) {
            if (i < numOfSavedGames.length) {
                numOfSavedGames[i] = new JButton("Risk Load " + (i + 1));
                i++;
            }
        }

        loadGameMenu.add(loadGameMenuLabel);
        for (int j = 0; j < numOfSavedGames.length; j++) {
            if (numOfSavedGames[j] == null) {
                numOfSavedGames[j] = new JButton("---EMPTY---");
            }
        }
        for (int j = 0; j < numOfSavedGames.length; j++) {
            numOfSavedGames[j].setActionCommand("Load " + (j + 1));
            loadGameMenu.add(numOfSavedGames[j]);
        }

        borderLayout.add(loadGameMenu);
        border.add(borderLayout, BorderLayout.CENTER);

        add(border);

        setLocationRelativeTo(null);
    }

    /**
     * The acitonListener for the class
     *
     * @param listener the action listener
     */
    public void addActionListeners(ActionListener listener) {
        for (int i = 0; i < numOfSavedGames.length; i++) {
            numOfSavedGames[i].addActionListener(listener);
        }
    }

}

