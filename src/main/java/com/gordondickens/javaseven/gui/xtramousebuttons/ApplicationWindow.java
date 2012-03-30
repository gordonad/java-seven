package com.gordondickens.javaseven.gui.xtramousebuttons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApplicationWindow extends JFrame
        implements MouseListener, MouseWheelListener {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationWindow.class);

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setSize(200, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JButton exitButton = new JButton("Exit");
        this.add(exitButton);

        int totalButtons = MouseInfo.getNumberOfButtons();
        logger.debug(Boolean.toString(Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled()));
        logger.debug("You have " + totalButtons + " total buttons");


        this.addMouseListener(this);
        this.addMouseWheelListener(this);


        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

    }

    public void mousePressed(MouseEvent e) {
        logger.debug("" + e.getButton());

    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        logger.debug("" + e.getPreciseWheelRotation() +
                " - " + e.getWheelRotation());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
