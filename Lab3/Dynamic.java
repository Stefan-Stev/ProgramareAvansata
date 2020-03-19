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
public class Dynamic implements Algoritm {

    private List<Item> listaObiecte;
    private int capacitate;
    private List<Item> listaNoua;

    public Dynamic(int capacitate, List<Item> listaObiecte) {
        this.listaObiecte = listaObiecte;
        this.capacitate = capacitate;
    }

    public List<Item> getListaObiecte() {
        return listaObiecte;
    }

    @Override
    public void rezolvare() {
        int[][] matrice = new int[listaObiecte.size() + 1][capacitate + 1];
        int[] greutati = new int[listaObiecte.size()];
        int[] valori = new int[listaObiecte.size()];
        List<Item> lista = new ArrayList<Item>(listaObiecte.size());
        int contor = 0;
        for (Item i : listaObiecte) {
            greutati[contor] = (int) i.getWeight();
            valori[contor] = (int) i.getValue();
            contor++;
        }
        
        boolean[] luat = new boolean[listaObiecte.size()];

        for (int i = 0; i <= listaObiecte.size(); i++) {
            for (int greutate = 0; greutate <= capacitate; greutate++) {
                if (i == 0 || greutate == 0) {
                    matrice[i][greutate] = 0;
                } else if (greutati[i - 1] <= greutate) {
                    // matrice[i][greutate]=Math.max(valori[i-1]+matrice[i-1][greutate-greutati[i-1]], matrice[i-1][greutate]);
                    if (valori[i - 1] + matrice[i - 1][greutate - greutati[i - 1]] >= matrice[i - 1][greutate]) {
                        matrice[i][greutate] = valori[i - 1] + matrice[i - 1][greutate - greutati[i - 1]];
                        luat[i - 1] = true;
                    } else {
                        matrice[i][greutate] = matrice[i - 1][greutate];
                    }
                } else {
                    matrice[i][greutate] = matrice[i - 1][greutate];
                }
            }
        }
        //System.out.println(lista.toString());
        /*for(int i=0;i<luat.length;i++)
         if(luat[i]==true)
         lista.add(listaObiecte.get(i));*/

        listaNoua = lista;
        System.out.println("Valoare furata este:");
        System.out.println(matrice[listaObiecte.size()][capacitate]);

    }

    @Override
    public List<Item> getNouaLista() {
        return listaNoua;
    }

}
