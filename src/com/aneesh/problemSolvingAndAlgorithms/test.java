package com.aneesh.problemSolvingAndAlgorithms;

public class test {


    public static void main(String[] args) {

        int[][] matrix = {{10,10}, {3,4}};
        int[] a = {10,110};

        for (int[] i: matrix){
            if (i[0] == a[0] && i[1] == a[1]){
                System.out.println("got it");
            }
        }
    }
}
