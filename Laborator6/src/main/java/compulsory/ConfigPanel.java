package compulsory;

import javax.swing.*;
import java.awt.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner, linesSpinner;
    JComboBox lineProbabilityCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        createButton = new JButton("Create game");
        linesLabel = new JLabel("Number of lines");
        dotsLabel = new JLabel("Number of dots:");

//        String[] probabilities = new String[]{"0.2", "0.3", "0.5", "0.6", "0.7", "0.8", "0.9", "1"};
        Double[] probabilities = new Double[]{0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.};


        lineProbabilityCombo = new JComboBox<Double>(probabilities);

        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        createButton.addActionListener(e -> createGameAction());

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(lineProbabilityCombo);
        add(createButton);
    }

    public void createGameAction() {
//        DrawingPanel newPanel = new DrawingPanel(this.frame);
//        var numVertices = (Integer) dotsSpinner.getValue();
//        var probability = (Double) lineProbabilityCombo.getSelectedItem();
//        var numEdges = (int) (probability * numVertices * (numVertices - 1) / 2);
//        newPanel.update(numVertices, numEdges);
        int numVertices = (int) dotsSpinner.getValue();
        var probability = (Double) lineProbabilityCombo.getSelectedItem();
        int numEdges = (int) (probability * numVertices * (numVertices - 1) / 2);
        DrawingPanel newPanel = new DrawingPanel(this.frame, numVertices, numEdges);
        newPanel.update(numEdges, numVertices);

        frame.remove(frame.canvas);
        frame.canvas = newPanel;
        frame.add(newPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.canvas.removeAll();


    }
}
