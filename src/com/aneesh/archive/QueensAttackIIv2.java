package com.aneesh.archive;

import java.io.IOException;
import java.util.*;

public class QueensAttackIIv2 {

        // Complete the queensAttack function below.
        static int queensAttackv2(int boardSize, int numberOfObstacles, int queen_x, int queen_y, int[][] obstacles) {

            HashMap<Integer,ArrayList<Integer>> obstaclesMap_x = new HashMap<>();
            HashMap<Integer,ArrayList<Integer>> obstaclesMap_y = new HashMap<>();
            int possibleMoves = 0;

            for(int i = 0; i< numberOfObstacles; i++){
                int x = obstacles[i][0];
                int y = obstacles[i][1];
                addToMap(x, obstaclesMap_x, obstacles[i][1]);
                addToMap(y, obstaclesMap_y, obstacles[i][0]);
            }

            //add for south
            if(queen_y > 1){
                if(obstaclesMap_x.containsKey(queen_x)){
                    HashSet<Integer> a = new HashSet<Integer>();
                    for(int i : obstaclesMap_x.get(queen_x)){
                        if (i < queen_y){
                            a.add(i);
                        }
                    }
                    possibleMoves = possibleMoves + (queen_y - Collections.max(a) - 1);
                    System.out.println(possibleMoves + " pos moves south");
                }
                else{
                    possibleMoves = possibleMoves + queen_y - 1;
                }

            }

            //add for north
            if(queen_y < boardSize){
                if(obstaclesMap_x.containsKey(queen_x)){
                    HashSet<Integer> a = new HashSet<Integer>();
                    for(int i : obstaclesMap_x.get(queen_x)){
                        if (i > queen_y){
                            a.add(i);
                        }
                    }
                    possibleMoves = possibleMoves + (Collections.min(a) - (queen_y + 1));
                    System.out.println((Collections.min(a) - (queen_y +1)) + " pos moves north");
                }
                else{
                    possibleMoves = possibleMoves + (boardSize - queen_y);

                }
            }

            //add for east
            if(queen_x < boardSize){
                int amountToAdd = 0;
                if(obstaclesMap_y.containsKey(queen_y)){
                    HashSet<Integer> a = new HashSet<Integer>();
                    for(int i : obstaclesMap_y.get(queen_y)){
                        if(i > queen_x){
                            a.add(i);
                        }
                    }
                    amountToAdd = a.size() > 0 ? Collections.min(a) - 1 - queen_x : boardSize - queen_x;
                }
                else{
                    amountToAdd = boardSize - queen_x;
                }
                System.out.println("possible moves after east = " + amountToAdd);
                possibleMoves = possibleMoves + amountToAdd;
                System.out.println("after east, moves = " + possibleMoves);
            }

            return 1;
        }


        static void addToMap(Integer valueToAdd, HashMap<Integer, ArrayList<Integer>> map, int key){
            ArrayList<Integer> currentList = map.get(key);

            //only add if it constricts further

            if(currentList == null) {
                currentList = new ArrayList<Integer>();
            }
            currentList.add(valueToAdd);
            map.put(key, currentList);

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            int boardSize = 5;
            int numberOfObstacles = 5;
            int queen_x = 3;
            int queen_y = 4;
            int[][] obstacles = {{5,5},{4,2}, {2,3},{5,3},{1,3}};



            int result = queensAttackv2(boardSize, numberOfObstacles, queen_x, queen_y, obstacles);

           }
    }


