package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");

    //create all buttons (Load, Exit, etc.)
// ...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.saveGame();
            }
        });
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.loadGame();
            }
        });
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
