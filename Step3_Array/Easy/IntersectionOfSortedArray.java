package Step3_Array.Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionOfSortedArray {

    // 1.-------------------------------Brute Force Approach----------------------------------- 
    public static ArrayList<Integer> intersectionOfSortedArray1(int arr1[], int arr2[], int n1, int n2){
        int visited[] = new int[n2];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                if(arr1[i] == arr2[j] && visited[j]==0){
                    result.add(arr1[i]);
                    visited[j]=1;
                    break;
                }
                if(arr2[j] > arr1[i]){
                    break;
                }
            }
        }
        return result;
    }
    /* Time Complexity: O(n1*n2) 
     * Space complexity: O(n2)
     */

    // 2.-------------------------------Optimal Approach----------------------------------- 
    public static ArrayList<Integer> intersectionOfSortedArray2(int arr1[], int arr2[], int n1, int n2){
        ArrayList<Integer> result = new ArrayList<>();

        int i=0, j=0;

        while(i<n1 && j<n2){
            if(arr1[i] == arr2[j]){
                result.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }else {
                j++;
            }
        }

        return result;
    }    
    /* Time Complexity: O(n1+n2) 
     * Space complexity: O(n2)
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array1: ");
        int n1 = sc.nextInt();

        int arr1[] = new int[n1];
        System.out.print(" Enter " + n1 + " elements: ");
        for(int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }

        System.out.print(" Enter the size of array2: ");
        int n2 = sc.nextInt();

        int arr2[] = new int[n2];
        System.out.print(" Enter " + n2 + " elements: ");
        for(int i=0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }

        ArrayList<Integer> intersect = intersectionOfSortedArray2(arr1, arr2, n1, n2);


        System.out.print(" Intersection of two sorted arrays: ");
        for(int i: intersect){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
