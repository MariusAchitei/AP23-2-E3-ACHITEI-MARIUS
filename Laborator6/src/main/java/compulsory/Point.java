package compulsory;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Point implements Serializable {
    public int x;
    public int y;

    List<Point> connections;

    public Point() {
        connections = new LinkedList<>();
    }

    public Point(int x, int y) {
        connections = new LinkedList<>();
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean add(Point point) {
        if (connections.contains(point))
            return false;
        connections.add(point);
        return true;
    }

    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
