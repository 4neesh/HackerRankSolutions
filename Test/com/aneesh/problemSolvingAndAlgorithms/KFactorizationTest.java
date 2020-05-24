package com.aneesh.problemSolvingAndAlgorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class KFactorizationTest {


    private KFactorization kFactorization;

    @Before
    public void setUp(){
        kFactorization = new KFactorization();
    }

    @After
    public void tearDown(){
        kFactorization = null;

    }

    @Test
    public void caseZero(){

        Integer valueArray[] = {2,3,4};
        int target = 12;

        int[] expectedResult = new int[]{1,3,12};
        int[] actualResult =  kFactorization.getResult(valueArray, target);

        assertEquals(expectedResult.length, actualResult.length);
        assertTrue(equalArray(expectedResult, actualResult));

    }

    @Test
    public void caseOne(){

        Integer valueArray[] = {2,10,6,9,11};
        int target = 15;

        int[] expectedResult = new int[]{-1};
        int[] actualResult =  kFactorization.getResult(valueArray, target);
        assertEquals(expectedResult.length, actualResult.length);
        assertTrue(equalArray(expectedResult, actualResult));
//        assertThat(equalArray(expectedResult,actualResult), isTrue())
    }

    @Test
    public void caseTwo(){

        Integer valueArray[] = {2,4,6,9,3,7,16,10,5};
        int target = 72;

        int[] expectedResult = new int[]{1,2,8,72};
        int[] actualResult =  kFactorization.getResult(valueArray, target);
        assertEquals(expectedResult.length, actualResult.length);
        assertTrue(equalArray(expectedResult, actualResult));
    }


    @Test
    public void caseEleven(){

        Integer valueArray[] = {2,3, 5, 7, 11, 13, 17, 19};
        int target = 231000000;

        int[] expectedResult = new int[]{1,2,4, 8, 16, 32, 64, 192, 960,4800, 24000, 120000, 600000, 3000000, 21000000, 231000000};
        int[] actualResult =  kFactorization.getResult(valueArray, target);
        assertEquals(expectedResult.length, actualResult.length);
        assertTrue(equalArray(expectedResult, actualResult));
    }

    public boolean equalArray(int[] a, int[] b){

            for (int i = 0; i<a.length; i++){
                if (a[i] != b[i]){
                    return false;
                }
            }
            return true;
        }

}
