package com.aneesh.problemSolvingAndAlgorithms;

public class BiggerIsGreater {

    private static int maxValInArray = 0;

    static String biggerIsGreater(String testString) {

        String isGreater = "no answer";

        int[] lexiArray = getAlphaPos(testString);
        for(int c : lexiArray){
            System.out.println(c);
        }

        //we have defined the array of the numbers
        //now need to work out how to organise
        //it can be easy (switching two if the former < latter)
        //or hard:finding next value in line and then pasting the sorted array after.
        

        if(lexiArray[0] == maxValInArray ){
            //complex resolve

        }
        else{
            //simple resolve


        }



        for (int i = testString.length(); i > 0; i--) {

            if (testString.substring(i - 1, i).compareTo(testString.substring(i - 2, i - 1)) > 0) {
                isGreater = nextSolution(testString, i);
                break;

            }

        }
        return isGreater;
    }

    static int[] getAlphaPos(String str) {
        char[] ch = str.toCharArray();
        int i = 0;
        int[] result = new int[str.length()];
        for (char c : ch) {

            int temp = (int) c;
            int temp_integer = 96; //for lower case
            if (temp <= 122 & temp >= 97) {
                result[i] = temp - temp_integer;
                if (result[i] > maxValInArray){
                    maxValInArray = result[i];
                }
                i++;
            }
        }
        return result;

    }

    private static String nextSolution(String testString, int i) {

        StringBuilder sb = new StringBuilder();
        sb.append(testString, 0, i - 2);
        sb.append(testString, i - 1, i);
        sb.append(testString, i - 2, i - 1);
        sb.append(testString.substring(i));
        return sb.toString();
    }


    public static void main(String[] args) {


        String testBiggerIsGreater = "hiya";
        String greaterSolution = biggerIsGreater(testBiggerIsGreater);
        System.out.println(greaterSolution);
    }
}
