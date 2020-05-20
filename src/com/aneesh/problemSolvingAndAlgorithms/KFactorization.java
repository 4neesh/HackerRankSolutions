package com.aneesh.problemSolvingAndAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class KFactorization {

    //link to problem: https://www.hackerrank.com/challenges/k-factorization/problem


    static int[] kFactorization(int target, int[] values){

        int[] result = {0};


        //eliminate values that don't go into target
        List<Integer> factorsToTarget = new ArrayList<>();
        for(int i : values){
            if( target % i == 0){
                factorsToTarget.add(i);
            }
        }

        System.out.println(factorsToTarget);
        //find all combinations
        //use greedy algorithm to find the value



        //find lexicographical one




        //array has the same number as the size of lexicographical size


        //return it
        return result;


    }
    public static void main(String[] args) {

        int[] values = {2,4,6,9,3,7,16,10,5};
        kFactorization(72, values);
        

    }


}
