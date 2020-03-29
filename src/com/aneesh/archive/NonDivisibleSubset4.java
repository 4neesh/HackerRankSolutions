package com.aneesh.archive;

import java.io.IOException;
import java.util.*;

class Result4 {


    public static int nonDivisibleSubset(int k, List<Integer> s) {


        HashMap<Integer, List<Integer>> matchingPairs = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> rulesApplication = new HashMap<>();

        int position = 0;
        for (int i = 0; i<s.size()-1; i++) {
            for (int j = i + 1; j < s.size(); j++) {
                if((s.get(i) + s.get(j)) % k == 0){
                    List<Integer> pair = Arrays.asList(s.get(i), s.get(j));
                    matchingPairs.put(position, pair);
                    rulesApplication.putIfAbsent(s.get(i), 1);
                    rulesApplication.putIfAbsent(s.get(j), 1);

                    position++;
                }
            }
        }
        for (Integer ks : matchingPairs.keySet()){
            System.out.println(ks + " " + matchingPairs.get(ks));
        }
        for (Integer ks : rulesApplication.keySet()){
            System.out.println(ks + " " + rulesApplication.get(ks));
        }


        int numberOfRules = matchingPairs.size();
        Collection<Integer> countsOfRules = rulesApplication.values();
        int result = 0;
        if(Collections.max(countsOfRules) == 1){
           result = s.size() - (numberOfRules/2);
        }
        return result;

    }
}

public class NonDivisibleSubset4 {
    public static void main(String[] args) throws IOException {
        int k = 4;
        List<Integer> s = Arrays.asList(19, 10, 12, 24, 22, 25);
        int result = com.aneesh.archive.Result4.nonDivisibleSubset(k, s);
        System.out.println(result);

    }
}



