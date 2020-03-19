/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author stefan
 */
public class KnapsackGenerator {

    private int capacity;
    private int nrObiecte;
    private List<Item> listaObiecte;

    private enum itemEnum {

        Book, Food, Weapon;

        public static itemEnum getRandomItem() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

    }

    public int getCapacity() {
        return capacity;
    }

    public List<Item> getListaObiecte() {
        return listaObiecte;
    }

    KnapsackGenerator() {
        Random rand = new Random();
        capacity = rand.nextInt(4000);
        nrObiecte = rand.nextInt(2000);
        List<Item> lista = new ArrayList<Item>();
        for (int i = 0; i < nrObiecte; i++) {

            Item item = new Food("Food" + i, rand.nextInt(100), rand.nextInt(100));
            lista.add(item);
        }

        listaObiecte = lista;
        ;

    }

    public void rezolvare() {
        System.out.println("-----------------Testare cele doua metode");
        System.out.println("Greedy");

        // long startTime=System.nanoTime();
        Algoritm rezolvare1 = new Greedy(capacity, listaObiecte);
        rezolvare1.rezolvare();
        //long endTime=System.nanoTime();
        //long seconds=TimeUnit.NANOSECONDS.toSeconds((endTime-startTime));
        //System.out.println(seconds);
        System.out.println("Dinamic");

        //startTime=System.nanoTime();
        Algoritm rezolvare2 = new Dynamic(capacity, listaObiecte);

        rezolvare2.rezolvare();
        // endTime=System.nanoTime();
        // System.out.println(TimeUnit.NANOSECONDS.toSeconds(endTime-startTime));
    }

}
