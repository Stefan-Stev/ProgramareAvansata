/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residents.hospitals;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author stefan
 */
public class Problem {

    public void generareInsanteFake() {
        Random random = new Random();
        int contorRezidenti = random.nextInt(10);
        int contorSpitale = random.nextInt(10);
        List<Resident> listaRezidenti = new ArrayList<>();
        List<Hospital> listaHospitals = new ArrayList<>();
        for (int i = 0; i < contorRezidenti; i++) {
            Faker faker = new Faker();
            String nume = faker.name().fullName();
            Resident r = new Resident(nume);
            listaRezidenti.add(r);

        }
        for (int j = 0; j < contorSpitale; j++) {
            Faker faker = new Faker();
            String nume = faker.company().industry();
            Hospital h = new Hospital(nume);
            listaHospitals.add(h);
        }
        Map<Resident, List<Hospital>> resPref = new HashMap<>(); //aici se afla preferintele rezidentilor 
        Map<Hospital, List<Resident>> hosPref = new HashMap<>(); //aici se afla preferintele spitalelor 

        //pun intr-un map preferintele rezindetilor
        for (Resident r : listaRezidenti) {
            int contorPreferinteSpitale = random.nextInt(10);
            for (int i = 0; i < contorPreferinteSpitale; i++) {
                //rezidentiAsignatiLaHospital.computeIfAbsent(h, k -> new ArrayList<>()).add(entry.getKey());//
                resPref.computeIfAbsent(r, k -> new ArrayList<>()).add(listaHospitals.get(random.nextInt(listaHospitals.size())));
            }
        }
        
        
        //pun intr-un map preferintele spitalelor
        for (Hospital h : listaHospitals) {
            int contorPreferinteSpitale = random.nextInt(10);
            for (int i = 0; i < contorPreferinteSpitale; i++) {
                //rezidentiAsignatiLaHospital.computeIfAbsent(h, k -> new ArrayList<>()).add(entry.getKey());//
                hosPref.computeIfAbsent(h, k -> new ArrayList<>()).add(listaRezidenti.get(random.nextInt(contorRezidenti)));
            }
        }
        
        //capacitatile spitalelor
        List<Integer> listaCapacitati = new ArrayList<>();
        for (int j = 0; j < contorSpitale; j++) {
            listaCapacitati.add(random.nextInt(10));
        }
       // System.out.println(resPref);
        // System.out.println(hosPref);

        Partition algoritm2 = new Partition(resPref, hosPref, listaRezidenti, listaHospitals, listaCapacitati);
        List<MatchingStable> list2 = algoritm2.firsComeFirstServed();
        System.out.println(list2);

    }

}
