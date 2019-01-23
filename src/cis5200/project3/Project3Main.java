package cis5200.project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CIS5200-W01
 * Project 3, Problem 20.8 + Additional Instructions
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project3Main {

    public static void main(String[] args) {
        Pair pair1 = new Pair(3.2, 2.1);
        Pair pair2 = new Pair(10.5, 12.2);
        Pair pair3 = new Pair(0.2, 0.2);
        Pair pair4 = new Pair(50.5, 30.0);
        Pair pair5 = new Pair(7.6, 24.5);

        List<Pair> pairList = new ArrayList<>();
        pairList.add(pair1);
        pairList.add(pair2);
        pairList.add(pair3);
        pairList.add(pair4);
        pairList.add(pair5);
        
        System.out.printf("Before sort: %s%n", pairList);

        Collections.sort(pairList, Pair.createComparator());
        
        System.out.printf("After sort: %s%n", pairList);
    }
}
