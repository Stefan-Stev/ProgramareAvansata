/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        try (
                ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) oos.readObject();
        }

    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();

    }
}
