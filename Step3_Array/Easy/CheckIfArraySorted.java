package Step3_Array.Easy;

import java.util.Scanner;

public class CheckIfArraySorted {
    // 1. --------------------- Brute Force Approach -------------------------
    public static boolean isSorted1(int arr[], int n) {
        if( n==0 || n==1){
            return true;
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i]>arr[j])
                    return false;
            }
        }
        return true;
    }

    // 2. --------------------- Optimal Approach -----------------------------
    public static boolean isSorted2(int arr[], int n) {
        if( n==0 || n==1){
            return true;
        }
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        if(isSorted1(arr, n)) {
            System.out.println(" Array is sorted ");   
        } else {
            System.out.println(" Array is not sorted ");    
        }
        sc.close();
    }
}