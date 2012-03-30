package com.gordondickens.javaseven.gui.printdialog;

import javax.swing.*;

public class ApplicationDriver {

    public static void main(String[] args) {
//        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ApplicationWindow window = new ApplicationWindow();
                window.setVisible(true);
            }
        });

    }
}
