package com.aneesh.problemSolvingAndAlgorithms;

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
                if(obstaclesMap_y.containsKey(queen_x)){

                }
            }

//            for(int i: obstaclesMap_x.keySet()){
//                System.out.println(i + " " + obstaclesMap_x.get(i));
//            }
//            for(int u : obstaclesMap_y.keySet()){
//                System.out.println(u + " " + obstaclesMap_y.get(u));
//            }


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
            int numberOfObstacles = 4;
            int queen_x = 3;
            int queen_y = 4;
            int[][] obstacles = {{5,5},{4,2}, {2,3},{5,3}};



            int result = queensAttackv2(boardSize, numberOfObstacles, queen_x, queen_y, obstacles);

           }
    }


