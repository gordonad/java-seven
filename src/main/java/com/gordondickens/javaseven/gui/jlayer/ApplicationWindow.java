package com.gordondickens.javaseven.gui.jlayer;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        LayerUI<JPanel> layerUI = new PasswordLayerUI();
        JLayer<JPanel> jlayer = new JLayer<>(getPanel(), layerUI);

        this.add(jlayer);
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(1, 2));
        JLabel quantityLabel = new JLabel("Password");
        gridPanel.add(quantityLabel);
        JPasswordField passwordField = new JPasswordField();
        gridPanel.add(passwordField);
        panel.add(gridPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton okButton = new JButton("OK");
        buttonPanel.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }
}
