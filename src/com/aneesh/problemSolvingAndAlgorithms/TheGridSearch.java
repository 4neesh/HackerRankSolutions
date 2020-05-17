package com.aneesh.problemSolvingAndAlgorithms;

//link to challenge: https://www.hackerrank.com/challenges/the-grid-search/problem
public class TheGridSearch {


    static String gridSearch(String[] graphArray, String[] patternArray) {

        String result = "NO";
        int gridHeight = graphArray.length;
        int patternHeight = patternArray.length;
        int searchableHeight = (gridHeight - patternHeight) + 1;
        for (int xPos = 0; xPos < searchableHeight; xPos++) {

            if (graphArray[xPos].contains(patternArray[0])) {

                int yPos = graphArray[xPos].indexOf(patternArray[0]);

                if (checkPatternMatch(graphArray, patternArray, yPos, xPos)) {
                    result = "YES";
                    break;
                }

                String subG = graphArray[xPos].substring(yPos + 1);
                int offset = yPos ;

                while (subG.contains(patternArray[0])) {

                    yPos = subG.indexOf(patternArray[0]) + offset;
                    if (checkPatternMatch(graphArray, patternArray, yPos, xPos)) {
                        result = "YES";
                        break;
                    }
                    subG = graphArray[xPos].substring(yPos + 1 );
                    offset = offset + 1 ;

                }
            }

        }

        return result;

    }

    private static boolean checkPatternMatch(String[] g, String[] p, int i, int j) {

        System.out.println(g[j].substring(i, i + p[0].length()) + " at " + j);
        for (int y = 0; y < p.length; y++) {

            if (g[j + y].substring(i, i + p[y].length()).equals(p[y])) {
                if (y == p.length - 1) {

                    return true;
                }
            } else {
                break;
            }

        }
        return false;
    }


    public static void main(String[] args) {

        String[] G = {

                "111111111111111",
                "111111111111111",
                "111111111111111",
                "111111011111111",
                "111111111111111",
                "111111111111111",
                "101010101010101"

        };
        String[] P = {
                "11111",
                "11111",
                "11111",
                "11110"

        };

        System.out.println(gridSearch(G, P));

    }
}
