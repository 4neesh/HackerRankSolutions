package com.aneesh.archive;

import java.io.IOException;
import java.util.*;

class Result2 {



    public static int nonDivisibleSubset(int k, List<Integer> s) {


        HashMap<Integer, Integer> nonDivSubset = new HashMap<>();

        for (int i = 0; i<s.size()-1; i++){
            for(int j = i+1; j < s.size(); j++){
                if((s.get(i) + s.get(j)) % k != 0){
                    if(nonDivSubset.size() == 0) {
                        nonDivSubset.put(i, Integer.valueOf(s.get(i)));
                        nonDivSubset.put(j, Integer.valueOf(s.get(j)));

                    }
                    else{
                        boolean addToSubSetI = true;
                        boolean addToSubSetJ = true;
                        int[] itemsToRemove = new int[2];
                        int positionToRemove = 0;
                        //do not add if already exists
                        for(int val : nonDivSubset.keySet()){
                            if(val == i ){
                                addToSubSetI = false;
                            }
                            if(val == j){
                                addToSubSetJ = false;
                            }
                        }

                        //check it does not conflict to % = 0
                        if(addToSubSetI){
                            for(int val : nonDivSubset.values()){
                                if((s.get(i) + val) % k ==0){
                                    addToSubSetI = false;
                                    itemsToRemove[positionToRemove] = val;
                                    positionToRemove++;
                                }
                            }
                        }
                        if(addToSubSetJ){
                            for(int key : nonDivSubset.keySet()){
                                if((s.get(j) + nonDivSubset.get(key)) % k ==0){

                                    addToSubSetJ = false;
                                    itemsToRemove[positionToRemove] = key;
                                    positionToRemove++;
                                }
                            }
                        }

                        //add and remove as appropriate
                        if(addToSubSetI){
                            nonDivSubset.put(i, s.get(i));
                        }
                        if(addToSubSetJ){
                            nonDivSubset.put(j, s.get(j));
                        }
                        if(positionToRemove > 0){
                            for(int x = 0; x< positionToRemove; x++){
                                nonDivSubset.remove(itemsToRemove[x]);
                            }
                        }


                    }
                }

            }
        }
        for(int a: nonDivSubset.keySet()){
            System.out.println(a + "  " + nonDivSubset.get(a));
        }
        return nonDivSubset.size();
    }

}

public class NonDivisibleSubset2 {
    public static void main(String[] args) throws IOException {
        int k = 3;
        List<Integer> s = Arrays.asList(1,2,7,4);
        int result = Result2.nonDivisibleSubset(k, s);
        System.out.println(result);

    }
}

