package com.aneesh.problemSolvingAndAlgorithms;

import java.io.IOException;
import java.util.*;

class NonDivSubset {

    //link to challenge: https://www.hackerrank.com/challenges/non-divisible-subset/problem

    public static int nonDivisibleSubset(int divisor, List<Integer> valueList) {

        //obtain a count of all remainders within the list
        int[] remainderArray = new int[divisor]; //for k=3, = [0],[1],[2]
        populateRemainderArray(valueList,remainderArray,divisor);
        int equallyDivisibleOccurrences = remainderArray[0];

        int nonDivisibleResult = (remainderArray[0] > 0) ? 1 : 0; //set result if
        int halfOfDivisor = (divisor%2 == 0) ? (divisor/2)-1 : divisor/2;


        if(equallyDivisibleOccurrences == valueList.size()){
            return 1;
        }
        else{
            for(int i = 1; i<= halfOfDivisor; i++){

                int numberOfCases = Math.max(remainderArray[i], remainderArray[divisor-i]);
                nonDivisibleResult += numberOfCases;
            }
        }

        if(divisor%2 ==0 && remainderArray[divisor/2] > 0){
            nonDivisibleResult += 1;
        }

    return nonDivisibleResult;

    }

    private static void populateRemainderArray(List<Integer> list, int[] remainderArray, int divisor){
        for (int value : list){
            remainderArray[value % divisor]++;
        }
    }
}



public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        int k = 1;
        List<Integer> s = Arrays.asList(3,6,8);
        int result = NonDivSubset.nonDivisibleSubset(k, s);
        System.out.println("result = "  + result);

    }
}



