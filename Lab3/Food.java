/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author stefan
 */
public class Food implements Item {

    private String name;
    private double weight; // getWeight,getValue
    private double value;

    Food(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;

    }

    public void setValue() {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
