package com.aneesh.problemSolvingAndAlgorithms;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class PickingNumbers {

    //link to challenge: https://www.hackerrank.com/challenges/picking-numbers/problem

    public static int pickingNumbers(List<Integer> a) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        a = a.stream().sorted().collect(Collectors.toList());

        for(int i = 0; i<a.size(); i++){

            if(hmap.containsKey(a.get(i))){
                hmap.compute(a.get(i), (c,d) -> d = d + 1);
            }
            else {
                hmap.put(a.get(i), 1);
            }
        }

        a = a.stream().distinct().collect(Collectors.toList());
        int result = 0;
        for(int i = 0; i< a.size() - 1; i++){

            if (a.get(i) == a.get(i+1)+1 ){
                if(hmap.get(i) + hmap.get(i+1) > result){
                    result = hmap.get(i) + hmap.get(i+1);
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
