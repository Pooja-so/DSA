package Step3_Array.Easy;

import java.util.HashSet;
import java.util.Scanner;


public class RemoveDuplicateElementFromSortedArray {

    //-------------------------1.Brute Force Approach-----------------------------------
    public static int removeDuplicateElement1(int arr[], int n) {
        // HashSet is a data structure that does not store duplicate elements.
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }

        int k = set.size();
        int j=0;
        for(int x: set){
            arr[j++] = x;
        }

        return k;
    }
    /*
     * Time Complexity: O(n*log(n))+O(n) where O(n*log(n)) is the time taken to add n element into set. O(n) is the time taken to iterate through the whole array of n elements.
     * 
     * Space Complexity: O(n) is the extra space. In the case if all the elements are unique than set will       contains all the n elements of the array.
     */


    //-------------------------2.Optimal Approach: Two pointers approach-----------------------------------
    public static int removeDuplicateElement2(int arr[], int n) {
        int i=0;
        for(int j=1; j<n; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    /* Time Complexity: O(n) as we are iterating through the array of n elements.
     * Space Complexity: O(1) as we are not using any extra space to solve the problem i.e. working on the same array.
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

        int k = removeDuplicateElement2(arr, n);
        System.out.println(" No. of unique elements: " + k);

        System.out.print(" Array after removing the duplicate elemnets: ");
        for(int i: arr){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
