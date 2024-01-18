package Step3_Array.Easy;

import java.util.Scanner;

public class LinearSearch {
    public static int linearSearch(int arr[], int n, int x){
        for(int i=0; i<n; i++){
            if(arr[i] == x)
                return i;
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(" Enter an element to be searched: ");
        int x = sc.nextInt();

        int indx = linearSearch(arr, n, x);
        
        if(indx == -1)
            System.out.println(" Element not found!! ");
        else
            System.out.println(" Element found at index " + indx);
        sc.close();
    }
}

/*  Time Complexity: O(n), where n is the length of the array.
    Space Complexity: O(1)
*/