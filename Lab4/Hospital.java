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
public class Hospital implements Comparable {

    private String nume;

    public Hospital(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Hospital{" + "nume=" + nume + '}';
    }

    @Override
    public int compareTo(Object o) {
        Hospital h1 = (Hospital) o;
        return this.getNume().compareTo(h1.getNume());
    }

}
