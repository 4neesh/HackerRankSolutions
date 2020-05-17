package com.aneesh.problemSolvingAndAlgorithms;

import java.util.HashSet;

public class ComparingTwoArrays {


    public static void main(String[] args) {

        int[] A = {1,4,12,14,9,7,10};
        int[]B = {5,8,1,2,12,10,7};

        System.out.println(numberOfMatches(A, B));
    }

    private static int numberOfMatches(int[] a, int[] b) {

        int numberOfMatches = 0;
        HashSet<Integer> bHashSet = new HashSet();

        //convert b into a hashset
        for (int bInt : b){
            bHashSet.add(bInt);
        }

        for(int aInt : a){
            if(!bHashSet.add(aInt)){
                numberOfMatches++;
            }
        }

        return numberOfMatches;
    }
}
