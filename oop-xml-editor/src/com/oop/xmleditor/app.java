package com.oop.xmleditor;

import javax.swing.*;

public class app {
    private JPanel mainPanel;
    private JButton associationLineButton;
    private JButton compositionLineButton;
    private JButton classButton;
    private JButton useCaseButton;
    private JButton groupUngroupButton;
    private JButton changeNameButton;
    private JButton generalizationLineButton;
    private JButton selectButton;

    public static void main(String[] args) {
        JFrame frame=new JFrame("app");
        frame.setContentPane(new app().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
