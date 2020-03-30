package com.aneesh.problemSolvingAndAlgorithms;
import java.io.*;
import java.util.*;

public class QueensAttackII {

        // Complete the queensAttack function below.
        static int queensAttack(int boardSize, int numberOfObstacles, int queen_x, int queen_y, int[][] obstacles) {

            boolean isQueenOnEdge = queen_x == 1  || queen_x == boardSize || queen_y == 1 || queen_y == boardSize;
            int maxMovesWithoutObstacles = findMaxMoves(boardSize, isQueenOnEdge);
            HashMap<Integer,Integer> queenBoundaryMoves = new HashMap<>();


            System.out.println("Max = " + maxMovesWithoutObstacles);
            System.out.println(Arrays.deepToString(obstacles));



            return 1;
        }

        static int findMaxMoves(int boardSize, boolean applyEdge){
            if(boardSize == 2){
                return 3;
            }
            else if(applyEdge){
                return (boardSize -1) * (boardSize -1);
            }else{
                return ((boardSize - 2)*3) + 5;
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            int boardSize = 5;
            int numberOfObstacles = 3;
            int queen_x = 5;
            int queen_y = 4;
            int[][] obstacles = {{5,5},{4,2}, {2,3}};



            int result = queensAttack(boardSize, numberOfObstacles, queen_x, queen_y, obstacles);

           }
    }


