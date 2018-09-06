/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessmentfun;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author unrea
 */
public class AssessmentFunTest {
    
    public AssessmentFunTest() {
    }

    /**
     * Test of isPalindrome method, of class AssessmentFun.
     */
    @Test
    public void testIsPalindrome() {
        System.out.println("isPalindrome");
        
        String testOne = "notapalindrome";
        String testTwo = "racecar";
        String testThree = "Racecar";
        String testFour = "rA CE  Car";
        
        assertFalse(AssessmentFun.isPalindrome(testOne));
        assertTrue(AssessmentFun.isPalindrome(testTwo));
        assertTrue(AssessmentFun.isPalindrome(testThree));
        assertTrue(AssessmentFun.isPalindrome(testFour));
    }

    /**
     * Test of largestNumbers method, of class AssessmentFun.
     */
    @Test
    public void testLargestNumbers() {
        //
    }

    /**
     * Test of notPresent method, of class AssessmentFun.
     */
    @Test
    public void testNotPresent() {
        System.out.println("notPresent");
        int[] arr1 = {1, 3, 5, 7, 9, 10};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(10);
        ArrayList<Integer> result = AssessmentFun.notPresent(arr1, arr2);
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    /**
     * Test of isPower method, of class AssessmentFun.
     */
    @Test
    public void testIsPower() {
        System.out.println("isPower");
        int testOne = -1;
        int testTwo = 0;
        int testThree = 2;
        int testFour = 311;
        int testFive = 4096;
        assertFalse(AssessmentFun.isPower(testOne));
        assertFalse(AssessmentFun.isPower(testTwo));
        assertTrue(AssessmentFun.isPower(testThree));
        assertFalse(AssessmentFun.isPower(testFour));
        assertTrue(AssessmentFun.isPower(testFive));
    }    
}
