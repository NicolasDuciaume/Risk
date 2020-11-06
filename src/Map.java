import java.util.ArrayList;
/**
 * The class is responsible for creating the map of the game
 *
 */
public class Map {

    private Country Alaska, Alberta, CA, EUS, Greenland, NT, Ontario, Quebec, WUS;
    private Country Argentina, Brazil, Peru, Venezuela;
    private Country GB, Iceland, NE, Scandinavia,SE, Ukraine, WE;
    private Country Congo, EA, Egypt, Madagascar, NA, SA;
    private Country Afghanistan, China, India, Irkutsk, Japan, Kamchatka, ME, Mongolia, Siam, Siberia, Ural, Yakutsk;
    private Country EAUS, Indonesia, NG, WAUS;

    private ArrayList<Country> completeGameMap;
    private ArrayList<Country> NorthAmerica;
    private ArrayList<Country> SouthAmerica;
    private ArrayList<Country> Europe;
    private ArrayList<Country> Africa;
    private ArrayList<Country> Asia;
    private ArrayList<Country> Australia;
    /**
     * Default constructor of the Map class
     */
    public Map(){
        initializeCountries();

        initializeMap();

        initializeContinents();
    }
    /**
     * This function is responsible for initializing the complete game map.
     */
	private void initializeMap() {
		completeGameMap = new ArrayList<Country>();
		NorthAmerica = new ArrayList<>();
		SouthAmerica = new ArrayList<>();
		Europe = new ArrayList<>();
		Africa = new ArrayList<>();
		Asia = new ArrayList<>();
		Australia = new ArrayList<>();

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
    /**
     * This function is responsible for initializing the countries on the map 
     */
	private void initializeCountries() {
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
	}
    /**
     * This function is responsible for initializing the continents
     */
    public void initializeContinents(){
        //North America
        initializeNorthAmerica();

        //South America
        initializeSouthAmerica();

        //Europe
        initializeEurope();

        //Africa
        initializeAfrica();

        //Asia
        initializeAsia();

        //Australia
        initializeAustralia();

    }
	/**
     * This function is responsible for adding neighboring countries for Australian Countries
     */
	private void initializeAustralia() {
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

        Australia.add(EAUS);
        Australia.add(Indonesia);
        Australia.add(NG);
        Australia.add(WAUS);

	}
	/**
     * This function is responsible for adding neighboring countries for Asian Countries
     */
	private void initializeAsia() {
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

        Asia.add(Afghanistan);
        Asia.add(China);
        Asia.add(India);
        Asia.add(Irkutsk);
        Asia.add(Japan);
        Asia.add(Kamchatka);
        Asia.add(ME);
        Asia.add(Mongolia);
        Asia.add(Siam);
        Asia.add(Siberia);
        Asia.add(Ural);
        Asia.add(Yakutsk);
	}
    /**
     * This function is responsible for adding neighboring countries for African Countries
     */
	private void initializeAfrica() {
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

        Africa.add(Congo);
        Africa.add(EA);
        Africa.add(Egypt);
        Africa.add(Madagascar);
        Africa.add(NA);
        Africa.add(SA);
	}
	/**
     * This function is responsible for adding neighboring countries for European Countries
     */
	private void initializeEurope() {
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

        Europe.add(GB);
        Europe.add(Iceland);
        Europe.add(NE);
        Europe.add(Scandinavia);
        Europe.add(SE);
        Europe.add(Ukraine);
        Europe.add(WE);
	}
    /**
     * This function is responsible for adding neighboring countries for South American Countries
     */
	private void initializeSouthAmerica() {
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

        SouthAmerica.add(Argentina);
        SouthAmerica.add(Brazil);
        SouthAmerica.add(Peru);
        SouthAmerica.add(Venezuela);
	}
    /**
     * This function is responsible for adding neighboring countries for North American Countries
     */
	private void initializeNorthAmerica() {
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

        NorthAmerica.add(Alaska);
        NorthAmerica.add(Alberta);
        NorthAmerica.add(CA);
        NorthAmerica.add(EUS);
        NorthAmerica.add(Greenland);
        NorthAmerica.add(NT);
        NorthAmerica.add(Ontario);
        NorthAmerica.add(Quebec);
        NorthAmerica.add(WUS);
	}

    /**
     * This function is responsible for returning the current map 
     * state i.e., the country name and the armies on it
     */
    public void printMap(){
        for (int x = 0; x < completeGameMap.size(); x++){
            Country temp = completeGameMap.get(x);
            Player play = temp.getPlayerOnCountry();
            System.out.println(temp.getName() + " has " + temp.getArmiesOnCountry() + " armies owned by " + play.getName() + " on it");
            
        }
        System.out.println();
    }
    /**
     * This function gets the entire game map
     * @return the complete map of the game
     */
    public ArrayList<Country> getCompleteGameMap(){
        return completeGameMap;
    }

    /**
     * This function returns the occupied countries
     * @return the occupied countries
     */
    public int getOccupiedCountries() {
        int countriesOcc = 0;
        for(int x = 0; x < completeGameMap.size(); x++){
            Country temp = completeGameMap.get(x);
            if(temp.getPlayerOnCountry() != null){
                countriesOcc = countriesOcc + 1;
            }
        }
        return countriesOcc;
    }

    public ArrayList<Country> getAfrica() {
        return Africa;
    }

    public ArrayList<Country> getAsia() {
        return Asia;
    }

    public ArrayList<Country> getAustralia() {
        return Australia;
    }

    public ArrayList<Country> getEurope() {
        return Europe;
    }

    public ArrayList<Country> getNorthAmerica() {
        return NorthAmerica;
    }

    public ArrayList<Country> getSouthAmerica() {
        return SouthAmerica;
    }
}
