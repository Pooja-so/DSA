package Step2_Sorting;

import java.util.*;

public class RecursiveBubbleSort {

    public static void bubbleSort(int arr[], int n) {
        // Base condition: range == 1.
        if(n==1){
            return;
        }

        for(int j=0; j<n-1; j++) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] =  temp;
            }
        }
        //Range reduced after recursion:
        bubbleSort(arr, n-1);
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
           a[i] = sc.nextInt();
        }

        bubbleSort(a, n);
        
        System.out.print(" Sorted array: ");
        for(int i=0; i<a.length; i++){
            System.out.print(" " + a[i]);
        }

        sc.close();
    }
}
