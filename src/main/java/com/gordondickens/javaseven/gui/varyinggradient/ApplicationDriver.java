package com.gordondickens.javaseven.gui.varyinggradient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.GraphicsDevice.WindowTranslucency;

public class ApplicationDriver {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationDriver.class);

    public static void main(String[] args) {
        GraphicsEnvironment envmt =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = envmt.getDefaultScreenDevice();

        if (!device.isWindowTranslucencySupported(WindowTranslucency.PERPIXEL_TRANSLUCENT)) {
            logger.debug("Translucent windows are not supported on your system.");
            System.exit(0);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ApplicationWindow window = new ApplicationWindow();
                window.setVisible(true);
            }
        });

    }
}
