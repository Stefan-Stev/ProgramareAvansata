package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class Name");
    private final JTextField classNameField = new JTextField(30);
    private final JButton createButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(classNameLabel);
        add(classNameField);
        add(createButton);
        createButton.addActionListener(e ->
        {
            JComponent comp = componentaDinamicaCreate(classNameField.getText());
            if (comp != null) {
                frame.designPanel.addAtRandomLocation(comp);
            }
        });

    }

    private JComponent componentaDinamicaCreate(String className) {
        try {
            Class clazz = Class.forName(className);
            Component component = (Component) clazz.getConstructor().newInstance();
            return (JComponent) component;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(e);
        }
        return null;
    }

}
