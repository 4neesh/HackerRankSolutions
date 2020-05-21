package com.aneesh.problemSolvingAndAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KFactorization {

        //link to problem: https://www.hackerrank.com/challenges/k-factorization/problem

        public static List<Integer> resultList = new ArrayList<>();
        public static int target;
        static int[] kFactorization(Integer[] values){

        int resultTarget = target;
        Arrays.sort(values, Collections.reverseOrder());

        List<Integer> factorsToTarget = new ArrayList<>();
        for(int i : values){
            if( target % i == 0){
                factorsToTarget.add(i);
            }
        }

        recurseResults(factorsToTarget);

        Collections.sort(resultList);

        int[] result = new int[resultList.size()+1];
        result[0] = 1;
        for (int i = 1; i<=resultList.size(); i++){
            result[i] = result[i-1] * resultList.get(i-1);
        }

        if( resultList.size() == 0 || (resultList.size() > 0 && result[resultList.size()] != resultTarget)){
            System.out.println("SIZE: " + resultList.size());
            System.out.println("FAIL" + result[resultList.size()]);
            result = new int[1];
            result[0] = -1;
        }

        return result;

    }

    private static void recurseResults(List<Integer> factorsToTarget) {

        if(factorsToTarget.size() == 0 || resultListEquals()){
            return;
        }
        List<Integer> temporaryFactors = new ArrayList<>();
        for(int i = 1; i< factorsToTarget.size(); i++){
            temporaryFactors.add(factorsToTarget.get(i));
        }

        if(target % factorsToTarget.get(0) == 0){

            resultList.add(factorsToTarget.get(0));
            target = target / factorsToTarget.get(0);
            recurseResults(temporaryFactors);
        }
        else{

            recurseResults(temporaryFactors);
        }


    }

    private static boolean resultListEquals() {

        int resultListValue = 1;
        for(int i : resultList){
            resultListValue = resultListValue * i;
        }

        if(resultListValue == target){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {

        Integer[] values = {2,3,4};
        target = 12;
        int[] resulter = kFactorization(values);
        for(int y : resulter){
            System.out.println(y);

        }

    }


}
