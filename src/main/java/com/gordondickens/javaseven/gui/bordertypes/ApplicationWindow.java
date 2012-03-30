package com.gordondickens.javaseven.gui.bordertypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setBounds(100, 100, 200, 100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

//        panel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
//        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
//        panel.setBorder(BorderFactory.createLoweredSoftBevelBorder());        
//        panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));
//        panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
//          panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED, 
//                Color.lightGray, Color.yellow));
//        panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
//                Color.lightGray, Color.yellow));
//        panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED, 
//                Color.lightGray, Color.lightGray, Color.white, Color.orange));
//        panel.setBorder(BorderFactory.createStrokeBorder(
//                new BasicStroke(1.0f)));//,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL)));
//        panel.setBorder(BorderFactory.createDashedBorder(Color.red));
//        panel.setBorder(BorderFactory.createDashedBorder(Color.red, 4.0f, 1.0f));
//        panel.setBorder(BorderFactory.createDashedBorder(Color.red, 2.0f, 10.0f, 1.0f, true));


        this.setLayout(new FlowLayout());

        JButton exitButton = new JButton("Exit");
        panel.add(exitButton);
        this.add(panel);

        exitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}
