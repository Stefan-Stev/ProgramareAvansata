package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.lang.Object;
import java.awt.Color;
import javafx.scene.shape.Circle;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stefan
 */
public class DrawingPanel extends javax.swing.JPanel {


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    final MainFrame frame;
    final static int W = 1400, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    int counterForLines;
    private int x2;
    private int y2;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        //aici voi desena un cerc
        Random rand = new Random();
        if (frame.configPanel2.shape.getSelectedItem() == "Circle") {
            System.out.println("da");
            Color color;
            if (frame.configPanel2.colorBox.getSelectedItem() == "Random") {
                int r = rand.nextInt(255 - 128) + 128;
                int g = rand.nextInt(255 - 128) + 128;
                int b = rand.nextInt(255 - 128) + 128;
                //cica culorile transparente sunt intre 128 si 255
                color = new Color(r, g, b); //am creat  culoare 
            } else {
                color = Color.BLACK;
            }
            graphics.setColor(color);
            int radius = rand.nextInt(100);
            
            graphics.fill(new NodeShape(x, y, radius));
        }
        //desenez un poligon
        if (frame.configPanel2.shape.getSelectedItem() == "Polygon") {
            System.out.println("Poligon--------");
            int radius = rand.nextInt(90);
            int sides = 6;

            System.out.println(sides);
            Color color;

            if (frame.configPanel2.colorBox.getSelectedItem() == "Random") {
                int r = rand.nextInt(255 - 128) + 128;
                int g = rand.nextInt(255 - 128) + 128;
                int b = rand.nextInt(255 - 128) + 128;
                //cica culorile transparente sunt intre 128 si 255
                color = new Color(r, g, b); //am creat  culoare 
            } else {
                color = Color.BLACK;
            }

            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));

        }

        //In caz ca este linie 
        if (frame.configPanel2.shape.getSelectedItem() == "Line") {
            System.out.println("Ma pregatesc de desenat o linie");
            /*Color color;
             //trebuie sa aleg culoarea
             if (frame.configPanel2.colorBox.getSelectedItem() == "Random") {
             int r = rand.nextInt(255 - 128) + 128;
             int g = rand.nextInt(255 - 128) + 128;
             int b = rand.nextInt(255 - 128) + 128;
             //cica culorile transparente sunt intre 128 si 255
             color = new Color(r, g, b); //am creat  culoare 
             } else {
             color = Color.BLACK;
             }
            //-----------

            //adaug alte noi coordonate pentru a desena linia
            this.addMouseListener(new MouseAdapter() {
             @Override
             public void mousePressed(MouseEvent e) {
             //if(frame.configPanel2.shape.getSelectedItem()=="Line"){
             int x2=e.getX();
             int y2=e.getY();
             graphics.drawLine(x, y, x2, y2);
                
                
             // }
             }       });*///-----------------------------------------
            //Daca se decomenteaza aceasta parte si se comenteaza urmatoare, se poate obtine un "fel de"  graf (A se vedea in poza)
            //-----------------------------------------
            
            
            
            
            
            //Linia o voi construi prin doua apasari de mouse(mouseEvent) se vor lua coordonatele si se vor uni ( mai intai seria de coordonate x1,y1 si apoi seria de cordonate
            // x2 si y2 )
            //acest if verifica daca este prima serie de coordonte
            if (this.counterForLines == 0) {
                counterForLines++;
                x2 = x;
                y2 = y;
                //doar am retinut primul capat al liniei
            } else {  //daca cumva am deja plasat primul capat si am plasat si al doilea capat, incep desenarea
               Color color;

                if (frame.configPanel2.colorBox.getSelectedItem() == "Random") {
                    int r = rand.nextInt(255 - 128) + 128;
                    int g = rand.nextInt(255 - 128) + 128;
                    int b = rand.nextInt(255 - 128) + 128;
                    //cica culorile transparente sunt intre 128 si 255
                    color = new Color(r, g, b); //am creat  culoare 
                } else {
                    color = Color.BLACK;
                }

                graphics.setColor(color);
                graphics.drawLine(x, y, x2, y2);
                counterForLines = 0;

            }
        }

    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}
