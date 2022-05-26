package com.yologger.app;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<Integer>();

        hashSet.add(7);
        hashSet.add(90);
        hashSet.add(15);
        hashSet.add(10);
        hashSet.add(6);
        hashSet.add(60);
        hashSet.add(1);

        System.out.println(hashSet);    // [1, 6, 7, 90, 10, 60, 15]
        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(7);
        treeSet.add(90);
        treeSet.add(15);
        treeSet.add(10);
        treeSet.add(6);
        treeSet.add(60);
        treeSet.add(1);

        System.out.println(treeSet);    // [1, 6, 7, 10, 15, 60, 90]

        Map

    }
}