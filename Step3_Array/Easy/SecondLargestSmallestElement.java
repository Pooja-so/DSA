package Step3_Array.Easy;

import java.util.Arrays;
import java.util.Scanner;

// Assuming that there is no negative numbers in the input array
public class SecondLargestSmallestElement{

    //---------------------- 1. Brute Force Approach -----------------------------
    public static void secondMinMax1(int [] arr, int n) {
        if( n==0 || n==1){
            System.out.println(" No second smallest or largest element exists.");
            return;
        }
        Arrays.sort(arr);
        int secondMin = arr[1];
        int secondMax = arr[arr.length-2];

        System.out.println(" Second smallest: " + secondMin + " Second largest: " + secondMax);
        
    }
    //---------------------- 2. Better Approach ----------------------------------
    public static void secondMinMax2(int [] arr, int n) {
        if( n==0 || n==1){
            System.out.println(" No second smallest or largest element exists.");
            return;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        // Traversal 1: Finding the largest and the smallest element
        for(int i=0; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        // Traversal 2: Finding the second largest and the second smallest element
        for(int i=0; i<n; i++) {
            if( arr[i]<secondMin && arr[i]>min){
                secondMin = arr[i];
            }
            if( arr[i]>secondMax && arr[i]<max){
                secondMax = arr[i];
            }
            
        }
        System.out.println(" Second smallest: " + secondMin + " Second largest: " + secondMax);

    }

    //---------------------- 2. Optimal Approach ----------------------------------
    public static void secondMinMax3(int [] arr, int n) {
        if( n==0 || n==1){
            System.out.println(" No second smallest or largest element exists.");
            return;
        }
        // ------------Second Minimum value-----------------//
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i]<min){
                secondMin = min;
                min = arr[i];
            } 
            else if(arr[i]<secondMin && arr[i]!=min){
                secondMin = arr[i];
           }
        }

         // ------------Second Maximum value-----------------//
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(arr[i]>max){
                secondMax = max;
                max = arr[i];
            } 
            else if(arr[i]>secondMax && arr[i]!=max){
                secondMax = arr[i];
            }

        }

        System.out.println(" Second smallest: " + secondMin + " Second largest: " + secondMax);
        
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of an array: ");
        int n = sc.nextInt();

        int arr[] = new int[n]; 
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        secondMinMax1(arr, n);
        secondMinMax2(arr, n);
        secondMinMax3(arr, n);

        sc.close();
    }
}

