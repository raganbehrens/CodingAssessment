/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessmentfun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ragan
 */
public class AssessmentFun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Task One
        System.out.println("Enter 5 different words/sentences to see if theyre palindromes");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String input = scan.nextLine();
            System.out.println(isPalindrome(input));
        }
        
        // Task Two
        System.out.println("Please enter the name of a file that contains integers");
        String fileName = scan.nextLine();
        System.out.println(Arrays.toString(largestNumbers(fileName)));
        
        // Task Three
        int[] arr1 = {1, 2, 3, 4, 5, 8, 10, 21};
        int[] arr2 = {2, 3, 1, 0, 21, 4, 5};
        System.out.println("Checking which values are in " + Arrays.toString(arr1) + " but not in " + Arrays.toString(arr2));
        System.out.println("Press enter to continue");
        scan.nextLine();
        System.out.println(notPresent(arr1, arr2));
        
        // Task Four
        System.out.println("Enter 5 different numbers to see if they are powers of two");
        for (int i = 0; i < 5; i++){
            int num = scan.nextInt();
            System.out.println(isPower(num));
        }
    }
    
    public static boolean isPalindrome(String input){
        String formatted = input.replaceAll("\\s+", "");
        formatted = formatted.toLowerCase();
        return formatted.equals(reverseString(formatted)); 
    }
    
    public static int[] largestNumbers(String fileName){
        //ArrayList<Integer> largest = new ArrayList<>();
        int[] largest = new int[10];
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            System.out.println("File: " + fileName + " not found.");
            Logger.getLogger(AssessmentFun.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
        
        while (scanner.hasNextInt()) {
            System.out.println(largest);
            int num = scanner.nextInt();
            if (num > largest[9]) insert(largest, num, 9);
            else if ((num > largest[0]) && (num < largest[9])){
                for (int i = 1; i <= 9; i++) {
                    if (num < largest[i]){
                        largest = insert(largest, num, i-1);
                        break;
                    }   
                }
            }
            for (int i = 0; i < 10; i ++){
                if (num > largest[i]) {
                    
                }
            }
        }
        return largest;
    }
    
    public static ArrayList<Integer> notPresent(int[] arr1, int[] arr2){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : arr1) {
            boolean contains = false;
            for (int j : arr2) {
                if (i == j) contains = true; 
            }
            if (!contains) result.add(i);
        }
        return result;
    }
    
    public static boolean isPower(int num){
        ArrayList<Integer> powers = new ArrayList<>();
        powers.add(2);
        
        // If num isn't even, it's not a power of 2
        // Ignoring negative powers
        if (!(num % 2 == 0) || (num < 2)) return false;
        
        // If the num is greater than the largest integer in the arraylist, start from that point
        if (powers.get(powers.size()-1) < num){
            for (int i = powers.get(powers.size()-1)*2; i <= num; i*=2) {
                powers.add(i);
                if (i == num) return true;
            }
        }
        
        // If the num is less than the largest integer in the arraylist, see if num exists
        else {
            return powers.contains(num);
        }
        
        // This line should not be reached, but return false in case
        return false;
    }
    
    // Helper function for first task - isPalindrome
    public static String reverseString(String input){
        String newString = "";
        for (int i = input.length()-1; i >= 0; i--) {
            newString += input.charAt(i);
        }
        return newString;
    }
    
    // Helper function second task - largestNumbers
    public static int[] insert(int[] largest, int num, int index){
        for (int i = 0; i < index; i++) {
            largest[i] = largest[i++];
        }
        largest[index] = num;
        return largest;
    }  
}
