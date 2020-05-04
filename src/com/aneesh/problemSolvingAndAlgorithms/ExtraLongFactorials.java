package com.aneesh.problemSolvingAndAlgorithms;

import java.util.*;
import java.math.BigInteger;

public class ExtraLongFactorials {

    //link to challenge: https://www.hackerrank.com/challenges/extra-long-factorials/problem

        static BigInteger extraLongFactorials(int n, BigInteger factorialSum) {

            if(n > 2 ){
                factorialSum = factorialSum.multiply(BigInteger.valueOf(n));
                return extraLongFactorials(--n, factorialSum);
            }
            else {
                factorialSum = factorialSum.multiply(BigInteger.valueOf(n));
                return factorialSum;
            }


        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            BigInteger factorialSum = new BigInteger("1");

            BigInteger value = extraLongFactorials(n, factorialSum);
            System.out.println(value);
            scanner.close();
        }
    }


