package com.gordondickens.javaseven.gui.windowfocus;

import javax.swing.*;

public class SecondWindow extends JFrame {

    public SecondWindow() {
        this.setTitle("Second Window");
        this.setBounds(400, 100, 200, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setAutoRequestFocus(false);
    }
}

