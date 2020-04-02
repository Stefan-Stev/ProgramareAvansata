/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author stefan
 */
public class ConfigPanel2 extends JPanel {

    final MainFrame frame;
    JComboBox shape;
    JComboBox colorBox;
    JSpinner sides;
    JLabel sideLabel;
    JPanel panel;

    public ConfigPanel2(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        panel = this;
        ///am adaugat label pentru culoare si figura
        //am adaugat meniu pt diferite figuri si culori
        JLabel shapeChoosen = new JLabel("Choose a figure:");
        String[] shapes = {"Circle", "Polygon", "Line"};
        shape = new JComboBox(shapes);
        JLabel colorChoosen = new JLabel("Choose a color");
        String[] colors = {"Black", "Random"};
        colorBox = new JComboBox(colors);

        //le adaugam
        add(shapeChoosen);
        add(shape);
        add(colorChoosen);
        add(colorBox);

        shape.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JComboBox shape = (JComboBox) e.getSource();
                Object selected = shape.getSelectedItem();
                //in caz ca am ales Polygon, mai adaug inca un JSpinner pentru a putea sa aleg si numarul de laturi
                if ("Polygon".equals(selected)) {
                    
                    sideLabel=new JLabel("Sides:");
                    JSpinner sides = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
                    sides.setValue(6);
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            panel.add(sideLabel);
                            panel.add(sides);
                            panel.validate();
                            panel.repaint();

                        }

                    });
                }

            }

        });

    }

}
