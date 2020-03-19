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
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WeaponType type1 = WeaponType.Sword;
        // cree itemele
        Item item1 = new Weapon(type1, 10, 60);
        //System.out.println(item1.getName());
        Item item2 = new Food("Rabbit", 20, 100);
        Item item3 = new Food("Cabbage", 30, 120);
        Item item4 = new Book("A blade in the Dark", 3, 5);
        Item item5 = new Book("Dragon Rising", 3, 5);
        Item item6 = new Book("Jamson", 5, 12);
        Item item7 = new Book("Benjamin", 6, 18);
        //pun itemele intr-un sac
        List<Item> listaItems = new ArrayList<Item>();
        listaItems.add(item1);
        listaItems.add(item2);
        listaItems.add(item3);
        listaItems.add(item4);
        listaItems.add(item5);
        listaItems.add(item6);
        listaItems.add(item7);
        //aplic algoritmul greedy
        Algoritm rezolvare1 = new Greedy(50, listaItems);
        rezolvare1.rezolvare();

        Knapsack sac = new Knapsack(50, rezolvare1.getNouaLista());
        //afisez rezultatul dupa procesarea algoritmului greedy si afisez castgiul maxim
        System.out.println("Sacul arata asa:");
        System.out.println(sac.toString1());
        //aplica algoritmul de programare dinamica
        Algoritm rezolvare2 = new Dynamic(50, listaItems);
        rezolvare2.rezolvare();
        Knapsack sac2 = new Knapsack(50, rezolvare2.getNouaLista());
        //realizez un sac cu iteme generate random unde aplic cei doi algoritmi
        KnapsackGenerator saculet = new KnapsackGenerator();
        saculet.rezolvare();
    }

}
