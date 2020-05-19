package com.aneesh.problemSolvingAndAlgorithms;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class PickingNumbers {

    //link to challenge: https://www.hackerrank.com/challenges/picking-numbers/problem

    public static int pickingNumbers(List<Integer> listOfValues) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i<listOfValues.size(); i++){

            if(hashMap.containsKey(listOfValues.get(i))){
                hashMap.compute(listOfValues.get(i), (c,d) -> d = d + 1);
            }
            else {
                hashMap.put(listOfValues.get(i), 1);
            }
        }


        listOfValues = listOfValues.stream().distinct().collect(Collectors.toList());

        int result = 0;
        for(int i = 0; i< listOfValues.size() - 1; i++){

            if (listOfValues.get(i) == listOfValues.get(i+1)+1 ){
                if(hashMap.get(i) + hashMap.get(i+1) > result){
                    result = hashMap.get(i) + hashMap.get(i+1);
                }
            }
            else{
                continue;
            }

        }

        
        return 7;
    }
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);

        System.out.println(pickingNumbers(list));

    }
}
