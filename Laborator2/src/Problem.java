import location.*;
import road.*;

import java.util.*;

public class Problem {
    private Location[] locations;
    private Road[] roads;

    private int nLocations = 0;
    private int nRoads = 0;

    public Problem() {
        locations = new Location[50];
        roads = new Road[50];
    }

    /**
     * Algoritmul care verifica daca exista drum BFS
     */
    public boolean isPath(Location start, Location finish) {

        validate();

        boolean ok1 = false, ok2 = false;
        for (int i = 0; i < nLocations; i++) {
            if (locations[i] == start) ok1 = true;
            if (locations[i] == finish) ok2 = true;
            if (ok1 && ok2) break;
        }
        if (!ok1 || !ok2) return false;

        Queue<Location> queue = new LinkedList<>();
        queue.add(start);
        List<Location> visited = new LinkedList<>();

        while (!queue.isEmpty()) {
            Location current = queue.poll();
            visited.add(current);
            for (Location connection :
                    current.getConnections().keySet()) {
                if (connection == finish) return true;
                if (!visited.contains(connection))
                    queue.add(connection);
            }
        }
        return false;

    }

    /**
     * Problema nu este valida daca nu avem Drumuri sau Locatii
     */
    public boolean validate() {
        if (nRoads <= 0 || nLocations <= 0) return false;
        return true;
    }

    /**
     * Metoda cu argumente variabile pentru adaugarea de drumuri
     * Verifica prin drumurile deja existente in problema daca inserez unul cu acelasi nume
     *
     * @param roads
     */

    public void addRoads(Road... roads) {
        if (roads == null) return;
        for (Road road :
                roads) {
            for (int i = 0; i < nRoads; i++) {
                if (this.roads[i].equals(road)) {
                    System.out.println("Am refuzat intrarea " + road.getName() + " de tip: " + road.getClass() + " pe motiv de duplicare");
                    return;
                }
            }
            this.roads[nRoads] = road;
            nRoads++;
        }
    }

    /**
     * analog
     *
     * @param locations
     */
    public void addLocations(Location... locations) {
        if (locations == null) return;
        for (Location location :
                locations) {
            for (int i = 0; i < nLocations; i++) {
                if (this.locations[i].equals(location)) {
                    System.out.println("Am refuzat intrarea " + location.getName() + " de tip: " + location.getClass() + " pe motiv de duplicare");
                    return;
                }
            }
            this.locations[nLocations] = location;
            nLocations++;
        }
    }

    /**
     * Functii basic de printare
     */
    public void printLocations() {
        for (int i = 0; i < nLocations; i++) {
            System.out.println(locations[i] + "   " + locations[i].getClass());
        }
    }

    public void printRoads() {
        for (int i = 0; i < nRoads; i++) {
            System.out.println(roads[i] + "   " + roads[i].getClass());
        }
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public Road[] getRoads() {
        return roads;
    }

    public void setRoads(Road[] roads) {
        this.roads = roads;
    }

    public int getnLocations() {
        return nLocations;
    }

    public void setnLocations(int nLocations) {
        this.nLocations = nLocations;
    }

    public int getnRoads() {
        return nRoads;
    }

    public void setnRoads(int nRoads) {
        this.nRoads = nRoads;
    }
}
