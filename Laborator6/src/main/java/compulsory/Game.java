package compulsory;

import java.awt.*;

public class Game {
    private MainFrame frame;

    public void init() {
        new MainFrame(this).setVisible(true);
    }
}
