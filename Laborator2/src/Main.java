import location.*;
import road.*;

public class Main {
    public static void main(String[] args) {

        /**
         * Creez o noua problema si o populez cu locatii si drumuri
         */

        Problem pb = new Problem();

        Location iasi = new City("Iasi", 30, 45, 200_000);
        Location suceava = new City("Suceava", 31, 46, 80_000);
        Location piatra = new City("Piatra Neamt", 31, 43, 60_000);
        Location bacau = new City("Bacau", 31, 43, 60_000);
        Location botosani = new City("Botosani", 31, 46, 100_000);
        Location satu = new City("Satu Mare", 31, 46, 50_000);
        Location omvBotosani = new GasStation("OMV Botosani", 31, 46, 4, 7.77);
        Location aeroportIasi = new AirPort("Iasi", 31, 45, 5);

        System.out.println(botosani);
        System.out.println(aeroportIasi);

        /**
         *  Adaug 2 locatii cu acelasi nume pentru a genera o exceptie
         */

        pb.addLocations(iasi, botosani, bacau, piatra);
        pb.addLocations(satu, aeroportIasi);

        Road r1 = new Country("DN24", 150);
        Road r2 = new Express("E2", 200);
        Road r3 = new Highway("A3", 190);
        Road r4 = new Country("DN25", 170);
        Road r5 = new Highway("DN24", 250);

        r1.setLocations(iasi, botosani);
        r2.setLocations(suceava, iasi);
        r3.setLocations(piatra, iasi);
        r4.setLocations(suceava, satu);

        pb.addRoads(r1, r2, r3, r4);

        System.out.println(r1);
        System.out.println(r2);

//        pb.printLocations();
//        pb.printRoads();
        /**
         * Inspectez elementele din problema
         *
         * Incerc sa gasesc un drum intre 2 locatii nelegate (Piatra si Bacau)
         *  si 2 localitati care au legatura dar nu este directa (Satu Mare si Botosani)
         */

        System.out.println("\nVerificam posibilitatea de a merge de la Piatra la Bacau");
        if (pb.isPath(piatra, bacau))
            System.out.println("EXISTA un drum intre cele doua locatii\n");
        else
            System.out.println("NU AM GASIT niciun drum intre cele doua locatii\n");

        System.out.println("\nVerificam posibilitatea de a merge de la Satu Mare la Botosani");
        if (pb.isPath(satu, botosani))
            System.out.println("EXISTA un drum intre cele doua locatii\n");
        else
            System.out.println("NU AM GASIT niciun drum intre cele doua locatii\n");

        Algorithm alg = new Algorithm(pb);
        alg.solve(iasi, botosani);

    }
}


