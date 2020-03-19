/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residents.hospitals;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 *
 * @author stefan
 */
public class Partition {

    private Map<Resident, List<Hospital>> resPref;   //preferintele rezidentilor asupra spitalelor
    private Map<Hospital, List<Resident>> hosPref;    //preferintele spitalelor asupra rezidentilor
    private List<Resident> listaResidenti;
    private List<Hospital> listaHospitals;

    public Partition(Map<Resident, List<Hospital>> resPref, Map<Hospital, List<Resident>> hosPref, List<Resident> listaResidenti, List<Hospital> listaHospitals, List<Integer> capacitati) {
        this.resPref = resPref;
        this.hosPref = hosPref;
        this.listaResidenti = listaResidenti;
        this.listaHospitals = listaHospitals;
        this.capacitati = capacitati;
    }

    private List<Integer> capacitati;

    public Boolean checking(Map<Resident, Boolean> checked) {
        for (Map.Entry<Resident, Boolean> entry : checked.entrySet()) {
            if (entry.getValue() == FALSE) {
                return FALSE;
            }
        }
        return TRUE;
    }

    public List<MatchingStable> algoritm() {
        List<MatchingStable> rezultat = new ArrayList<>();
        Map<Resident, Boolean> matched = new TreeMap<>();
        Collections.sort(this.listaResidenti);
        for (Resident r : listaResidenti) //am pus aici  validare daca rezidentul este asignat sau nu
        {
            matched.put(r, FALSE);
        }
        Map<Hospital, Integer> capacitatiHos = new HashMap<>();   // fiecare spital vine cu o valoare numita capacitate
        HashMap<Hospital, List<Resident>> rezidentiAsignatiLaHospital = new HashMap<Hospital, List<Resident>>();
        for (int i = 0; i < listaHospitals.size(); i++) {
            capacitatiHos.put(listaHospitals.get(i), capacitati.get(i));
        }

        while (!checking(matched)) // atata timp cat mai avem residenti ce nu au fost asignati la niciun spital
        {
            for (Map.Entry<Resident, Boolean> entry : matched.entrySet()) //pt fiecare resident
            {
                if (entry.getValue() == FALSE) // daca nu a fost asignat
                {
                    //System.out.println(entry.toString());
                    List<Hospital> listaValues = resPref.get(entry.getKey());
                    for (Hospital h : listaValues) // se ia fiecare hospital in parte din lista de preferinte a rezidentului
                    {

                        if (hosPref.get(h).contains(entry.getKey()) && capacitatiHos.get(h) != 0) //se verifica daca acel hospital are ca si preferinte rezidentul respectiv si daca mai are capacitate
                        {
                            matched.computeIfPresent(entry.getKey(), (k, v) -> TRUE); // rezdentul respectiva nu mai are match
                            rezultat.add(new MatchingStable(entry.getKey(), h)); //pun noul matching
                            capacitatiHos.computeIfPresent(h, (k, v) -> v - 1); //scad capacitatea hospitalului
                            rezidentiAsignatiLaHospital.computeIfAbsent(h, k -> new ArrayList<>()).add(entry.getKey());//am adaugat rezidentul la lista preferintelor spitalelor (lista dinamica)
                            break;
                        } else if (hosPref.get(h).contains(entry.getKey()) && capacitatiHos.get(h) == 0) ///verificam daca nu cumva putem scoate rezultat un matching mai prost decat acesta actual
                        {
                            int indexOfResident = hosPref.get(h).indexOf(entry.getKey());
                            int maxim = 0;

                            int indexOfThisResident = 0;
                            int jprim = 0;
                            for (int j = 0; j < rezidentiAsignatiLaHospital.get(h).size(); j++) {
                                indexOfThisResident = hosPref.get(h).indexOf(rezidentiAsignatiLaHospital.get(h).get(j));
                                if (indexOfThisResident > maxim) {
                                    maxim = indexOfThisResident;
                                    jprim = j;
                                }
                            }
                            if (indexOfResident < maxim) //am gasit un match mai bun decat unul acltual, actual este sters si pus acesta mai bun
                            {
                                Resident r = rezidentiAsignatiLaHospital.get(h).get(jprim);
                                matched.computeIfPresent(r, (k, v) -> FALSE);
                                rezidentiAsignatiLaHospital.get(h).remove(jprim);
                                rezidentiAsignatiLaHospital.computeIfAbsent(h, k -> new ArrayList<>()).add(entry.getKey());
                                rezultat.remove(new MatchingStable(r, h));
                                rezultat.add(new MatchingStable(entry.getKey(), h));
                                matched.computeIfPresent(entry.getKey(), (k, v) -> TRUE); // rezdentul respectiva nu mai are match
                                break;
                            }

                        }

                    }
                }

            }
        }
        return rezultat;
    }

    public List<MatchingStable> firsComeFirstServed() {
        List<MatchingStable> lista = new ArrayList<>();
        Map<Hospital, Integer> capacitatiHos = new HashMap<>();
        for (int i = 0; i < listaHospitals.size(); i++) {
            capacitatiHos.put(listaHospitals.get(i), capacitati.get(i));
        }

        for (Map.Entry<Resident, List<Hospital>> entry : resPref.entrySet()) {
            for (Hospital h : entry.getValue()) {
                //iau cate un rezident pe rand si aleg pentru fiecare greedy( care spital ii place cel mai mult si il asociez daca mai sunt locuri libere
                if (hosPref.get(h).contains(entry.getKey()) && capacitatiHos.get(h) != 0) { //trebuie sa verific daca si spitalul il accepta
                    lista.add(new MatchingStable(entry.getKey(), h));
                    capacitatiHos.computeIfPresent(h, (k, v) -> v - 1);
                    break;
                }

            }

        }
        return lista;
    }
}
