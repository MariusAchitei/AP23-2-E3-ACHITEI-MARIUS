package compulsory;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    private int numVertices;
    private int numEdges;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();
    }
}
