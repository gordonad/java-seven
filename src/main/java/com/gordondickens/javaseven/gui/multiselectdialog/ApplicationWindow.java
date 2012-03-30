package com.gordondickens.javaseven.gui.multiselectdialog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ApplicationWindow extends JFrame {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationWindow.class);

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setSize(200, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout());

        final FileDialog fileDialog = new FileDialog(this, "FileDialog");
        fileDialog.setMultipleMode(true);

        JButton fileDialogButton = new JButton("File Dialog");
        fileDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fileDialog.setVisible(true);
                File files[] = fileDialog.getFiles();
                for (File file : files) {
                    logger.debug("File: " + file.getName());
                }

            }
        });

        this.add(fileDialogButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        this.add(exitButton);
    }

}
