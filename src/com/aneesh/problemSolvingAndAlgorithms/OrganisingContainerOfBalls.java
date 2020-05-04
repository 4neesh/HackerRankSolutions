package com.aneesh.problemSolvingAndAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class OrganisingContainerOfBalls {

    //link to challenge: https://www.hackerrank.com/challenges/organizing-containers-of-balls

    static String organizingContainers(int[][] container) {

        //Time Complexity = O(n + m)

        List<Integer> tableSizes = new ArrayList<>();
        List<Integer> ballNumbers = new LinkedList<>();

        for (int a = 0; a < container.length; a++){
            ballNumbers.add(0);
        }

     for (int j = 0; j< container.length; j++) {

         int[] Queries = container[j];
         int sum = 0;
         for (int i = 0; i< container.length; i++) {
             ballNumbers.set(i,ballNumbers.get(i) + Queries[i]);
             sum = sum + Queries[i];
         }
         tableSizes.add(sum);
     }

        tableSizes.sort((a,b) -> a.compareTo(b));
        ballNumbers.sort(Comparator.naturalOrder());
        String result = "Impossible";

        if(tableSizes.equals(ballNumbers)){
            result = "Possible";
        }

        return result;

    }


    public static void main(String[] args) {



        int[][] a = {{3,1,0},{0,2,1}, {1,0,3}};
        System.out.println(organizingContainers(a));

    }
}
