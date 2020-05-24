package com.aneesh.problemSolvingAndAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KFactorization {

    //link to problem: https://www.hackerrank.com/challenges/k-factorization/problem

    public static List<Integer> resultList = new ArrayList<>();
    public static int target;

    {
        resultList = new ArrayList<>();
    }


    static int[] kFactorization(Integer[] valuesArray){

        int resultTarget = target;
        Arrays.sort(valuesArray, Collections.reverseOrder());

        List<Integer> factorsToTarget = new ArrayList<>();
        factorsToTarget = populateFactorsOfTarget(factorsToTarget, valuesArray);

        recurseResults(factorsToTarget);

        int[] result = new int[resultList.size()+1];
        result = buildResultList(result, resultTarget);

        return result;

    }

    private static List<Integer> populateFactorsOfTarget(List<Integer> factorsToTarget, Integer[] valuesArray) {
        for(int i : valuesArray){
            if( target % i == 0){
                factorsToTarget.add(i);
            }
        }

        return factorsToTarget;
    }

    private static int[] buildResultList(int[] results, int resultTarget){
        Collections.sort(resultList);
        results[0] = 1;

        for (int i = 1; i<=resultList.size(); i++){
            results[i] = results[i-1] * resultList.get(i-1);
        }

        if( resultList.size() == 0 || (resultList.size() > 0 && results[resultList.size()] != resultTarget)){

            results = new int[1];
            results[0] = -1;

        }

        return results;
    }

    private static void recurseResults(List<Integer> factorsToTarget) {

        if(factorsToTarget.size() == 0 || checkEndGame()){
            return;
        }

        List<Integer> temporaryFactors = new ArrayList<>();

        if(target % factorsToTarget.get(0) == 0){

            resultList.add(factorsToTarget.get(0));
            target = target / factorsToTarget.get(0);

            repopulateFactorsForNewTarget(factorsToTarget, temporaryFactors);

            recurseResults(temporaryFactors);
        }
        else{

            repopulateFactorsForNewTarget(factorsToTarget, temporaryFactors);

            recurseResults(temporaryFactors);
        }


    }

    private static void repopulateFactorsForNewTarget(
            List<Integer> factorsToTarget, List<Integer> temporaryFactors) {

        for(int i : factorsToTarget){
            if(target % i == 0) {
                temporaryFactors.add(i);
            }
        }
    }

    private static boolean checkEndGame() {

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

    public static void setTarget(int targetInt){
        target = targetInt;
    }


    public int[] getResult(Integer[] valuesArray, int target){

        setTarget(target);
        return kFactorization(valuesArray);
    }

}
