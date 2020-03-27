package com.aneesh.problemSolvingAndAlgorithms;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {



    public static int nonDivisibleSubset(int k, List<Integer> s) {

        HashSet<Integer> nonDivSubset = new HashSet<>();
        HashSet<Integer> divSubset = new HashSet<>();

        for (int i = 0; i<s.size()-1; i++){
            for(int j = i+1; j < s.size(); j++){
                if((s.get(i) + s.get(j)) % k != 0){
                    if(nonDivSubset.size() == 0) {
                        nonDivSubset.add(Integer.valueOf(s.get(i)));
                        nonDivSubset.add(Integer.valueOf(s.get(j)));
                    }
                    else{
                        //check for i
                        boolean addToSubSetI = true;
                        boolean addToSubSetJ = true;

                        for(int val : nonDivSubset){
                            if(val != s.get(i) && ((val + s.get(i))%k == 0 )){
                                addToSubSetI = false;
                            }
                        }

                        //check for j
                        for(int val : nonDivSubset){
                            if(val != s.get(j) && ((val + s.get(j))%k == 0 )){
                                addToSubSetJ = false;
                            }
                        }

                        if(addToSubSetI){
                            nonDivSubset.add(Integer.valueOf(s.get(i)));
                        }else if(nonDivSubset.contains(Integer.valueOf(s.get(i)))){
                                nonDivSubset.remove(Integer.valueOf(s.get(i)));
                            }

                        if (addToSubSetJ) {
                            nonDivSubset.add(Integer.valueOf(s.get(j)));
                        }
                        else if(nonDivSubset.contains(Integer.valueOf(s.get(i)))){
                            nonDivSubset.remove(Integer.valueOf(s.get(i)));
                        }

                    }
                }

            }
        }

        return nonDivSubset.size();
    }

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        int k = 4;
        List<Integer> s = Arrays.asList(19,10,12,10,24,25,22);
        int result = Result.nonDivisibleSubset(k, s);
        System.out.println(result);

    }
}

