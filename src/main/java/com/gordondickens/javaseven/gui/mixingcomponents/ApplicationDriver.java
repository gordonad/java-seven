package com.gordondickens.javaseven.gui.mixingcomponents;

import javax.swing.*;

public class ApplicationDriver {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ApplicationWindow window = new ApplicationWindow();
                window.setVisible(true);
            }
        });

    }
}

