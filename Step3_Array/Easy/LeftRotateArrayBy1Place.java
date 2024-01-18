package Step3_Array.Easy;

import java.util.Scanner;

public class LeftRotateArrayBy1Place {
    //-------------------------1.Brute Force Approach-----------------------------------
    public static void leftRotate1(int arr[], int n){
        int temp[] = new int[n];

        for(int i=0; i<(n-1); i++){
            temp[i] = arr[i+1];
        }
        temp[n-1] = arr[0];

        for(int i=0; i<n; i++){
            arr[i] = temp[i];
        }
    }
    /* Time Complexity: O(2n), as we iterate through the array twice.
       Space Complexity: O(n) as we are using another array of size, same as the given array.
    */

    //-------------------------2.Optimal Approach---------------------------------------
    public static void leftRotate2(int arr[], int n){
        int x = arr[0];

        for(int i=0; i<(n-1); i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = x;
    }
    /*
     * Time Complexity: O(n), as we iterate through the array only once.
     * Space Complexity: O(1) as no extra space is used
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

        leftRotate2(arr, n);

        System.out.print(" Left rotated array: ");
        for(int i: arr){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
