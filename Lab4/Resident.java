/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residents.hospitals;

/**
 *
 * @author stefan
 */
public class Resident implements Comparable{
      private String name;
    Resident(String string) {
        this.name=string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public String toString() {
        return "Resident{" + "name=" + name + '}';
    }

    @Override
    public int compareTo(Object o) {
        Resident r=(Resident) o;
        return this.getName().compareTo(r.getName());
    }
    
    
}
