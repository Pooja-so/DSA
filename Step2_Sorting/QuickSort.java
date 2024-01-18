package Step2_Sorting;

import java.util.*;

public class QuickSort {

    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;


        /* 1. Ascending order */
        while(i<j) {
            //  Finding element greater than pivot from left to right
            while(arr.get(i)<=pivot && i<=high-1){
                i++;
            }
            // Finding element smaller than pivot from right to left
            while(arr.get(j)>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        } //End loop when i>=j


        // /* 2. Descending order */
        // while(i<j) {
        //     //  Finding element greater than pivot from left to right
        //     while(arr.get(i)>=pivot && i<=high-1){
        //         i++;
        //     }
        //     // Finding element smaller than pivot from right to left
        //     while(arr.get(j)<pivot && j>=low+1){
        //         j--;
        //     }
        //     if(i<j){
        //         int temp = arr.get(i);
        //         arr.set(i, arr.get(j));
        //         arr.set(j, temp);
        //     }
        // } //End loop when i>=j

        
        // Palcing the pivot element at its correct position
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);

        return j;
    }

    public static void quickSort(List<Integer> arr, int low, int high) {
        if(low < high){
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex+1, high);
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        List<Integer> a = new ArrayList<>(n);

        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            a.add(i, sc.nextInt());
        }

        quickSort(a, 0, n-1);
        
        System.out.print(" Sorted array: ");
        for(int i=0; i<a.size(); i++){
            System.out.print(" " + a.get(i));
        }

        sc.close();
    }
}
