package com.aneesh.problemSolvingAndAlgorithms;
import java.io.*;
import java.util.*;

public class QueensAttackII {

        // Complete the queensAttack function below.
        static int queensAttack(int boardSize, int numberOfObstacles, int queen_x, int queen_y, int[][] obstacles) {

            boolean isQueenOnEdge = queen_x == 1  || queen_x == boardSize || queen_y == 1 || queen_y == boardSize;
            int maxMovesWithoutObstacles = findMaxMoves(boardSize, queen_x, queen_y);
            for (int[] i : obstacles){
                    if (obstacleClashes(i, queen_x, queen_y)) {
                        if (notPrecededByOther(i, obstacles, queen_x, queen_y)) {

                            //impact of the clash = distance of the obstacle to the boundary
                            int clashValue = calculateClashValue(i, boardSize, queen_x, queen_y);
                            System.out.println("taking off " + clashValue);
                            maxMovesWithoutObstacles = maxMovesWithoutObstacles - clashValue;
                        }
                    }
                }

            return maxMovesWithoutObstacles;
        }

        static boolean obstacleClashes(int[] i, int queen_x, int queen_y){

            boolean clashes = false;

                if (i[0] == queen_y || i[1] == queen_x) {
                    clashes = true;
                } else if (Math.abs(i[0] - queen_y) == Math.abs(i[1] - queen_x)) {
                    clashes = true;
                }

                return clashes;

        }

        static boolean notPrecededByOther(int[] obstacle, int[][]obstacles, int queen_x, int queen_y){
            System.out.println("testing " + obstacle[0] + "  " + obstacle[1]);
            boolean directToQueen = true;
            int yIncrement = 0;
            int xIncrement = 0;
            //check if there are any obstacles between it and the queen;
            yIncrement =  queen_y > obstacle[0] ? 1 : queen_y < obstacle[0] ? -1 : 0;
            xIncrement = queen_x > obstacle[1] ? 1 : queen_x < obstacle[1] ? -1 : 0;
            int yPos = obstacle[0];
            int xPos = obstacle[1];

            while(yPos != queen_y){


                yPos = yPos + yIncrement;
                xPos = xPos + xIncrement;

                for(int[] a : obstacles){
                    System.out.println("here is " + a[0] + " " + a[1]);
                }

                for(int[] a : obstacles){
                   // System.out.println("testing: " + a[0] + " " + a[1]);
                    if(a[0] == yPos && a[1] == xPos){
                        System.out.println("matched: " + yPos + " " + xPos);
                        System.out.println("got an inefficient obstacle: " + a[0] + " " + a[1]);

                        directToQueen =  false;
                        break;
                    }
                }
            }

            return directToQueen;

        }
        static int calculateClashValue(int[] obstaclePos, int boardSize, int queen_x, int queen_y){

            int xIncrement = 0;
            int yIncrement = 0;
            //calculate the x and y increment to get to obstacle from queen
                yIncrement =  queen_y > obstaclePos[0] ? -1 : queen_y < obstaclePos[0] ? 1 : 0;
                xIncrement = queen_x > obstaclePos[1] ? -1 : queen_x < obstaclePos[1] ? 1 : 0;

            //now loop until you reach a boundary (x or y = boardsize)
            int clashValue = 1;
            int new_y_pos = obstaclePos[0];
            int new_x_pos = obstaclePos[1];

            while (new_y_pos != 1 && new_y_pos != boardSize && new_x_pos != 1 && new_x_pos != boardSize){


                new_y_pos = new_y_pos + yIncrement;
                new_x_pos = new_x_pos + xIncrement;
                clashValue++;
            }


            return clashValue;
        }
        static int findMaxMoves(int boardSize, int queen_x, int queen_y){

            int maxCentral = 0;
            if (boardSize % 2 == 0){
                System.out.println("calculating even");
                maxCentral = (((boardSize / 2)-1) * 8)+3;
                System.out.println("Max central = " + maxCentral);
                int[][] centralPoints = {{boardSize/2, boardSize/2},{boardSize/2,(boardSize/2+1)},
                        {(boardSize/2)+1, boardSize/2}, {(boardSize/2) + 1, (boardSize/2) +1}};
                int[] closestCentre = new int[2];
                int moves = Integer.MAX_VALUE;
                for(int[] a : centralPoints){
                    int theMoves = (Math.abs(a[0] - queen_y)) + (Math.abs(a[1] - queen_x));
                    if(theMoves < moves){
                        moves =  theMoves;
                        closestCentre[0] = a[0];
                        closestCentre[1] = a[1];
                    }
                }
                int distanceFromCentre = Math.max(Math.abs(closestCentre[0] - queen_y), Math.abs(closestCentre[1] - queen_x));
                maxCentral = maxCentral - (2 * distanceFromCentre);
            }
            else{

                maxCentral = (boardSize/2) * 8;
                int centralSpot = (boardSize/2) + 1;
                int distanceFromCentre = Math.max(Math.abs(centralSpot - queen_x),Math.abs(centralSpot - queen_y));
                maxCentral =  maxCentral - (2 * distanceFromCentre);
            }


            return maxCentral;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            int boardSize = 5;
            int numberOfObstacles = 3;
            int queen_x = 3;
            int queen_y = 4;
            int[][] obstacles = {{5,5},{4,2},{2,3}};



            int result = queensAttack(boardSize, numberOfObstacles, queen_x, queen_y, obstacles);
            System.out.println(result);
           }
    }


