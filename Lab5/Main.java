/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stefan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)   {
      Main app=new Main();
      app.testCreateSave();
        try {
            app.testLoadView();
        } catch (InvalidCatalogException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public void testCreateSave(){
        Catalog catalog=new Catalog("Java Resources","~/LaboratoareJava");
        Document doc=new Document("java1","Java Courses 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        try {
            CatalogUtil.save(catalog);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException
    {
        Catalog catalog= CatalogUtil.load("~/LaboratoareJava");
        Document doc=catalog.findById("java1");
        CatalogUtil.view(doc);
    }
    
}
