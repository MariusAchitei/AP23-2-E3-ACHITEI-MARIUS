package compulsory;

import java.awt.*;
import java.io.Serializable;

public class Line implements Serializable {
    public Point point1;
    public Point point2;
    public int colored;
    public Color color;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.colored = 0;
        this.color = Color.GRAY;
        point1.add(point2);
        point2.add(point1);
    }

    public void setColored(int player) {
        this.colored = player;
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
