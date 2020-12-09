/*
Author: Nicolas Duciaume
 */
package View;

import Controller.GameController;
import Model.Country;
import Model.Map;
import Model.RiskModel;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

@SuppressWarnings("serial")
public class GameView extends JFrame {


	private JPanel Game;
	private ImageIcon map;
	private JLabel mapLabel;
	private JScrollPane mapScrollPane;
	private JLabel command;
	private JLabel play;
	private Map mapping;
	private JButton saveGame;
	private boolean saved;

	private ArrayList<String> countries;

	private JButton endTurn;

	private RiskModel model;
	private ArrayList<JButton> completeGameMap;
	private String t;

	/**
	 * The default constructor for the GameView class
	 * @param model - the model of the game
	 * @param t - the directory of the map file
	 * @param saved - boolean value of if the game is loading from a saved game
	 */
	public GameView(RiskModel model, String t, boolean saved) throws IOException, ParserConfigurationException, SAXException {
		super("Risk");
		this.model = model;
		this.t = t;
		this.saved = saved;
		System.out.println(t);
		mapping = model.getMap();

		countries = new ArrayList<>();

		completeGameMap = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(t.substring(t.length() - 4, t.length()).equals("json")){
			add(game());
		}
		else if(t.substring(t.length() - 3, t.length()).equals("xml")){
			add(gameXML());
		}
		else{
			JOptionPane.showMessageDialog(this,"WrongFile type");
			System.exit(0);
		}


		setLocationRelativeTo(null);
		// setPreferredSize(new Dimension(500,600));
		setVisible(true);

		new GameController(model, this);

		pack();
	}

	/**
	 * The method responsible for setting up the GUI for the game if the map is in json format
	 *
	 * @return JPanel for the the GUI
	 */
	private JPanel game() throws IOException {
		Game = new JPanel();
		Game.setLayout(new GridLayout(1, 1, 5, 5));
		//File file = new File(t);
		String content = "";
		try{
			File file = new File(t);
			content = FileUtils.readFileToString(file, "utf-8");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,"File Does not exist");
			System.exit(0);
			e.printStackTrace();
		}
		JSONObject tomJsonObject = new JSONObject(content);
		String maploc = tomJsonObject.getString("File");
		map = new ImageIcon(maploc);
		mapLabel = new JLabel(map);
		mapLabel.setLayout(null);
		command = new JLabel("Press your owned country to select command", JLabel.CENTER);
		command.setFont(new Font("Serif", Font.BOLD, 20));
		play = new JLabel("Player 1", JLabel.CENTER);
		play.setFont(new Font("Serif", Font.BOLD, 20));
		JSONArray labelBounds = tomJsonObject.getJSONArray("PlayerLabel");
		int[] b = {0,0,0,0};
		for(int z = 0; z < labelBounds.length(); z++){
			b[z] = labelBounds.getInt(z);
		}
		play.setBounds(b[0], b[1], b[2], b[3]);
		play.setForeground(Color.RED);
		if(saved){
			updateTurn(model.getCurrentPlayerName());
		}
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
			if(!saved){
				mapping.addToMap(name,www);
			}
		}

		if(!saved){
			boolean x = mapping.SetNeighbors();
			if(x){
				JOptionPane.showMessageDialog(this,"Countries do not have Neighbors");
				System.exit(0);
			}
			model.setFullMap();
			model.populate();
		}

		if(tomJsonObject.has("Continents")){
			JSONArray ContinentsJson = tomJsonObject.getJSONArray("Continents");
			for(int i = 0; i < ContinentsJson.length(); i++){
				ArrayList<String> countriesInContinent = new ArrayList<>();
				JSONObject tempJson = ContinentsJson.getJSONObject(i);
				String name = tempJson.getString("Name");
				int bonus = tempJson.getInt("Bonus");
				JSONArray count = tempJson.getJSONArray("Countries");
				for (int x = 0; x < count.length(); x++) {
					countriesInContinent.add((String) count.get(x));
				}
				if(!saved){
					mapping.addContinents(name,countriesInContinent,bonus);
				}
			}
		}

		JSONArray endBounds = tomJsonObject.getJSONArray("EndButton");
		for(int z = 0; z < endBounds.length(); z++){
			b[z] = endBounds.getInt(z);
		}

		endTurn.setBounds(b[0], b[1], b[2], b[3]);

		JSONArray saveBounds = tomJsonObject.getJSONArray("SaveButton");
		for(int z = 0; z < saveBounds.length(); z++){
			b[z] = saveBounds.getInt(z);
		}

		saveGame = new JButton("Save Game");
		saveGame.setActionCommand("SaveGame");
		saveGame.setBounds(b[0], b[1], b[2], b[3]);
		mapLabel.add(saveGame);
		mapLabel.add(endTurn);
		mapLabel.add(play);


		updateMap();



		command.setBounds(520, 19, 419, 59);
		mapLabel.add(command);

		//mapScrollPane = new JScrollPane(mapLabel);
		//mapScrollPane.setPreferredSize(new Dimension(1610, 960));

		Game.add(mapLabel);

		if(!saved){
			model.play();
		}

		return Game;
	}

	/**
	 * The method responsible for setting up the GUI for the game if the map is in xml format
	 *
	 * @return JPanel for the the GUI
	 */
	private JPanel gameXML() throws IOException, ParserConfigurationException, SAXException {
		Game = new JPanel();
		Game.setLayout(new GridLayout(1, 1, 5, 5));
		try{
			File file = new File(t);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"File Does not exist");
			System.exit(0);
			e.printStackTrace();
		}
		File file = new File(t);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();

		String maploc = doc.getElementsByTagName("File").item(0).getTextContent();
		map = new ImageIcon(maploc);
		mapLabel = new JLabel(map);
		mapLabel.setLayout(null);
		command = new JLabel("Press your owned country to select command", JLabel.CENTER);
		command.setFont(new Font("Serif", Font.BOLD, 20));
		play = new JLabel("Player 1", JLabel.CENTER);
		play.setFont(new Font("Serif", Font.BOLD, 20));
		String labelbounds = doc.getElementsByTagName("PlayerLabel").item(0).getTextContent();
		String[] strings = labelbounds.split("-");
		play.setBounds(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
		play.setForeground(Color.RED);
		if(saved){
			updateTurn(model.getCurrentPlayerName());
		}
		endTurn = new JButton("End Turn");
		endTurn.setActionCommand("EndTurn");

		NodeList nodeList = doc.getElementsByTagName("Buttons");
		for(int itr = 0; itr < nodeList.getLength(); itr++){
			Node node = nodeList.item(itr);
			ArrayList<String> www2 = new ArrayList<>();
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) node;
				String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
				String xloc = eElement.getElementsByTagName("XLoc").item(0).getTextContent();
				String yloc = eElement.getElementsByTagName("YLoc").item(0).getTextContent();
				String hloc = eElement.getElementsByTagName("HLoc").item(0).getTextContent();
				String wloc = eElement.getElementsByTagName("WLoc").item(0).getTextContent();
				String neighborsTemp = eElement.getElementsByTagName("Neighbors").item(0).getTextContent();

				JButton temp = new JButton("");
				setButtons(temp,Integer.parseInt(xloc),Integer.parseInt(yloc),Integer.parseInt(wloc),Integer.parseInt(hloc));
				temp.setActionCommand(name);
				countries.add(name);
				completeGameMap.add(temp);
				if(neighborsTemp.equals("")){
					JOptionPane.showMessageDialog(this,"Countries do not have Neighbors");
					System.exit(0);
				}
				else{
					String[] neighborsArray = neighborsTemp.split("-");
					for(String s: neighborsArray){
						www2.add(s);
					}
				}
				if(!saved){
					mapping.addToMap(name,www2);
				}

			}
		}

		if(!saved){
			boolean x = mapping.SetNeighbors();
			if(x){
				JOptionPane.showMessageDialog(this,"A Country does not have Neighbors");
				System.exit(0);
			}
			model.setFullMap();
			model.populate();
		}



		NodeList nodeList2 = doc.getElementsByTagName("Continents");
		for(int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList2.item(itr);
			ArrayList<String> countriesInContinent = new ArrayList<>();
			if(node != null){
				if (node.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) node;
					String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
					String bonus = eElement.getElementsByTagName("Bonus").item(0).getTextContent();
					String CountriesInCont = eElement.getElementsByTagName("Name").item(0).getTextContent();
					String[] C = CountriesInCont.split("-");
					for (String s: C){
						countriesInContinent.add(s);
					}
					if(!saved){
						mapping.addContinents(name,countriesInContinent,Integer.parseInt(bonus));
					}
				}
			}
		}


		String endbounds = doc.getElementsByTagName("EndButton").item(0).getTextContent();
		String[] endButton = endbounds.split("-");

		endTurn.setBounds(Integer.parseInt(endButton[0]), Integer.parseInt(endButton[1]), Integer.parseInt(endButton[2]), Integer.parseInt(endButton[3]));

		String savebounds = doc.getElementsByTagName("SaveButton").item(0).getTextContent();
		String[] saveButton = savebounds.split("-");

		saveGame = new JButton("Save Game");
		saveGame.setActionCommand("SaveGame");
		saveGame.setBounds(Integer.parseInt(saveButton[0]), Integer.parseInt(saveButton[1]), Integer.parseInt(saveButton[2]), Integer.parseInt(saveButton[3]));
		mapLabel.add(saveGame);
		mapLabel.add(endTurn);
		mapLabel.add(play);


		updateMap();



		command.setBounds(520, 19, 419, 59);
		mapLabel.add(command);

		//mapScrollPane = new JScrollPane(mapLabel);
		//mapScrollPane.setPreferredSize(new Dimension(1610, 960));

		Game.add(mapLabel);

		if(!saved){
			model.play();
		}

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

	/**
	 * The acitonListener for the class
	 *
	 * @param listener the action listener
	 */
	public void addActionListener(ActionListener listener) {
		for(int x = 0; x < completeGameMap.size(); x++){
			completeGameMap.get(x).addActionListener(listener);
		}
		saveGame.addActionListener(listener);
		endTurn.addActionListener(listener);

	}
}