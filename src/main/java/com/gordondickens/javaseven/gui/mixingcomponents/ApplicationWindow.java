package com.gordondickens.javaseven.gui.mixingcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setSize(200, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        Button exitButton = new Button("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        this.add(exitButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Overlapping Menu");
        JMenuItem menuItem = new JMenuItem("Overlapping Item");
        menu.add(menuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.validate();

    }
}
