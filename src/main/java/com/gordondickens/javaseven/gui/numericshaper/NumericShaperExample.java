package com.gordondickens.javaseven.gui.numericshaper;

import javax.swing.*;
import java.awt.*;

public class NumericShaperExample extends JFrame {

    public NumericShaperExample() {
        Container container = this.getContentPane();
        container.add("Center", new NumericShaperPanel());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("NumericShaper Example");
        this.setSize(250, 120);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new NumericShaperExample();
    }
}

