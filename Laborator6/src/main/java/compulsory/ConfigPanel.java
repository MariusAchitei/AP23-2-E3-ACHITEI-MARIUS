package compulsory;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner, linesSpinner;
    JComboBox linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        linesLabel = new JLabel("Number of lines");
        dotsLabel = new JLabel("Number of dots:");
        linesCombo = new JComboBox();
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        //create the rest of the components
// ...TODO
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesSpinner);
// ...TODO
    }
}
