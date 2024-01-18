package Step2_Sorting;

import java.util.*;

public class SelectionSort {

    static void ascendingOrder(int a[], int n) {
        for(int i=0; i<n-1; i++) {
            int minIndex = i;

            for(int j=i+1; j<n; j++){
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex!=i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
                   
        }
    }

    static void descendingOrder(int a[], int n) {
        for(int i=0; i<n-1; i++) {
            int maxIndex = i;

            for(int j=i+1; j<n; j++){
                if(a[j] > a[maxIndex]){
                    maxIndex = j;
                }
            }
            if(maxIndex!=i){
                int temp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = temp; 
            }     
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int a[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(" Select the choice of order: \n 1. Ascending order \n 2. Descending order ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1: ascendingOrder(a, n);
            break;

            case 2: descendingOrder(a,n);
            break;

            default: System.out.println("Invalid choice!! \n Exiting..");
            System.exit(choice);
        }

       

        System.out.print(" Sorted array: ");
        for(int i: a){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
