package com.aneesh.archive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Result3 {


    public static int nonDivisibleSubset(int k, List<Integer> s) {


        HashMap<Integer, ArrayList<Integer>> pairSolutions = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < s.size() - 1; i++) {
            Integer []   storedList = new Integer[s.size()];
            int positionInArray = 0;
            for (int j = i + 1; j < s.size(); j++) {

                if ((s.get(i) + s.get(j)) % k != 0) {
                    storedList[positionInArray] = s.get(j);
                    positionInArray++;
                }

            }
            pairSolutions.putIfAbsent(s.get(i), new ArrayList<>(Arrays.asList(storedList)));
        }

        for (int i : pairSolutions.keySet()) {
            System.out.println(i + " " + pairSolutions.get(i));
        }

        List<List<Integer>> allSolutions = new ArrayList<>();

        //for each key within the pairsolutions
        for (Integer key: pairSolutions.keySet()){

            List<Integer> valuesToKey = pairSolutions.get(key);

            //i = value for key in the list
            for(int i =0; i<valuesToKey.size(); i++){
                List<Integer> solutionArray = new ArrayList<>();
                solutionArray.add(key);

                solutionArray.add(valuesToKey.get(i));
                for(int j = 0; j<pairSolutions.get(valuesToKey.get(i)).size(); j++){
                    //values under the value as a key
                    //List<Integer> a = valuesToKey.get(j);
                }
                allSolutions.add(solutionArray);

            }

        }

        return 1;

    }
}

public class NonDivisibleSubset3 {
    public static void main(String[] args) throws IOException {
        int k = 4;
        List<Integer> s = Arrays.asList(19, 10, 12, 24, 22, 25);
        int result = Result3.nonDivisibleSubset(k, s);
        //System.out.println(result);

    }
}

