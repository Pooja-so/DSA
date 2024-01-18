package Step3_Array.Easy;

import java.util.Scanner;

public class RightRotateArrayBy1Place {
    //-------------------------1.Brute Force Approach-----------------------------------
    public static void rightRotate1(int arr[], int n){
        int temp[] = new int[n];

        for(int i=(n-1); i>0; i--){
            temp[i] = arr[i-1];
        }
        temp[0] = arr[n-1];

        for(int i=0; i<n; i++){
            arr[i] = temp[i];
        }
    }
    /* Time Complexity: O(2n), as we iterate through the array twice.
       Space Complexity: O(n) as we are using another array of size, same as the given array.
    */

    //-------------------------2.Optimal Approach---------------------------------------
    public static void rightRotate2(int arr[], int n){
        int x = arr[n-1];

        for(int i=(n-1); i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = x;
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

        rightRotate2(arr, n);

        System.out.print(" Right rotated array: ");
        for(int i: arr){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
