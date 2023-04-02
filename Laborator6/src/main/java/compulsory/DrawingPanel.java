package compulsory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private int numVertices;
    private int radius;
    private int numEdges;
    final static int W = 800, H = 600;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.numEdges = 25;
        this.radius = 200;
        this.numVertices = 10;
        setPreferredSize(new Dimension(radius * 2, radius * 2));
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        List<Point> Points = new ArrayList<Point>();

        double angle = 2 * Math.PI / numVertices;
        for (int i = 0; i < numVertices; i++) {
            int x = (int) (centerX + radius * Math.cos(i * angle));
            int y = (int) (centerY + radius * Math.sin(i * angle));
            Points.add(new Point(x, y));
            g.fillOval(x - 2, y - 2, 7, 7);
        }
        for (int i = 0; i < 10; i++) {
            Point point1 = Points.get((int) Math.floor(Math.random() * (
                    ++ 1)));
            Point point2 = Points.get((int) Math.floor(Math.random() * (numVertices + 1)));
            g.drawLine(point1.x, point1.y, point2.x, point2.y);
        }

    }
}

