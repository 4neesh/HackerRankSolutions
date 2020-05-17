package com.aneesh.problemSolvingAndAlgorithms;

public class DrawingBook {

    //link to problem: https://www.hackerrank.com/challenges/drawing-book/problem


    public static int pageCount(int n, int p){

        int numberOfPages ;
        int pagesFromBackInt = Integer.MAX_VALUE;
        int pagesFromStart = p / 2;

        if(n % 2 == 0) {
            double pagesFromBack = (double) (n - p) / 2;
            System.out.println(pagesFromBack);

            pagesFromBackInt = (int) Math.round(pagesFromBack);
        }
        else {
            pagesFromBackInt = (n - p) /2;
        }
        numberOfPages = Math.min(pagesFromStart, pagesFromBackInt);

        return numberOfPages;
    }

    public static void main(String[] args) {

        System.out.println(pageCount(5,4));

    }
}
