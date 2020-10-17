public class Map {

    private Country Alaska, Alberta, CA, EUS, Greenland, NT, Ontario, Quebec, WUS;
    private Country Argentina, Brazil, Peru, Venezuela;
    private Country GB, Iceland, NE, Scandinavia,SE, Ukraine, WE;
    private Country Congo, EA, Egypt, Madagascar, NA, SA;
    private Country Afghanistan, China, India, Irkutsk, Japan, Kamchatka, ME, Mongolia, Siam, Siberia, Ural, Yakutsk;
    private Country EAUS, Indonesia, NG, WAUS;

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



    }
}
