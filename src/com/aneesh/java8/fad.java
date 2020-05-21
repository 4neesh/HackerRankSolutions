import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class fad {

    public static List<Integer> resultList = new ArrayList<>();
    public static int target;

    static int[] kFactorization(Integer[] values){

        Arrays.sort(values, Collections.reverseOrder());
        //eliminate values that don't go into target
        List<Integer> factorsToTarget = new ArrayList<>();
        for(int i : values){
            if( target % i == 0){
                factorsToTarget.add(i);
            }
        }

        System.out.println(factorsToTarget);

        //add to the result.
        //loop through each value and check if it divides evenly
        recurseResults(factorsToTarget);


        System.out.println(resultList);
        Collections.sort(resultList);

        int[] result = new int[resultList.size()+1];
        result[0] = 1;
        for (int i = 1; i<=resultList.size(); i++){
            result[i] = result[i-1] * resultList.get(i-1);
        }
        for(int i : result){
            System.out.println(i);
        }
        if(result[resultList.size()+1] != target){
            result = new int[1];
            result[0] = -1;
        }

        return result;


    }

    private static void recurseResults(
            List<Integer> factorsToTarget) {

        if(factorsToTarget.size() == 0 || resultListEquals()){
            return;
        }
        List<Integer> temporaryFactors = new ArrayList<>();
        for(int i = 1; i< factorsToTarget.size(); i++){
            temporaryFactors.add(factorsToTarget.get(i));
        }

        if(target % factorsToTarget.get(0) == 0){

            resultList.add(factorsToTarget.get(0));
            target = target / factorsToTarget.get(0);
            recurseResults(temporaryFactors);
        }
        else{

            recurseResults(temporaryFactors);
        }


    }
    private static boolean resultListEquals() {

        int resultListValue = 1;
        for(int i : resultList){
            resultListValue = resultListValue * i;
        }

        if(resultListValue == target){
            return true;
        }
        else{
            return false;
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        target = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        Integer[] A = new Integer[k];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < k; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] result = kFactorization(A);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
