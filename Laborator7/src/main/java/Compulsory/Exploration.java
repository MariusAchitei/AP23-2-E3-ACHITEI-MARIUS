package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private SharedMemory mem;
    private ExplorationMap map;
    private List<Robot> robots = new ArrayList<>();
    private int size;

    public int getSize() {
        return size;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public Exploration(int n) {
        size = n;
        map = new ExplorationMap(n);
        mem = new SharedMemory(n);
    }

    public void addRobot(Robot robot) {
        if (robots.contains(robot))
            return;
        robot.setExplore(this);
        robots.add(robot);
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public SharedMemory getMem() {
        return mem;
    }

    public static void main(String args[]) {
        var explore = new Exploration(10);
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }
}
