package lab6;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stefan
 */
public class ControlPanel extends javax.swing.JPanel {

    final MainFrame frame;
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");
    JButton chooseSaveAs = new JButton("Choose a file where Save");
    JButton chooseLoadFrom = new JButton("Load from");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
    private void init() {
        //voi schimba layout default manager
        setLayout(new GridLayout(1, 4));
        //adaugam butoanele
        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitButton);
        add(chooseSaveAs);
        add(chooseLoadFrom);
        //ascultam orice eveniment
        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);
        
        //am creat pt File chooser
        chooseSaveAs.addActionListener(this::chooseSaved);
        chooseLoadFrom.addActionListener(this::chooseLoad);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "png", new File("./tree.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

    private void load(ActionEvent e) {
        try {
            frame.canvas.image = ImageIO.read(new File("tree.png"));
        } catch (IOException ee) {
            ee.printStackTrace();
        }
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.repaint();
    }

    private void reset(ActionEvent e) {
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, 1400, 600);
        frame.canvas.repaint();
    }

    
    
    //File chooser pentru a salva intr-o anumita locatie
    private void chooseSaved(ActionEvent e) {
        String filename = File.separator + "tmp";
        JFileChooser fileChooser = new JFileChooser(new File(filename));
        //fileChooser.showOpenDialog(frame);//face sa mi apara "Open File'' Chooser dialog
        // System.out.println("File to open: " + fileChooser.getSelectedFile());
        fileChooser.showSaveDialog(frame);
        System.out.println("File to be saved" + fileChooser.getSelectedFile());
        try {
            ImageIO.write(frame.canvas.image, "png", fileChooser.getSelectedFile());
        } catch (IOException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  //File chooser pentru a incarca dintr-o anumita locatie
    private void chooseLoad(ActionEvent e) {
        String filename = File.separator + "tmp";
        JFileChooser fileChooser = new JFileChooser(new File(filename));
        fileChooser.showOpenDialog(frame);
        System.out.println("File to be open" + fileChooser.getSelectedFile());
        try {
            frame.canvas.image = ImageIO.read(fileChooser.getSelectedFile());
        } catch (IOException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.repaint();

    }

}
