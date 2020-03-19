/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residents.hospitals;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static sun.java2d.cmm.ColorTransform.In;

/**
 *
 * @author stefan
 */
public class ResidentsHospitals {
    //private static Object[] IntSTream;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Resident> residentList = new ArrayList<>();
        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);

        residentList.addAll(Arrays.asList(r));
        Set<Hospital> setHospitals = new TreeSet<Hospital>();

        Hospital[] h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);
        setHospitals.addAll(Arrays.asList(h));
        //setHospitals.addAll(Arrays.asList(h));

        Collections.sort(residentList, Comparator.comparing(Resident::getName));
        Map<Resident, List<Hospital>> resPref = new HashMap<>();
        resPref.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPref.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPref.put(r[2], Arrays.asList(h[0], h[1]));
        resPref.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> PrefHosp = new TreeMap<>();
        PrefHosp.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        PrefHosp.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        PrefHosp.put(h[2], Arrays.asList(r[0], r[1], r[3]));
        Partition algoritm = new Partition(resPref, PrefHosp, residentList, new ArrayList<Hospital>(setHospitals), Arrays.asList(1, 2, 2));

        //folosesc algoritul Gale Shapley 
        List<MatchingStable> list = algoritm.algoritm();
        System.out.println("Algoritmul Gale Shapley" + list);

        System.out.println("-----------------------");
        System.out.println("");

        System.out.println("Algoritmul First Come First Served");
        Partition algoritm2 = new Partition(resPref, PrefHosp, residentList, new ArrayList<Hospital>(setHospitals), Arrays.asList(1, 2, 2));
        List<MatchingStable> list2 = algoritm2.firsComeFirstServed();
        System.out.println(list2);

        System.out.println("-----------------------");
        residentList.stream().filter(res -> resPref.get(res).contains(h[0]))
                .forEach(System.out::println);
        residentList.stream().filter(res -> resPref.get(res).contains(h[2]))
                .forEach(System.out::println);
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        List<Resident> result = residentList.stream()
                .filter(res -> resPref.get(res).containsAll(target))
                .collect(Collectors.toList());
        System.out.println(result.toString());
        List<Hospital> listPrim = new ArrayList<>();

        listPrim = setHospitals.stream()
                .filter(hos -> PrefHosp.get(hos).get(0) == r[0])
                .collect(Collectors.toList());
        System.out.println(list.toString());

        System.out.println("-----------Generare instante fake--------");
        Problem problem = new Problem();
        problem.generareInsanteFake();

    }

}
