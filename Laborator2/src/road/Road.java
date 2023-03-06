package road;

import location.Location;

public abstract class Road {
    private String name;
    private int length;
    private Location locations[];

    public Road(String name, int length) {
        this.name = name;
        this.length = length;
        locations = new Location[2];
    }

    public Road() {
    }

    @Override
    public String toString() {
        return "Road{" +
                "name=" + name +
                ", length=" + length + " km" +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Road road = (Road) obj;
        return name.equals(road.name);
    }

    public boolean equals(Road r) {
        if (this == r) return true;
        if (r == null || getClass() != r.getClass() && getSuperClass() != r.getSuperClass()) return false;
        Road road = (Road) r;
        return name.equals(road.name);
    }

    public String getSuperClass() {
        return "Road";
    }


    public void setLocations(Location l1, Location l2) {
        if (l1 == null || l2 == null) return;
        locations[0] = l1;
        locations[1] = l2;
        l1.addConnection(l2);
        l2.addConnection(l1);
    }

    public Location getLocation1() {
        return locations[0];
    }

    public Location getLocation2() {
        return locations[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getLength() {
        return length;
    }


    public void setLength(int length) {
        this.length = length;
    }

}
