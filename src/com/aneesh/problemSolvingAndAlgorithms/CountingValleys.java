package com.aneesh.problemSolvingAndAlgorithms;

public class CountingValleys {

    //link to problem: https://www.hackerrank.com/challenges/counting-valleys/problem

    static int countingValleys(int n, String s) {

        int valleys = 0;
        int accumulativeLevel = 0;

        for(char c : s.toCharArray()){

            if(c == 'D'){
                accumulativeLevel = accumulativeLevel -1;
            }
            else{
                accumulativeLevel = accumulativeLevel + 1;
            }

            if(c == 'U' && accumulativeLevel == 0){
                valleys++;
            }
        }

        return valleys;
    }


    public static void main(String[] args) {

        String stepsTaken = "UDDDUDUU";
        int steps = stepsTaken.length();


        int valleys = countingValleys(steps, stepsTaken);
        System.out.println(valleys);

    }
}
