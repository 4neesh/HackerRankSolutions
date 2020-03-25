package com.aneesh.archive;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

//link to challenge: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

public class ClimbingTheLeaderboard {

    static int[] climbingLeaderboard(int[] scoresToAddToLeaderboard, int[] aliceScores) {

        List<Integer> currentStateOfLeaderboard = new ArrayList<>();
        for (int score: scoresToAddToLeaderboard){
            currentStateOfLeaderboard.add(score);
        }
        currentStateOfLeaderboard = sortAndDistinctLeaderboard(currentStateOfLeaderboard);

        int[] alicePositionsOnLeaderboard = new int[aliceScores.length];
        int positionOfAlice = 0;
        for (int i=0; i < aliceScores.length; i++){

            //if not first score, remove the previous one
            if(i != 0){
                currentStateOfLeaderboard.remove(positionOfAlice);
            }

            currentStateOfLeaderboard.add(aliceScores[i]);
            currentStateOfLeaderboard = sortAndDistinctLeaderboard(currentStateOfLeaderboard);

            positionOfAlice = currentStateOfLeaderboard.indexOf(aliceScores[i]);
            alicePositionsOnLeaderboard[i] = positionOfAlice + 1;


        }
        return alicePositionsOnLeaderboard;

    }

    private static List<Integer> sortAndDistinctLeaderboard(List<Integer> currentLeaderboard){
        return currentLeaderboard.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {

        int[] scores = {100,90,90,80,75,60};
        int[] alice = {50,65,77,90,102};

        int[] result = climbingLeaderboard(scores, alice);

        for (int i : result){
            System.out.print(i);
        }

    }
}
