package com.aneesh.problemSolvingAndAlgorithms;

import static java.lang.Math.sqrt;

public class Encryption {

    public static float divide;
    static String encryption(String noSpaceText) {

        String[] stringByRows = convertStringToRows(noSpaceText);
        populateStringByRows(noSpaceText, stringByRows);
        String encryptedText = createStringAnswer(stringByRows).toString();
        return encryptedText;

    }

    private static void populateStringByRows(String noSpaceText, String[] stringCreation) {
        for (int i = 0; i < noSpaceText.length(); i++){
            int arrayToAdd = Math.round(i % divide);

            stringCreation[arrayToAdd] = stringCreation[arrayToAdd] + noSpaceText.substring(i,i+1);
        }

    }

    private static String[] convertStringToRows(String noSpaceText) {
        String[] stringCreation = new String[(int)divide];
        for(int j = 0; j < (int)divide; j++){
            stringCreation[j] = "";
        }

        return stringCreation;

    }

    static StringBuilder createStringAnswer(String [] stringCreation){
        StringBuilder sb = new StringBuilder();
        for (String st : stringCreation){

            sb.append(st + " ");
        }
        return sb;
    }

    public static void main(String[] args) {
        String stringToEncrypt = "haveaniceday";
        String noSpaceText = stringToEncrypt.replaceAll("\\s+", "");
        divide = (float)Math.ceil(sqrt(noSpaceText.length()));
        String encryptedString = encryption(noSpaceText);

        System.out.println(encryptedString);

    }

}
