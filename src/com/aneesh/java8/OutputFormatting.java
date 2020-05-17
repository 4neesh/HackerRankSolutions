package com.aneesh.java8;

import java.util.Scanner;

public class OutputFormatting {

    //link to challenge: https://www.hackerrank.com/challenges/java-output-formatting/problem?h_r=next-challenge&h_v=zen


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");

        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            String intAsString = "";
            if(x < 100 && x > 9){
                 intAsString = "0" + x;
            }
            else if(x < 10){
                intAsString = "00" + x;
            }
            else{
                intAsString = Integer.toString(x);
            }
            System.out.println(s1 + "      " + intAsString);
        }
        System.out.println("================================");

    }
}
