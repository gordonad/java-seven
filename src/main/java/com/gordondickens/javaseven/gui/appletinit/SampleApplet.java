package com.gordondickens.javaseven.gui.appletinit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SampleApplet extends Applet {
    private static final Logger logger = LoggerFactory.getLogger(SampleApplet.class);
    BufferedImage image;
    Graphics2D g2d;

    public void init() {
        int width = getWidth();
        int height = getHeight();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = image.createGraphics();
        g2d.setPaint(Color.BLUE);
        g2d.fillRect(0, 0, width, height);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            logger.error("", ie);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}
