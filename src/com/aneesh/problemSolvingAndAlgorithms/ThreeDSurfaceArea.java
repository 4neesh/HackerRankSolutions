package com.aneesh.problemSolvingAndAlgorithms;

public class ThreeDSurfaceArea {
    public static boolean twoDArray = false;

    static int surfaceArea(int[][] A){

        int numberOfRows = A[0].length;
        int numberOfColumns = A.length;

        int totalSurfaceArea = 0;
        int numberOfCubes = 0;
        int outerCount = 0;
        int innerCount = 0;
        if(numberOfRows == 1 && numberOfColumns == 1){
            return 6;
        }else if(numberOfRows == 1 || numberOfColumns == 1){
            twoDArray = true;
        }

            for (int i = 0; i < numberOfColumns; i++) {
                for (int j = 0; j < numberOfRows; j++) {

                    if (j != 0 && numberOfRows > 1) {
                        innerCount = innerCount + Math.abs(A[i][j] - A[i][j - 1]);
                    }
                    if (i != 0 && numberOfColumns > 1) {
                        innerCount = innerCount + Math.abs(A[i][j] - A[i - 1][j]);
                    }
                    //if outer, add to outer
                    if (cubeOnOuter(i, j, A)) {
                        if (cubeIsEdge(i, j, A)) {
                            outerCount = outerCount + A[i][j] + A[i][j];
                            if(twoDArray){
                                outerCount = outerCount + A[i][j];
                            }
                            numberOfCubes++;
                        } else {
                            outerCount = outerCount + A[i][j];
                            numberOfCubes++;
                            if(twoDArray){
                                outerCount = outerCount + A[i][j];
                            }
                        }
                    } else {
                        //cube is inner
                        numberOfCubes++;
                    }
                }
            }



        //use accumulated counter to account for top and bottom
        int topBottomCounter = numberOfCubes * 2;
        System.out.println("inner: " + innerCount);
        System.out.println("outer:" + outerCount);
        System.out.println("topbot: " + topBottomCounter);
//        System.out.println(topBottomCounter);
        totalSurfaceArea = totalSurfaceArea + topBottomCounter + outerCount + innerCount;

        return totalSurfaceArea;
    }

    private static boolean cubeIsEdge(int i, int j, int[][] A) {
        boolean cubeIsOnEdge = false;
        if (twoDArray) {
            if(i == 0 && j == 0
                || A.length-1 > A[0].length && i == A.length -1
                || A[0].length > A.length && j == A[0].length
            ){
                System.out.println("got an edge: " + A[i][j]);
                System.out.println("i = " + i + " j =  " + j);
                cubeIsOnEdge = true;
            }

            return cubeIsOnEdge;
        } else {
            if (i == 0 && j == 0
                    || i == A[0].length && j == 0
                    || i == 0 && j == (A.length - 1)
                    || i == A[0].length && j == (A.length - 1)) {

                cubeIsOnEdge = true;
            }

        }
        return cubeIsOnEdge;
    }

    private static boolean cubeOnOuter(int i, int j, int[][] A) {
        boolean cubeIsOnOuter = false;
        if(i == 0 || i == A[0].length-1 || j == 0 || j == (A.length - 1)){
            cubeIsOnOuter = true;
        }
        return cubeIsOnOuter;
    }

    public static void main(String[] args) {

        int[][] A = {{1,3,4},{2,2,3},{1,2,4}};
        int surfaceArea = surfaceArea(A);
        System.out.println(surfaceArea);
    }
}
