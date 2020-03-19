/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author stefan
 */
public class Greedy implements Algoritm {

    private List<Item> listaObiecte;
    private List<Item> nouaLista;
    private double capacitate;

    public List<Item> getNouaLista() {
        return nouaLista;
    }

    Greedy(int capacitate, List<Item> obiecte) {
        this.capacitate = capacitate;
        this.listaObiecte = obiecte;
    }

    public List<Item> getListaObiecte() {
        return listaObiecte;
    }

    public double getCapacitate() {
        return capacitate;
    }

    public void rezolvare() {
        Item[] itemsArray = new Item[listaObiecte.size()];
        //sortez greedy dupa valoarea profitului
        itemsArray = listaObiecte.toArray(itemsArray);
        Arrays.sort(itemsArray, new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {
                return Double.valueOf(o2.profitFactor()).compareTo(Double.valueOf(o1.profitFactor()));
            }
        });

        //voi incerca sa iau cat mai mult intr-un stil greedy
        double valoareTotala = 0;
        List<Item> listaSac = new ArrayList();
        for (Item i : itemsArray) {
            //cat timp mai pot lua
            if (capacitate - i.getWeight() >= 0) {
                capacitate = capacitate - i.getWeight(); //scad greutatea psibila pt urmatoarea iteratie

                valoareTotala += i.getValue();//adaug valoarea
                listaSac.add(i);
            } else { //ma opresc
                break;
            }

        }
        System.out.println("Valaore totala furata este" + valoareTotala);
        nouaLista = listaSac;
    }

}
