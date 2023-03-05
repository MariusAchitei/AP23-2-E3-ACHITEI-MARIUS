public class Main {
    public static void main(String[] args) {

        Road dn24;
        dn24 = new Road(RoadType.COUNTRY, 150, 90);
        Location home;
        home = new Location("Iasi", LocationType.CITY, 30, 45);
        System.out.println(dn24);
        System.out.println(home);

        dn24.setType(RoadType.EXPRESS);
        dn24.setSpeedLimit(110);

        System.out.println(dn24);

        Road a1 = new Road();
        a1.setType(RoadType.HIGHWAY);
        a1.setSpeedLimit(130);
        a1.setLength(250);


        System.out.println("\n" + a1);

        Location peco = new Location();
        peco.setType(LocationType.GAS_STATION);
        peco.setName("OMV");

        System.out.println("\n" + peco);


    }
}


