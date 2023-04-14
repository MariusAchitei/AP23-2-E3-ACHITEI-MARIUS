package compulsory;

import java.awt.*;

public class Line {
    public Point point1;
    public Point point2;
    public boolean colored;
    public Color color;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.colored = false;
        this.color = Color.GRAY;
        point1.add(point2);
        point2.add(point1);
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double length() {
        return point1.distance(point2);
    }
}
