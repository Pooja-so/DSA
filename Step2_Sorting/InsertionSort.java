package Step2_Sorting;

import java.util.Scanner;

public class InsertionSort {

    static void ascendingOrder(int a[], int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && a[j - 1] > a[j]) {
                int temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
                j--;
            }
        }
    }

    static void descendingOrder(int a[], int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && a[j] > a[j-1]) {
                int temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
                j--;
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
