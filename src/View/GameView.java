/*
Author: Nicolas Duciaume
 */
package View;

import Controller.GameController;
import Model.Country;
import Model.Map;
import Model.RiskModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class GameView extends JFrame {


	private JPanel Game;
	private ImageIcon map;
	private JLabel mapLabel;
	private JScrollPane mapScrollPane;
	private JLabel command;
	private JLabel play;
	private Map mapping;

	private ArrayList<String> countries;

	private JButton endTurn;

	private RiskModel model;
	private ArrayList<JButton> completeGameMap;
	private String t;

	public GameView(RiskModel model, String t) throws IOException {
		super("Risk");
		this.model = model;
		this.t = t;
		System.out.println(t);
		mapping = model.getMap();

		countries = new ArrayList<>();

		completeGameMap = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(game());

		setLocationRelativeTo(null);
		// setPreferredSize(new Dimension(500,600));
		setVisible(true);

		new GameController(model, this);

		pack();
	}

	/**
	 * The method responsible for setting up the GUI for the game
	 *
	 * @return JPanel for the the GUI
	 */
	private JPanel game() throws IOException {
		Game = new JPanel();
		Game.setLayout(new GridLayout(1, 1, 5, 5));
		File file = new File(t);
		String content = FileUtils.readFileToString(file, "utf-8");
		JSONObject tomJsonObject = new JSONObject(content);
		String maploc = tomJsonObject.getString("File");
		map = new ImageIcon(maploc);
		mapLabel = new JLabel(map);
		mapLabel.setLayout(null);
		command = new JLabel("Press your owned country to select command", JLabel.CENTER);
		command.setFont(new Font("Serif", Font.BOLD, 20));
		play = new JLabel("Player 1", JLabel.CENTER);
		play.setFont(new Font("Serif", Font.BOLD, 20));
		play.setBounds(556, 68, 241, 39);
		play.setForeground(Color.RED);
		endTurn = new JButton("End Turn");
		endTurn.setActionCommand("EndTurn");



		JSONArray ButtonsJson = tomJsonObject.getJSONArray("Buttons");

		for(int i = 0; i < ButtonsJson.length(); i++){
			ArrayList<String> www = new ArrayList<>();
			JSONObject tempJson = ButtonsJson.getJSONObject(i);
			String name = tempJson.getString("Name");
			int xloc = tempJson.getInt("XLoc");
			int yloc = tempJson.getInt("YLoc");
			int hloc = tempJson.getInt("HLoc");
			int wloc = tempJson.getInt("WLoc");

			JButton temp = new JButton("");
			setButtons(temp,xloc,yloc,wloc,hloc);
			temp.setActionCommand(name);
			countries.add(name);
			completeGameMap.add(temp);
			if (tempJson.isNull("Neighbors")) {
				JOptionPane.showMessageDialog(this,"Countries do not have Neighbors");
				System.exit(0);
			}
			else{
				JSONArray neighbors = tempJson.getJSONArray("Neighbors");
				for (int x = 0; x < neighbors.length(); x++) {
					www.add((String) neighbors.get(x));
				}
			}
			mapping.addToMap(name,www);
		}

		mapping.SetNeighbors();
		model.setFullMap();
		model.populate();

		endTurn.setBounds(1077, 855, 131, 58);
		mapLabel.add(endTurn);
		mapLabel.add(play);

		//initialMap();



		updateMap();

		/*
		NT.setActionCommand("NT");
		Alberta.setActionCommand("Alberta");
		Alaska.setActionCommand("Alaska");
		Ontario.setActionCommand("Ontario");
		Quebec.setActionCommand("Quebec");
		Greenland.setActionCommand("Greenland");
		WUS.setActionCommand("WUS");
		EUS.setActionCommand("EUS");
		CA.setActionCommand("CA");
		Venezuela.setActionCommand("Venezuela");
		Brazil.setActionCommand("Brazil");
		Argentina.setActionCommand("Argentina");
		Peru.setActionCommand("Peru");
		Iceland.setActionCommand("Iceland");
		GB.setActionCommand("GB");
		Scandinavia.setActionCommand("Scandinavia");
		Ukraine.setActionCommand("Ukraine");
		NE.setActionCommand("NE");
		WE.setActionCommand("WE");
		SE.setActionCommand("SE");
		NA.setActionCommand("NA");
		SA.setActionCommand("SA");
		Egypt.setActionCommand("Egypt");
		Congo.setActionCommand("Congo");
		EA.setActionCommand("EA");
		Madagascar.setActionCommand("Madagascar");
		Ural.setActionCommand("Ural");
		Afghanistan.setActionCommand("Afghanistan");
		ME.setActionCommand("ME");
		India.setActionCommand("India");
		China.setActionCommand("China");
		Siam.setActionCommand("Siam");
		Siberia.setActionCommand("Siberia");
		Yakutsk.setActionCommand("Yakutsk");
		Irkutsk.setActionCommand("Irkutsk");
		Kamchatka.setActionCommand("Kamchatka");
		Mongolia.setActionCommand("Mongolia");
		Japan.setActionCommand("Japan");
		Indonesia.setActionCommand("Indonesia");
		NG.setActionCommand("NG");
		WAUS.setActionCommand("WAUS");
		EAUS.setActionCommand("EAUS");*/

		command.setBounds(520, 19, 419, 59);
		mapLabel.add(command);

		//mapScrollPane = new JScrollPane(mapLabel);
		//mapScrollPane.setPreferredSize(new Dimension(1610, 960));

		Game.add(mapLabel);

		model.play();

		return Game;
	}

	/**
	 * The method responsible for setting up the game buttons
	 */
	private void setButtons(JButton b, int x, int y, int w, int h) {
		b.setBounds(x, y, w, h);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		mapLabel.add(b);
	}

	public ArrayList<String> getCountries(){
		return countries;
	}

	/**
	 * The method responsible for updating the map
	 */
	public void updateMap() {
		ArrayList<Country> full = model.getFullMap();
		for (int x = 0; x < full.size(); x++) {
			Country temp = full.get(x);
			JButton tempC = completeGameMap.get(x);

			tempC.setText("" + temp.getArmiesOnCountry());

			tempC.setFont(new Font("Serif", Font.BOLD, 20));

			if (temp.getPlayerOnCountry().getName().equals("Player 1")) {
				tempC.setForeground(Color.RED);
			} else if (temp.getPlayerOnCountry().getName().equals("Player 2")) {
				tempC.setForeground(Color.BLUE);
			} else if (temp.getPlayerOnCountry().getName().equals("Player 3")){
				tempC.setForeground(Color.ORANGE);
			} else if (temp.getPlayerOnCountry().getName().equals("Player 4"))  {
				tempC.setForeground(Color.PINK);
			} else if (temp.getPlayerOnCountry().getName().equals("Player 5"))  {
				tempC.setForeground(Color.GREEN);
			} else if (temp.getPlayerOnCountry().getName().equals("Player 6"))  {
				tempC.setForeground(Color.BLACK);
			} else if (temp.getPlayerOnCountry().getName().equals("Ai 1")) {
				tempC.setForeground(Color.MAGENTA);
			} else if (temp.getPlayerOnCountry().getName().equals("Ai 2")) {
				tempC.setForeground(Color.CYAN);
			} else if (temp.getPlayerOnCountry().getName().equals("Ai 3")) {
				tempC.setForeground(Color.YELLOW);
			} else if (temp.getPlayerOnCountry().getName().equals("Ai 4")) {
				tempC.setForeground(Color.GRAY);
			} else if (temp.getPlayerOnCountry().getName().equals("Ai 5")) {
				tempC.setForeground(Color.black);
			}
		}

	}

	/**
	 * The method responsible for updating the turn
	 *
	 * @param label the lable
	 */
	public void updateTurn(String label) {
		play.setText(label);
		if (play.getText().equals("Player 1")) {
			play.setForeground(Color.RED);
		} else if (play.getText().equals("Player 2")) {
			play.setForeground(Color.BLUE);
		} else if (play.getText().equals("Player 3")) {
			play.setForeground(Color.ORANGE);
		} else if (play.getText().equals("Player 4")) {
			play.setForeground(Color.PINK);
		} else if (play.getText().equals("Player 5")) {
			play.setForeground(Color.GREEN);
		} else if (play.getText().equals("Player 6")) {
			play.setForeground(Color.BLACK);
		}
	}

	public void addActionListener(ActionListener listener) {
		for(int x = 0; x < completeGameMap.size(); x++){
			completeGameMap.get(x).addActionListener(listener);
		}
		endTurn.addActionListener(listener);

	}
}