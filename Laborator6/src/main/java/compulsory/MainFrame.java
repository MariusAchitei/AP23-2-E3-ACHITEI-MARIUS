package compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    private Game game;
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    final int W = 800, H = 600, radius = H / 2 - 50;

    private int numVertices;
    private int numEdges;

    private java.util.List<Point> points = new ArrayList<>();
    private List<Line> lines = new LinkedList<>();
    private Point selectedPoint = null;
    static int round = 1;

    public MainFrame(Game game) {
        super("My Drawing Application");
        init();
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);


        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

    public void createGame(int numVertices, int numEdges) {
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        setPoints();
        setLines();
        DrawingPanel newPanel = new DrawingPanel(this, points, lines);
//        newPanel.update(numEdges, numVertices);

        updateDrawingPanel();
    }

    public void colorLine(Point clickedPoint) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        printAll(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", new File("Paint.png"));
        } catch (IOException exp) {
            exp.printStackTrace();
        }
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
            if (round > 0) {
                line.setColor(Color.BLUE);
                line.setColored(1);
            }
            if (round < 0) {
                line.setColor(Color.RED);
                line.setColored(-1);
            }
            lines.add(line);
            if (checkWinner(line)) {
                if (round > 0)
                    System.out.println("ALBASTRU A CASTIGAT JOCUL");
                if (round < 0)
                    System.out.println("ROSU A CASTIGAT JOCUL");
            }

            round *= -1;
            updateDrawingPanel();

            System.out.println("avem");
            selectedPoint = null;

            break;
        }
    }

    public void updateDrawingPanel() {
        DrawingPanel newPanel = new DrawingPanel(this, points, lines);
        remove(canvas);
        canvas = newPanel;
        add(newPanel, BorderLayout.CENTER);
        revalidate();
        canvas.removeAll();
    }

    public boolean checkWinner(Line line) {
        Point p1 = line.point1;
        Point p2 = line.point2;
        int player = line.colored;
        for (Point point :
                p1.connections) {
            if (point.connections.contains(p2) == true)
                for (Line l : lines)
                    if ((l.point1 == point || l.point2 == point) && (l.point1 == p1 || l.point2 == p1))
                        if (l.colored == player)
                            for (Line l2 : lines)
                                if ((l2.point1 == point || l2.point2 == point) && (l.point1 == p2 || l.point2 == p2))
                                    if (l2.colored == player)
                                        return true;
        }
        return false;
    }

    public void saveGame() {
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(points);
            o.writeObject(lines);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadGame() {
        try {
            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            List<Point> points = (List<Point>) oi.readObject();
            List<Line> lines = (List<Line>) oi.readObject();

            oi.close();
            fi.close();

            this.points = points;
            this.lines = lines;
            updateDrawingPanel();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
}
