package com.aneesh.problemSolvingAndAlgorithms;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class PickingNumbers {

    //link to challenge: https://www.hackerrank.com/challenges/picking-numbers/problem

    private static HashMap<Integer, Integer> hashMap;
    private static List<Integer> listOfValues;
    private static int keyWithHighestValue = 0;
    private static  List<Integer> sortedKeySet;
    private static List<List<Integer>> listOfPairedKeys;
    private static int maxPairs = 0;
    public static int pickingNumbers(List<Integer> listOfValues) {

        populateHashMapWithOccurence();

        identifyListOfKeyPairs();

        if(sortedKeySet.size() == 1){
            return listOfValues.size();
        }

        keyWithHighestValue = hashMap.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();

        calculateMaxPairValue();

        maxPairs = keyWithHighestValue > maxPairs ? keyWithHighestValue : maxPairs;

        return maxPairs;
    }

    private static void calculateMaxPairValue() {
        for (List<Integer> list : listOfPairedKeys){
            int numberOfPairs = 0;
            numberOfPairs = numberOfPairs +  hashMap.get(list.get(0));
            numberOfPairs = numberOfPairs +  hashMap.get(list.get(1));
            maxPairs = numberOfPairs > maxPairs ? numberOfPairs : maxPairs;
        }
    }

    private static void identifyListOfKeyPairs() {

        sortedKeySet = hashMap.keySet().stream().sorted().collect(Collectors.toList());
        listOfPairedKeys = new ArrayList<>();

        for (int i = 0; i< sortedKeySet.size() - 1; i++){
            if(sortedKeySet.get(i) == sortedKeySet.get(i + 1) -1 ){
                List<Integer> pairedEntry = new ArrayList<>();
                pairedEntry.add(sortedKeySet.get(i));
                pairedEntry.add(sortedKeySet.get(i + 1));
                listOfPairedKeys.add(pairedEntry);
            }
        }

    }

    private static void populateHashMapWithOccurence() {

        hashMap = new HashMap<>();

        for(int i = 0; i<listOfValues.size(); i++){

            if(hashMap.containsKey(listOfValues.get(i))){
                hashMap.compute(listOfValues.get(i), (c,d) -> d = d + 1);
            }
            else {
                hashMap.put(listOfValues.get(i), 1);
            }
        }
    }

    public static void main(String[] args) {


        listOfValues = new ArrayList<>();
        listOfValues .add(1);
        listOfValues .add(2);
        listOfValues .add(2);
        listOfValues .add(3);
        listOfValues .add(1);
        listOfValues .add(2);
        System.out.println(pickingNumbers(listOfValues ));

    }
}
