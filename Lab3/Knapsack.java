/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stefan
 */
public class Knapsack {

    private double capacity;
    private List<Item> items;

    public Knapsack(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public StringBuilder toString1() {
        //realizez o forma de afisare a sacului sub forma unui string
        StringBuilder str = new StringBuilder();
        for (Item i : items) {
            str.append(i.getName());
            str.append(" ");
            str.append(i.getWeight());
            str.append(" ");
            str.append(i.getValue());
            str.append("\n");
        }
        return str;
    }

}
