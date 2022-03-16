package com.oop.xmleditor;

import javax.swing.*;

public class app {
    private JButton button1;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame=new JFrame("app");
        frame.setContentPane(new app().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
