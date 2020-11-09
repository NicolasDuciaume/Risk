package View;
import Controller.GameController;
import Model.Country;
import Model.RiskModel;
import View.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameView extends JFrame {

    private JPanel Game;
    private ImageIcon map;
    private JLabel mapLabel;
    private JScrollPane mapScrollPane;
    private JLabel command;

    //North America
    private JButton NT;
    private JButton Alberta;
    private JButton Alaska;
    private JButton Ontario;
    private JButton Quebec;
    private JButton Greenland;
    private JButton WUS;
    private JButton EUS;
    private JButton CA;

    //South America
    private JButton Brazil;
    private JButton Venezuela;
    private JButton Argentina;
    private JButton Peru;

    //Europe
    private JButton Iceland;
    private JButton GB;
    private JButton Scandinavia;
    private JButton NE;
    private JButton WE;
    private JButton SE;
    private JButton Ukraine;

    //Africa
    private JButton NA;
    private JButton SA;
    private JButton Egypt;
    private JButton Congo;
    private JButton EA;
    private JButton Madagascar;

    //Asia
    private JButton Ural;
    private JButton Siberia;
    private JButton Afghanistan;
    private JButton ME;
    private JButton India;
    private JButton China;
    private JButton Siam;
    private JButton Mongolia;
    private JButton Irkutsk;
    private JButton Yakutsk;
    private JButton Kamchatka;
    private JButton Japan;

    //Australia
    private JButton Indonesia;
    private JButton NG;
    private JButton WAUS;
    private JButton EAUS;

    private JButton endTurn;

    private RiskModel model;
    private ArrayList<JButton> completeGameMap;

    public GameView(RiskModel model){
        super("Risk");
        this.model = model;
        GameController controller2 = new GameController(model, this);
        completeGameMap = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(game());

        setLocationRelativeTo(null);
        //setPreferredSize(new Dimension(500,600));
        setVisible(true);

        pack();
    }

    private JPanel game(){
        Game = new JPanel();
        Game.setLayout(new GridLayout(1, 1, 5, 5));
        map = new ImageIcon("/Risk/src/View/Map.jpg");
        mapLabel = new JLabel(map);
        mapLabel.setLayout(null);
        command = new JLabel("Press your owned country to select command", JLabel.CENTER);
        command.setFont(new Font("Serif",Font.BOLD,20));
        endTurn = new JButton("End Turn");

        //North America
        NT = new JButton("");
        Alberta = new JButton("");
        Alaska = new JButton("");
        Ontario = new JButton("");
        Quebec = new JButton("");
        Greenland = new JButton("");
        WUS = new JButton("");
        EUS = new JButton("");
        CA = new JButton("");

        setButtons(NT,130,139,91,61);
        setButtons(Alberta,111,212,117,75);
        setButtons(Alaska,31,71,83,72);
        setButtons(Ontario,235,122,62,189);
        setButtons(Quebec,305,190,111,133);
        setButtons(Greenland,405,37,117,193);
        setButtons(WUS,71,296,154,127);
        setButtons(EUS,239,326,153,154);
        setButtons(CA,111,464,249,134);


        NT.setActionCommand("NT");
        Alberta.setActionCommand("Alberta");
        Alaska.setActionCommand("Alaska");
        Ontario.setActionCommand("Ontario");
        Quebec.setActionCommand("Quebec");
        Greenland.setActionCommand("Greenland");
        WUS.setActionCommand("WUS");
        EUS.setActionCommand("EUS");
        CA.setActionCommand("CA");

        //South America
        Venezuela = new JButton("");
        Brazil = new JButton("");
        Argentina = new JButton("");
        Peru = new JButton("");

        setButtons(Venezuela,343,580,104,54);
        setButtons(Brazil,477,639,135,112);
        setButtons(Peru,338,696,144,58);
        setButtons(Argentina,419,757,89,168);

        Venezuela.setActionCommand("Venezuela");
        Brazil.setActionCommand("Brazil");
        Argentina.setActionCommand("Argentina");
        Peru.setActionCommand("Peru");

        //Europe
        Iceland = new JButton("");
        GB = new JButton("");
        Scandinavia = new JButton("");
        Ukraine = new JButton("");
        NE = new JButton("");
        WE = new JButton("");
        SE = new JButton("");

        setButtons(Iceland,628,149,80,66);
        setButtons(GB,704,209,72,82);
        setButtons(WE,701,301,93,89);
        setButtons(SE,808,313,74,68);
        setButtons(NE,796,254,76,58);
        setButtons(Scandinavia,773,128,124,100);
        setButtons(Ukraine,888,204,86,168);

        Iceland.setActionCommand("Iceland");
        Iceland.setActionCommand("GB");
        Iceland.setActionCommand("Scandinavia");
        Iceland.setActionCommand("Ukraine");
        Iceland.setActionCommand("NE");
        Iceland.setActionCommand("WE");
        Iceland.setActionCommand("SE");

        //Africa
        NA = new JButton("");
        SA = new JButton("");
        Egypt = new JButton("");
        Congo = new JButton("");
        EA = new JButton("");
        Madagascar = new JButton("");

        setButtons(NA,665,408,154,161);
        setButtons(SA,825,680,125,110);
        setButtons(Congo,814,568,101,105);
        setButtons(Egypt,857,444,100,119);
        setButtons(EA,926,596,57,91);
        setButtons(Madagascar,996,655,54,99);

        NA.setActionCommand("NA");
        SA.setActionCommand("SA");
        Egypt.setActionCommand("Egypt");
        Congo.setActionCommand("Congo");
        EA.setActionCommand("EA");
        Madagascar.setActionCommand("Madagascar");

        //Asia
        Ural = new JButton("");
        Afghanistan = new JButton("");
        ME = new JButton("");
        India = new JButton("");
        China = new JButton("");
        Siam = new JButton("");
        Siberia = new JButton("");
        Yakutsk = new JButton("");
        Irkutsk = new JButton("");
        Kamchatka = new JButton("");
        Mongolia = new JButton("");
        Japan = new JButton("");

        setButtons(Ural,1040,60,90,198);
        setButtons(Afghanistan,994,260,128,102);
        setButtons(Siberia,1140,36,93,252);
        setButtons(ME,951,390,114,101);
        setButtons(India,1068,409,124,126);
        setButtons(China,1148,330,151,86);
        setButtons(Siam,1221,416,68,99);
        setButtons(Mongolia,1238,272,129,70);
        setButtons(Irkutsk,1256,160,87,85);
        setButtons(Yakutsk,1259,42,94,92);
        setButtons(Kamchatka,1375,10,127,266);
        setButtons(Japan,1396,276,41,104);

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


        //Australia
        Indonesia = new JButton("");
        NG = new JButton("");
        WAUS = new JButton("");
        EAUS = new JButton("");

        setButtons(Indonesia,1231,541,151,86);
        setButtons(NG,1411,549,128,73);
        setButtons(WAUS,1312,638,115,140);
        setButtons(EAUS,1438,631,76,165);

        Indonesia.setActionCommand("Indonesia");
        NG.setActionCommand("NG");
        WAUS.setActionCommand("WAUS");
        EAUS.setActionCommand("EAUS");


        endTurn.setBounds(1077,855,131,58);
        mapLabel.add(endTurn);

        initialMap();
        UpdateMap();

        command.setBounds(520,19,419,59);
        mapLabel.add(command);

        mapScrollPane = new JScrollPane(mapLabel);
        mapScrollPane.setPreferredSize(new Dimension(1610, 960));

        Game.add(mapScrollPane);


        return Game;
    }

    private void setButtons(JButton b,int x, int y, int w, int h){
        b.setBounds(x,y,w,h);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        mapLabel.add(b);
    }

    private void initialMap(){
        completeGameMap.add(Alaska);
        completeGameMap.add(Alberta);
        completeGameMap.add(CA);
        completeGameMap.add(EUS);
        completeGameMap.add(Greenland);
        completeGameMap.add(NT);
        completeGameMap.add(Ontario);
        completeGameMap.add(Quebec);
        completeGameMap.add(WUS);
        completeGameMap.add(Argentina);
        completeGameMap.add(Brazil);
        completeGameMap.add(Peru);
        completeGameMap.add(Venezuela);
        completeGameMap.add(GB);
        completeGameMap.add(Iceland);
        completeGameMap.add(NE);
        completeGameMap.add(Scandinavia);
        completeGameMap.add(SE);
        completeGameMap.add(Ukraine);
        completeGameMap.add(WE);
        completeGameMap.add(Congo);
        completeGameMap.add(EA);
        completeGameMap.add(Egypt);
        completeGameMap.add(Madagascar);
        completeGameMap.add(NA);
        completeGameMap.add(SA);
        completeGameMap.add(Afghanistan);
        completeGameMap.add(China);
        completeGameMap.add(India);
        completeGameMap.add(Irkutsk);
        completeGameMap.add(Japan);
        completeGameMap.add(Kamchatka);
        completeGameMap.add(ME);
        completeGameMap.add(Mongolia);
        completeGameMap.add(Siam);
        completeGameMap.add(Siberia);
        completeGameMap.add(Ural);
        completeGameMap.add(Yakutsk);
        completeGameMap.add(EAUS);
        completeGameMap.add(Indonesia);
        completeGameMap.add(NG);
        completeGameMap.add(WAUS);
    }

    private void UpdateMap(){
        ArrayList<Country> full = model.getFullMap();
        for(int x = 0; x < full.size(); x++){
            Country temp = full.get(x);
            JButton tempC = completeGameMap.get(x);

            tempC.setText("" + temp.getArmiesOnCountry());

            tempC.setFont(new Font("Serif",Font.BOLD,20));

            if(temp.getPlayerOnCountry().getName().equals("Player 1")){
                tempC.setForeground(Color.RED);
            }
            else if(temp.getPlayerOnCountry().getName().equals("Player 2")){
                tempC.setForeground(Color.BLUE);
            }
        }

    }


    public void addActionListener(GameController gameController) {

    }
}