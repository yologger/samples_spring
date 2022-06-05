package com.yologger.app;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Integer[] array = {5, 1, 4, 3, 2};

        Arrays.sort(array, Collections.reverseOrder());

        System.out.println(Arrays.toString(array)); // [5, 4, 3, 2, 1]
    }
}