package com.aneesh.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Test {

    public static void main(String[] args) {


        int[] a = {21, 1, 1, 5, 7, 7, 6, 5, 7};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : a) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }


        Map<Integer, Integer> sHashMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        for (int key : sHashMap.keySet()) {
            System.out.println(key + " " + sHashMap.get(key));
        }

    }}


