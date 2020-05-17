package com.aneesh.problemSolvingAndAlgorithms;

//link to challenge: https://www.hackerrank.com/challenges/bon-appetit/problem


import java.util.ArrayList;
import java.util.List;

public class BonAppetit {

    static void bonAppetit(List<Integer> bill, int notEaten, int charged) {

        int shouldBeCharged = 0;
        for (int i = 0; i<bill.size(); i++){
            if(i != notEaten){
                shouldBeCharged += bill.get(i);
            }
        }
        shouldBeCharged = shouldBeCharged /2;

        if (charged == shouldBeCharged){
            System.out.println("Bon Appetit");

        }
        else{
            System.out.println(charged - shouldBeCharged);
        }

    }

    public static void main(String[] args) {

        int charged = 7;
        List<Integer> bill = new ArrayList<>();
        bill.add(3);
        bill.add(10);
        bill.add(2);
        bill.add(9);

        int items  = 1;


        bonAppetit(bill, items, charged);

    }

}
