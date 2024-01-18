package Step2_Sorting;
import java.util.*;
public class BubbleSort {

    static void ascendingOrder(int a[], int n){
        int temp =0;
        // At the end of ith iteration of outer for loop we will get (n-i)th largest element placed at its correct position
        for(int i=0; i<n-1; i++) {
            int swap=0;
            // Inner loop starting checking from very first element whether two adjacent elments are in required order or not in order to bring the element in its correct position from last ownwards.
            for(int j=0; j<n-i-1; j++){
                // Swaps 2 adjacent elements if they are in incorrect order
                if(a[j] > a[j+1]) {
                    temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swap++;
                }
            }
            // If there were no swaps during the entire iteration of inner loop this means that the array was already in sorted order or has been sorted and doesn't require comparision for sorting anymore.
            if(swap==0){
                break;
            }
        }
    }

    static void descendingOrder(int a[], int n){
        int temp =0;
        // At the end of ith iteration of outer for loop we will get (n-i)th smallest element placed at its correct position
        for(int i=0; i<n-1; i++) {
            int swap=0;
            // Inner loop starting checking from very first element whether two adjacent elments are in required order or not in order to bring the element in its correct position from last ownwards.
            for(int j=0; j<n-i-1; j++){
                // Swaps 2 adjacent elements if they are in incorrect order
                if(a[j] < a[j+1]) {
                    temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swap++;
                }
            }
            // If there were no swaps during the entire iteration of inner loop this means that the array was already in sorted order or has been sorted and doesn't require comparision for sorting anymore.
            if(swap==0){
                break;
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
