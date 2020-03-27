package com.aneesh.problemSolvingAndAlgorithms;

import java.io.IOException;
import java.util.Scanner;

//link to challenge: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

public class ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }
        int[] rankArray = buildRankArray(scores);

        System.out.println(rankArray);

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] aliceResult = new int[aliceCount];
        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
            aliceResult[i] = obtainAliceRank(aliceItem, rankArray, scores);
        }

        System.out.println("FINISHED");

        scanner.close();
    }

    static int[] buildRankArray(int[] scores) {

        int rankIndex = 1;
        int[] rankArrayToReturn = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {

            if (i > 0 && scores[i] != scores[i - 1]) {
                rankIndex++;
            }
            rankArrayToReturn[rankIndex] = scores[i];

        }

        return rankArrayToReturn;
    }

    static int obtainAliceRank(int aliceScore, int[] rankArray, int[] scoreArray) {

        //recursive design pattern to handle large array lengths

        int lower = 0;
        int upper = scoreArray.length;
        int currentAliceRank = 0;
        while (lower <= upper) {

            int middle = upper + lower / 2;

            if (aliceScore == scoreArray[middle]) {
                currentAliceRank = rankArray[middle];
                break;
            } else if (aliceScore < middle) {
                currentAliceRank = rankArray[middle] + 1;
                lower = middle + 1;
            } else {
                upper = middle + 1;
            }

        }

        return currentAliceRank;

    }
}
