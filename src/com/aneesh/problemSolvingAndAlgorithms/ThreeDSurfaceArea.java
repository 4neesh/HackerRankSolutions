package com.aneesh.problemSolvingAndAlgorithms;

public class ThreeDSurfaceArea {

    //link to challenge: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

    public static boolean twoDArray = false;
    public static int[][] toySurfaceAreaArray = {{}};
    public static int numberOfRows = 0;
    public static int numberOfColumns = 0;
    public static int totalSurfaceArea = 0;
    public static int numberOfCubes = 0;
    public static int outerCount = 0;
    public static int innerCount = 0;
    public static int topBottomCounter = 0;

    public static int surfaceArea(int[][] toyAreaArray) {

        toySurfaceAreaArray = toyAreaArray;
        numberOfRows = toySurfaceAreaArray[0].length;
        numberOfColumns = toySurfaceAreaArray.length;

        if (singleStackOfBlocks()) {
            return 2 + (toySurfaceAreaArray[0][0] * 4);
        } else if (singleLineOfCubes()) {
            twoDArray = true;
        }

        for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
            for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {

                calculateInnerSurfaceArea(columnNumber,rowNumber);

                if (cubeOnOuter(columnNumber, rowNumber)) {
                    calculateOuterSurfaceArea(columnNumber,rowNumber);

                } else {
                    numberOfCubes++;
                }
            }
        }

        topBottomCounter = numberOfCubes * 2;
        System.out.println("Inner area: " + innerCount);
        System.out.println("Outer area:" + outerCount);
        System.out.println("Top and Bottom area: " + topBottomCounter);
        totalSurfaceArea = totalSurfaceArea + topBottomCounter + outerCount + innerCount;

        return totalSurfaceArea;
    }

    private static void calculateOuterSurfaceArea(int i, int j) {
        if (cubeIsEdge(i, j)) {
            outerCount = outerCount + toySurfaceAreaArray[i][j] + toySurfaceAreaArray[i][j];
            if (twoDArray) {
                outerCount = outerCount + toySurfaceAreaArray[i][j];
            }
            numberOfCubes++;
        } else {
            outerCount = outerCount + toySurfaceAreaArray[i][j];
            numberOfCubes++;
            if (twoDArray) {
                outerCount = outerCount + toySurfaceAreaArray[i][j];
            }
        }
    }

    private static void calculateInnerSurfaceArea(int i, int j) {
        if (j != 0 && numberOfRows > 1) {
            innerCount = innerCount + Math.abs(toySurfaceAreaArray[i][j] - toySurfaceAreaArray[i][j - 1]);
        }
        if (i != 0 && numberOfColumns > 1) {
            innerCount = innerCount + Math.abs(toySurfaceAreaArray[i][j] - toySurfaceAreaArray[i - 1][j]);
        }
    }

    private static boolean singleLineOfCubes() {
        boolean singleLine = false;
        if (numberOfRows == 1 || numberOfColumns == 1) {
            singleLine = true;
        }
        return singleLine;
    }

    private static boolean singleStackOfBlocks() {
        boolean singleStack = false;
        if (numberOfRows == 1 && numberOfColumns == 1) {
            singleStack = true;
        }
        return singleStack;
    }

    private static boolean cubeIsEdge(int i, int j) {
        boolean cubeIsOnEdge = false;
        if (twoDArray) {
            if (i == 0 && j == 0
                    || toySurfaceAreaArray.length - 1 > toySurfaceAreaArray[0].length && i == toySurfaceAreaArray.length - 1
                    || toySurfaceAreaArray[0].length > toySurfaceAreaArray.length - 1 && j == toySurfaceAreaArray[0].length - 1
            ) {
                cubeIsOnEdge = true;
            }
        } else {
            if (i == 0 && j == 0
                    || i == toySurfaceAreaArray.length - 1 && j == 0
                    || i == 0 && j == (toySurfaceAreaArray[0].length - 1)
                    || i == toySurfaceAreaArray.length - 1 && j == (toySurfaceAreaArray[0].length - 1)) {
                System.out.println(i + " " + j);
                cubeIsOnEdge = true;
            }

        }
        return cubeIsOnEdge;
    }

    private static boolean cubeOnOuter(int i, int j) {
        boolean cubeIsOnOuter = false;
        if (i == 0 || i == toySurfaceAreaArray.length - 1 || j == 0 || j == (toySurfaceAreaArray[0].length - 1)) {
            cubeIsOnOuter = true;
        }
        return cubeIsOnOuter;
    }

    public static void main(String[] args) {

        int[][] A = {{1, 1, 2}, {1, 2, 3}};
        int surfaceArea = surfaceArea(A);
        System.out.println(surfaceArea);
        
    }
}
