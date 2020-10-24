import java.util.ArrayList;

public class Map {

    private Country Alaska, Alberta, CA, EUS, Greenland, NT, Ontario, Quebec, WUS;
    private Country Argentina, Brazil, Peru, Venezuela;
    private Country GB, Iceland, NE, Scandinavia,SE, Ukraine, WE;
    private Country Congo, EA, Egypt, Madagascar, NA, SA;
    private Country Afghanistan, China, India, Irkutsk, Japan, Kamchatka, ME, Mongolia, Siam, Siberia, Ural, Yakutsk;
    private Country EAUS, Indonesia, NG, WAUS;

    private ArrayList<Country> FullMap;
    private int countriesOccupied = 0;

    public Map(){
        Alaska = new Country("Alaska");
        Alberta = new Country("Alberta");
        CA = new Country("Central America");
        EUS = new Country("Eastern United States");
        Greenland = new Country("Greenland");
        NT = new Country("Northwest Territory");
        Ontario = new Country("Ontario");
        Quebec = new Country("Quebec");
        WUS = new Country("Western United States");
        Argentina = new Country("Argentina");
        Brazil = new Country("Brazil");
        Peru = new Country("Peru");
        Venezuela = new Country("Venezuela");
        GB = new Country("Great Britain");
        Iceland = new Country("Iceland");
        NE = new Country("Northern Europe");
        Scandinavia = new Country("Scandinavia");
        SE = new Country("Southern Europe");
        Ukraine = new Country("Ukraine");
        WE = new Country("Western Europe");
        Congo = new Country("Congo");
        EA = new Country("East Africa");
        Egypt = new Country("Egypt");
        Madagascar = new Country("Madagascar");
        NA = new Country("North Africa");
        SA = new Country("South Africa");
        Afghanistan = new Country("Afghanistan");
        China = new Country("China");
        India = new Country("India");
        Irkutsk = new Country("Irkutsk");
        Japan = new Country("Japan");
        Kamchatka = new Country("Kamchatka");
        ME = new Country("Middle East");
        Mongolia = new Country("Mongolia");
        Siam = new Country("Siam");
        Siberia = new Country("Siberia");
        Ural = new Country("Ural");
        Yakutsk = new Country("Yakutsk");
        EAUS = new Country("Eastern Australia");
        Indonesia = new Country("Indonesia");
        NG = new Country("New Guinea");
        WAUS = new Country("Western Australia");

        FullMap = new ArrayList<Country>();

        FullMap.add(Alaska);
        FullMap.add(Alberta);
        FullMap.add(CA);
        FullMap.add(EUS);
        FullMap.add(Greenland);
        FullMap.add(NT);
        FullMap.add(Ontario);
        FullMap.add(Quebec);
        FullMap.add(WUS);
        FullMap.add(Argentina);
        FullMap.add(Brazil);
        FullMap.add(Peru);
        FullMap.add(Venezuela);
        FullMap.add(GB);
        FullMap.add(Iceland);
        FullMap.add(NE);
        FullMap.add(Scandinavia);
        FullMap.add(SE);
        FullMap.add(Ukraine);
        FullMap.add(WE);
        FullMap.add(Congo);
        FullMap.add(EA);
        FullMap.add(Egypt);
        FullMap.add(Madagascar);
        FullMap.add(NA);
        FullMap.add(SA);
        FullMap.add(Afghanistan);
        FullMap.add(China);
        FullMap.add(India);
        FullMap.add(Irkutsk);
        FullMap.add(Japan);
        FullMap.add(Kamchatka);
        FullMap.add(ME);
        FullMap.add(Mongolia);
        FullMap.add(Siam);
        FullMap.add(Siberia);
        FullMap.add(Ural);
        FullMap.add(Yakutsk);
        FullMap.add(EAUS);
        FullMap.add(Indonesia);
        FullMap.add(NG);
        FullMap.add(WAUS);

        setMap();
    }

    public void setMap(){
        //North America
        Alaska.addNeighbor(Kamchatka);
        Alaska.addNeighbor(NT);
        Alaska.addNeighbor(Alberta);

        Alberta.addNeighbor(NT);
        Alberta.addNeighbor(Ontario);
        Alberta.addNeighbor(WUS);

        CA.addNeighbor(WUS);
        CA.addNeighbor(EUS);
        CA.addNeighbor(Venezuela);

        EUS.addNeighbor(CA);
        EUS.addNeighbor(WUS);
        EUS.addNeighbor(Ontario);
        EUS.addNeighbor(Quebec);

        Greenland.addNeighbor(NT);
        Greenland.addNeighbor(Ontario);
        Greenland.addNeighbor(Quebec);
        Greenland.addNeighbor(Iceland);

        NT.addNeighbor(Alaska);
        NT.addNeighbor(Greenland);
        NT.addNeighbor(Alberta);
        NT.addNeighbor(Ontario);

        Ontario.addNeighbor(NT);
        Ontario.addNeighbor(Quebec);
        Ontario.addNeighbor(EUS);
        Ontario.addNeighbor(Alberta);
        Ontario.addNeighbor(WUS);

        Quebec.addNeighbor(Greenland);
        Quebec.addNeighbor(Ontario);
        Quebec.addNeighbor(EUS);

        WUS.addNeighbor(CA);
        WUS.addNeighbor(EUS);
        WUS.addNeighbor(Alberta);
        WUS.addNeighbor(Ontario);

        //South America

        Argentina.addNeighbor(Brazil);
        Argentina.addNeighbor(Peru);

        Brazil.addNeighbor(Argentina);
        Brazil.addNeighbor(Peru);
        Brazil.addNeighbor(Venezuela);
        Brazil.addNeighbor(NA);

        Peru.addNeighbor(Argentina);
        Peru.addNeighbor(Brazil);
        Peru.addNeighbor(Venezuela);

        Venezuela.addNeighbor(Brazil);
        Venezuela.addNeighbor(Peru);
        Venezuela.addNeighbor(CA);

        //Europe
        GB.addNeighbor(WE);
        GB.addNeighbor(Iceland);
        GB.addNeighbor(Scandinavia);
        GB.addNeighbor(NE);

        Iceland.addNeighbor(GB);
        Iceland.addNeighbor(Greenland);
        Iceland.addNeighbor(Scandinavia);

        NE.addNeighbor(GB);
        NE.addNeighbor(Scandinavia);
        NE.addNeighbor(WE);
        NE.addNeighbor(SE);
        NE.addNeighbor(Ukraine);

        Scandinavia.addNeighbor(GB);
        Scandinavia.addNeighbor(Iceland);
        Scandinavia.addNeighbor(Ukraine);
        Scandinavia.addNeighbor(NE);

        SE.addNeighbor(NE);
        SE.addNeighbor(Ukraine);
        SE.addNeighbor(WE);
        SE.addNeighbor(NA);
        SE.addNeighbor(Egypt);
        SE.addNeighbor(ME);

        Ukraine.addNeighbor(NE);
        Ukraine.addNeighbor(Scandinavia);
        Ukraine.addNeighbor(SE);
        Ukraine.addNeighbor(ME);
        Ukraine.addNeighbor(Afghanistan);
        Ukraine.addNeighbor(Ural);

        WE.addNeighbor(NE);
        WE.addNeighbor(SE);
        WE.addNeighbor(GB);
        WE.addNeighbor(NA);

        //Africa
        Congo.addNeighbor(NA);
        Congo.addNeighbor(EA);
        Congo.addNeighbor(SA);

        EA.addNeighbor(NA);
        EA.addNeighbor(Egypt);
        EA.addNeighbor(ME);
        EA.addNeighbor(Congo);
        EA.addNeighbor(SA);
        EA.addNeighbor(Madagascar);

        Egypt.addNeighbor(NA);
        Egypt.addNeighbor(EA);
        Egypt.addNeighbor(SE);
        Egypt.addNeighbor(ME);

        Madagascar.addNeighbor(EA);
        Madagascar.addNeighbor(SA);

        NA.addNeighbor(EA);
        NA.addNeighbor(Congo);
        NA.addNeighbor(Egypt);
        NA.addNeighbor(WE);
        NA.addNeighbor(SE);
        NA.addNeighbor(Brazil);

        SA.addNeighbor(EA);
        SA.addNeighbor(Madagascar);
        SA.addNeighbor(Congo);

        //Asia
        Afghanistan.addNeighbor(China);
        Afghanistan.addNeighbor(ME);
        Afghanistan.addNeighbor(India);
        Afghanistan.addNeighbor(Ural);
        Afghanistan.addNeighbor(Ukraine);

        China.addNeighbor(India);
        China.addNeighbor(Afghanistan);
        China.addNeighbor(Siam);
        China.addNeighbor(Mongolia);

        India.addNeighbor(China);
        India.addNeighbor(Siam);
        India.addNeighbor(ME);
        India.addNeighbor(Afghanistan);

        Irkutsk.addNeighbor(Mongolia);
        Irkutsk.addNeighbor(Kamchatka);
        Irkutsk.addNeighbor(Yakutsk);
        Irkutsk.addNeighbor(Siberia);

        Japan.addNeighbor(Kamchatka);
        Japan.addNeighbor(Mongolia);

        Kamchatka.addNeighbor(Alaska);
        Kamchatka.addNeighbor(Yakutsk);
        Kamchatka.addNeighbor(Irkutsk);
        Kamchatka.addNeighbor(Japan);
        Kamchatka.addNeighbor(Mongolia);

        ME.addNeighbor(Ukraine);
        ME.addNeighbor(Egypt);
        ME.addNeighbor(EA);
        ME.addNeighbor(India);
        ME.addNeighbor(Afghanistan);
        ME.addNeighbor(SE);

        Mongolia.addNeighbor(Japan);
        Mongolia.addNeighbor(China);
        Mongolia.addNeighbor(Kamchatka);
        Mongolia.addNeighbor(Irkutsk);
        Mongolia.addNeighbor(Siberia);

        Siam.addNeighbor(India);
        Siam.addNeighbor(China);
        Siam.addNeighbor(Indonesia);

        Siberia.addNeighbor(Yakutsk);
        Siberia.addNeighbor(Mongolia);
        Siberia.addNeighbor(Irkutsk);
        Siberia.addNeighbor(China);
        Siberia.addNeighbor(Ural);

        Ural.addNeighbor(Siberia);
        Ural.addNeighbor(China);
        Ural.addNeighbor(Afghanistan);
        Ural.addNeighbor(Ukraine);

        Yakutsk.addNeighbor(Kamchatka);
        Yakutsk.addNeighbor(Irkutsk);
        Yakutsk.addNeighbor(Siberia);

        //Australia
        EAUS.addNeighbor(WAUS);
        EAUS.addNeighbor(NG);

        Indonesia.addNeighbor(NG);
        Indonesia.addNeighbor(Siam);
        Indonesia.addNeighbor(WAUS);

        NG.addNeighbor(Indonesia);
        NG.addNeighbor(EAUS);
        NG.addNeighbor(WAUS);

        WAUS.addNeighbor(Indonesia);
        WAUS.addNeighbor(NG);
        WAUS.addNeighbor(EAUS);

    }


    public void PrintMap(){
        for (int x = 0; x < FullMap.size(); x++){
            Country temp = FullMap.get(x);
            Player play = temp.getPlayerOnCountry();
            System.out.println(temp.getName() + " has " + temp.getArmiesOnCountry() + " armies owned by " + play.getName() + " on it");
        }
    }

    public ArrayList<Country> getFullMap(){
        return FullMap;
    }

    public int getCountriesOcc() {
        int countriesOcc = 0;
        for(int x = 0; x < FullMap.size(); x++){
            Country temp = FullMap.get(x);
            countriesOcc = countriesOcc + temp.getOccupied();
        }
        countriesOccupied = countriesOcc;
        return countriesOcc;
    }
}
