public class Location {
    private String name;
    private LocationType type;
    private double x;
    private double y;

    @Override
    public String toString() {
        return "Application.Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
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

    public void setType(LocationType type) {
        this.type = type;
    }

    public void setx(double x) {
        this.x = x;
    }

    public void sety(double y) {
        this.y = y;
    }
}
