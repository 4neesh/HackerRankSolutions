package com.aneesh.archive;

import java.io.IOException;
import java.util.*;

//link to challenge: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

public class ClimbingTheLeaderboard4 {

    static int[] climbingLeaderboard(int[] scoresToAddToLeaderboard, int[] aliceScores) {
        int TOP_SCORE = scoresToAddToLeaderboard[0];
        int LOW_SCORE = scoresToAddToLeaderboard[scoresToAddToLeaderboard.length-1];

        LinkedHashSet<Integer> uniqueScores = new LinkedHashSet<>();
        for(int i = 0; i<scoresToAddToLeaderboard.length; i++){
            uniqueScores.add(scoresToAddToLeaderboard[i]);
        }


        Map<Integer,Integer> leaderboard = new HashMap<>();
        int position = 1;
        for (int score: uniqueScores){
            leaderboard.put(score, position);
            position++;
        }

        int[] alicePositionsOnLeaderboard = new int[aliceScores.length];

        int arrayPositionInAlicePositions = 0;
        for (int i=0; i < aliceScores.length; i++){

            //we have alice's score, now need to find the position
            if(leaderboard.containsKey(aliceScores[i])){
                //find position of alice in leaderboard

                alicePositionsOnLeaderboard[arrayPositionInAlicePositions] = leaderboard.get(aliceScores[i]);
                arrayPositionInAlicePositions++;

            }
            else if(aliceScores[i] > TOP_SCORE){
                alicePositionsOnLeaderboard[arrayPositionInAlicePositions] = 1;
                arrayPositionInAlicePositions++;
            }
            else if(aliceScores[i] < LOW_SCORE){
                alicePositionsOnLeaderboard[arrayPositionInAlicePositions] = leaderboard.size();
                arrayPositionInAlicePositions++;
            }
            else{
                alicePositionsOnLeaderboard[arrayPositionInAlicePositions] = findAlicePosition(aliceScores[i], TOP_SCORE, LOW_SCORE, leaderboard, uniqueScores);
                arrayPositionInAlicePositions++;
            }
        }

        return alicePositionsOnLeaderboard;
    }

    private static int findAlicePosition(int aliceScore, int topScore, int lowScore, Map<Integer, Integer> leaderboard, HashSet<Integer> hashSet){
        int midScore = (topScore + lowScore) /2;
        System.out.println(leaderboard.keySet());
        if(leaderboard.get(leaderboard.get(topScore)+1) < aliceScore && leaderboard.get(leaderboard.get(lowScore) -1 ) > aliceScore){
            return leaderboard.get(leaderboard.get(topScore)) + 1;
        }
        else if(aliceScore < lowScore && aliceScore > midScore){
            return findAlicePosition(aliceScore, midScore, lowScore, leaderboard, hashSet);
        }
        else{
            return findAlicePosition(aliceScore, topScore, midScore, leaderboard, hashSet);
        }
    }
    public static void main(String[] args) throws IOException {

        int[] scores = {997, 981, 957, 933, 930, 927, 926, 920, 916, 896,
                887, 874, 863, 863, 858, 847, 815, 809, 803, 794, 789, 785,
                783, 778, 764, 755, 751, 740, 737, 730, 691, 677, 652, 650,
                587, 585, 583, 568, 546, 541, 540, 538, 531, 527, 506, 493,
                457, 435, 430, 427, 422, 422, 414, 404, 400, 394, 387, 384,
                374, 371, 369, 369, 368, 365, 363, 337, 336, 328, 325, 316,
                314, 306, 282, 277, 230, 227, 212, 199, 179, 173, 171, 168,
                136, 125, 124, 95, 92, 88, 85, 70, 68, 61, 60, 59, 44, 43,
                28, 23, 13, 12};

        int[] alice = {12, 20, 30, 32, 35, 37, 63, 72, 83, 85, 96, 98, 98,
                118, 122, 125, 129, 132, 140, 144, 150, 164, 184, 191, 194,
                198, 200, 220, 228, 229, 229, 236, 238, 246, 259, 271, 276,
                281, 283, 287, 300, 302, 306, 307, 312, 318, 321, 325, 341,
                341, 341, 344, 349, 351, 354, 356, 366, 369, 370, 379, 380,
                380, 396, 405, 408, 417, 423, 429, 433, 435, 438, 441, 442,
                444, 445, 445, 452, 453, 465, 466, 467, 468, 469, 471, 475,
                482, 489, 491, 492, 493, 498, 500, 501, 504, 506, 508, 523,
                529, 530, 539, 543, 551, 552, 556, 568, 569, 571, 587, 591,
                601, 602, 606, 607, 612, 614, 619, 620, 623, 625, 625, 627,
                638, 645, 653, 661, 662, 669, 670, 676, 684, 689, 690, 709,
                709, 710, 716, 724, 726, 730, 731, 733, 737, 744, 744, 747,
                757, 764, 765, 765, 772, 773, 774, 777, 787, 794, 796, 797,
                802, 805, 811, 814, 819, 819, 829, 830, 841, 842, 847, 857,
                857, 859, 860, 866, 872, 879, 882, 895, 900, 900, 903, 905,
                915, 918, 918, 922, 925, 927, 928, 929, 931, 934, 937, 955,
                960, 966, 974, 982, 988, 996, 996};


        int[] result = climbingLeaderboard(scores, alice);

        for (int i : result){
            System.out.println(i);
        }

    }
}
