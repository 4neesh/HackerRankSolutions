package com.aneesh.problemSolvingAndAlgorithms;

import java.util.*;

//link to challenge: https://www.hackerrank.com/challenges/magic-square-forming/problem
public class MagicSquare {


    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        List<Integer> sAsList = Arrays.asList(s[0][0], s[0][1], s[0][2], s[1][0],s[1][1], s[1][2], s[2][0], s[2][1], s[2][2]);

        List<Integer> sol1 = Arrays.asList(4,9,2,3,5,7,8,1,6);
        List<Integer> sol2 = Arrays.asList(8,3,4,1,5,9,6,7,2);
        List<Integer> sol3 = Arrays.asList(4,3,8,9,5,1,2,7,6);
        List<Integer> sol4 = Arrays.asList(8,1,6,3,5,7,4,9,2);
        List<Integer> sol5 = Arrays.asList(2,9,4,7,5,3,6,1,8);
        List<Integer> sol6 = Arrays.asList(6,1,8,7,5,3,2,9,4);
        List<Integer> sol7 = Arrays.asList(2,7,6,9,5,1,4,3,8);
        List<Integer> sol8 = Arrays.asList(6,7,2,1,5,9,8,3,4);

        List<List<Integer>> optimalMatrices = Arrays.asList(sol1, sol2, sol3, sol4, sol5, sol6, sol7, sol8);

        List<Integer> costToChange = new ArrayList<>();
        int cost = 0;

        for(int ii = 0; ii<8; ii++) {
            cost = 0;
            for (int i = 0; i< 9; i++){
                if(sAsList.get(i) != optimalMatrices.get(ii).get(i)){
                    cost =
                            cost + Math.abs(sAsList.get(i) - optimalMatrices.get(ii).get(i));
                }

            }
            costToChange.add(cost);

        }
        Collections.sort(costToChange);
        System.out.println("costs:  " + costToChange);

        int x = costToChange.get(0);
        return x;

    }


    public static void main(String[] args) {

        int[][] s = new int[3][3];

        /**Update the values of the original square below*/
        s[0][0] = 7;
        s[0][1] = 2;
        s[0][2] = 9;
        s[1][0] = 6;
        s[1][1] = 6;
        s[1][2] = 2;
        s[2][0] = 5;
        s[2][1] = 1;
        s[2][2] = 2;


        int result = formingMagicSquare(s);
        System.out.println("final result: " + result);

    }
}

