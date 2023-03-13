package location;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Location {
    private String name;
    private double x;
    private double y;

    private HashMap<Location, Integer> connections;

    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        connections = new HashMap<Location, Integer>();
    }

    public Location() {
    }

    @Override
    public String toString() {
        return getClass() + " {" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean equals(Location l) {
        if (this == l) return true;
        if (l == null || getClass() != l.getClass() && getSuperClass() != l.getSuperClass()) return false;
        Location location = (Location) l;
        return name.equals(location.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return name.equals(location.name);
    }

    public void addConnection(Location location, int length) {
        connections.put(location, length);
    }

    public HashMap<Location, Integer> getConnections() {
        return connections;
    }

    public String getSuperClass() {
        return "Location";
    }

    public String getName() {
        return name;
    }


    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setx(double x) {
        this.x = x;
    }

    public void sety(double y) {
        this.y = y;
    }
}
