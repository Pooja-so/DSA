package Step3_Array.Easy;

import java.util.*;

public class LeftRotateArrayBydPlace {
    //-------------------------1.Brute Force Approach: Using temp array-----------------------------------
    public static void leftRotateBydPalce1(int arr[], int n, int d){
        if(n==0) return;
        
        d = d % n;
        if(d>n) return;

        int temp[] = new int[d];
        // Step 1: Copy the first d elements into the temp array. TC = O(d)
        for(int j=0; j<d; j++){
            temp[j]=arr[j];
        }

        // Step 2: Shift n-d elements from last by d position to the left. TC = O(n-d)
        for(int i=0; i<(n-d); i++){
            arr[i] = arr[d+i];
        }

        // Step 3: Copy the elements into the main array from the temp array. TC = O(d)
        for(int i=(n-d); i<n; i++){
            arr[i] = temp[i-n+d];
        }

    }
    /* Time Complexity: O(d) + O(n-d) + O(d) = O(d+n-d+d) = O(n+d) 
       Space Complexity: O(d) since d array element needs to be stored in temp array
    */
    
    //-------------------------2.Optimal Approach: Using Reversal algorithm---------------------------------------
     // Function to Reverse the array
    public static void reverse(int arr[], int start, int end) {
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    // Function to Rotate k elements to left
    public static void leftRotateBydPalce2(int arr[], int n, int d){
        // Step 1: Reverse the first d elements of the array. TC = O(d)
        reverse(arr, 0, d-1); 

        // Step 2: Reverse the last n-d elements of the array. TC = O(n-d)
        reverse(arr, d, n-1);

        // Step 3: Reverse the whole array. Tc = O(n)
        reverse(arr, 0, n-1);
    }
    /*  Time Complexity – O(N) where N is the number of elements in an array . TC = O(d) + O(n-d) + O(n) = O(d+n-d+n) = O(2n)
        Space Complexity – O(1) since no extra space is required i.e. we are working on the input array only
    */
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(" Enter the no of places: ");
        int d = sc.nextInt();

        leftRotateBydPalce2(arr, n, d);

        System.out.print(" Left rotated array by " + d +" palces: ");
        for(int i: arr){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
