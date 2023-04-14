package compulsory;

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
    private java.util.List<Point> points = new ArrayList<>();
    private List<Line> lines = new LinkedList<>();


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.numEdges = 25;
        this.radius = H / 2 - 50;
        this.numVertices = 10;
        setPreferredSize(new Dimension(radius * 2, radius * 2));
        initPanel();
    }

//    public DrawingPanel(MainFrame frame, int numVertices, int numEdges) {
//        this.frame = frame;
//        this.radius = 200;
//        this.numEdges = numEdges;
//        this.numVertices = numVertices;
//        setPreferredSize(new Dimension(radius * 2, radius * 2));
//        initPanel();
//    }

    public DrawingPanel(MainFrame frame, List<Point> points, List<Line> lines) {
        this.frame = frame;
        this.radius = 200;

        this.points = points;
        this.lines = lines;

        setPreferredSize(new Dimension(radius * 2, radius * 2));
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var click = e.getPoint();
                Point clickedPoint = new Point(click.x, click.y);
                frame.colorLine(clickedPoint);
            }
        });
    }

//    public void update(int numEdges, int numVertices) {
//        this.numEdges = numEdges;
//        this.numVertices = numVertices;
//        setPoints();
//        setLines();
//    }

//    public void setPoints() {
//        if (points != null) points.clear();
//        int centerX = W / 2;
//        int centerY = H / 2;
//        double angle = 2 * Math.PI / numVertices;
//        for (int i = 0; i < numVertices; i++) {
//            int x = (int) (centerX + radius * Math.cos(i * angle));
//            int y = (int) (centerY + radius * Math.sin(i * angle));
//            points.add(new Point(x, y));
//        }
//    }
//
//    public void setLines() {
//        if (lines != null) lines.clear();
//        Random rand = new Random();
//        for (int i = 0; i < numEdges; i++) {
//            Point point1 = points.get(rand.nextInt(numVertices));
//            Point point2 = points.get(rand.nextInt(numVertices));
//            if (!(point1.add(point2) && point2.add(point1))) {
//                i--;
//                continue;
//            }
//            lines.add(new Line(point1, point2));
//        }
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Line line : lines) {
            g.setColor(line.color);
//            g.setStroke(new BasicStroke(3));
            g.drawLine(line.point1.x, line.point1.y, line.point2.x, line.point2.y);
        }

        for (Point point : points) {
            g.setColor(Color.GRAY);
            g.fillOval(point.x - 5, point.y - 5, 10, 10);
        }
    }
}
