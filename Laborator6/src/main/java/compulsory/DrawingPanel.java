package compulsory;

import com.sun.javafx.geom.Edge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private int numVertices;
    private int radius;
    private int numEdges;
    final static int W = 800, H = 600;
    Point selectedPoint = null;
    static int round = 1;
    static List<Point> points = new ArrayList<>();
    static List<Line> lines = new LinkedList<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.numEdges = 25;
        this.radius = 200;
        this.numVertices = 10;
        setPreferredSize(new Dimension(radius * 2, radius * 2));
        initPanel();
    }

    public DrawingPanel(MainFrame frame, int numVertices, int numEdges) {
        this.frame = frame;
        this.numEdges = numEdges;
        this.radius = 200;
        this.numVertices = numVertices;
        setPreferredSize(new Dimension(radius * 2, radius * 2));
        setPoints();
        setLines();
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var clickedAwd = e.getPoint();
                Point clickedPoint = new Point(clickedAwd.x, clickedAwd.y);
                for (Point point : points) {
                    if (clickedPoint.distance(point) > 30) {
                        continue;
                    }
                    if (selectedPoint == null) {
                        selectedPoint = point;
                        System.out.println("null");
                        break;
                    }
                    if (selectedPoint == point)
                        continue;
                    if (!(point.connections.contains(selectedPoint) && selectedPoint.connections.contains(point))) {
                        selectedPoint = null;
                        break;
                    }

                    Line line = new Line(selectedPoint, point);
                    if (round > 0)
                        line.setColor(Color.BLUE);
                    if (round < 0)
                        line.setColor(Color.RED);
                    round *= -1;
                    lines.add(line);

                    DrawingPanel newPanel = new DrawingPanel(frame);
                    frame.remove(frame.canvas);
                    frame.canvas = newPanel;
                    frame.add(newPanel, BorderLayout.CENTER);
                    frame.revalidate();
                    frame.canvas.removeAll();

                    System.out.println("avem");
                    selectedPoint = null;
                    break;
                }
            }
        });
    }

    public void update(int numEdges, int numVertices) {
        this.numEdges = numEdges;
        this.numVertices = numVertices;
        setPoints();
        setLines();
    }

    public void setPoints() {
        if (points != null) points.clear();
        int centerX = W / 2;
        int centerY = H / 2;
        double angle = 2 * Math.PI / numVertices;
        for (int i = 0; i < numVertices; i++) {
            int x = (int) (centerX + radius * Math.cos(i * angle));
            int y = (int) (centerY + radius * Math.sin(i * angle));
            points.add(new Point(x, y));
        }
    }

    public void setLines() {
        if (lines != null) lines.clear();
        Random rand = new Random();
        for (int i = 0; i < numEdges; i++) {
            Point point1 = points.get(rand.nextInt(numVertices));
            Point point2 = points.get(rand.nextInt(numVertices));
            if (!(point1.add(point2) && point2.add(point1))) {
                i--;
                continue;
            }
            lines.add(new Line(point1, point2));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : points) {
            g.fillOval(point.x, point.y, 10, 10);
        }

        for (Line line : lines) {
            g.setColor(line.color);
//            g.setStroke(new BasicStroke(3));
            g.drawLine(line.point1.x, line.point1.y, line.point2.x, line.point2.y);
        }

    }
}
