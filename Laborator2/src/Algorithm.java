import location.Location;

import java.util.*;

public class Algorithm {
    private Problem pb;

    private HashMap<Location, Integer> cost;
    private List<Location> visited;
    private int distance = 0;

    public Algorithm(Problem pb) {
        this.pb = pb;
        visited = new LinkedList<>();
    }


    public void solve(Location start, Location finish) {
        //verificare daca sunt in problema
        //eventual verificare daca avem drum

        visited = new ArrayList<>();
        cost = new HashMap<>();

        for (Location l :
                pb.getLocations()) {
            cost.put(l, 999_999);
        }

        cost.replace(start, 0);
        visited.add(start);

        int min = 999_999;
        Location l = null;
        for (var entry:
                start.getConnections().entrySet()) {
            if (entry.getValue() < min) {
                l = entry.getKey();
                min = entry.getValue();
            }
        }

        System.out.println(l.getName());
    }


}