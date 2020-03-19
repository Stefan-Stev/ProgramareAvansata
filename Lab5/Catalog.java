/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stefan
 */
public class Catalog {
    private String name;
   private String path;
   private List<Document> documents=new ArrayList<>();

    Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    
  
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
   public void add(Document doc){
       documents.add(doc);
   }
   public Document findById(String id){
       return documents.stream().filter(d->d.getId().equals(id)).findFirst().orElse(null);
       
   }
           
    
}
