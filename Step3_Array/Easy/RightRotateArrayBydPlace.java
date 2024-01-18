package Step3_Array.Easy;

import java.util.Scanner;

public class RightRotateArrayBydPlace {
    //-------------------------1.Brute Force Approach: Using temp array-----------------------------------
    public static void rightRotateBydPalce1(int arr[], int n, int d){
        if(n==0) return;
        
        d = d % n;
        if(d>n) return;

        int temp[] = new int[d];
        // Step 1: Copy the last d elements into the temp array. TC = O(d)
        for(int j=n-d; j<n; j++){
            temp[j-n+d]=arr[j];
        }

        // Step 2: Shift n-d elements from the beginning by d position to the right. TC = O(n-d)
        for(int i=n-d-1; i>=0; i--){
            arr[i+d] = arr[i];
        }

        // Step 3: Copy the elements into the main array from the temp array. TC = O(d)
        for(int i=0; i<d; i++){
            arr[i] = temp[i];
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

    public static void rightRotateBydPalce2(int arr[], int n, int d){
        // Step 1: Reverse the last d elements of the array.  TC = O(d)
        reverse(arr, n-d, n-1);

        // Step 2: Reverse the first n-d elements of the array.   TC = O(n-d)
        reverse(arr, 0, n-d-1);

        // Step 3: Reverse the whole array.  TC = O(n)
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

        rightRotateBydPalce2(arr, n, d);

        System.out.print(" Left rotated array by " + d +" palces: ");
        for(int i: arr){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
