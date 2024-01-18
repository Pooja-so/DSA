package Step3_Array.Easy;

import java.util.*;

public class LargestElement {
    // ------------------1.Brute Approach-------------------
    public static int largestElement1(int arr[]) {
        int n = arr.length;
        int temp =0;

        //Sorting the array
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        } // end

        return arr[n-1];
        
    }

    // --------------2. Optimal Approach------------------
    public static int largestElement2(int arr[]) {
        int largest = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of an array: ");
        int n = sc.nextInt();

        int arr[] = new int[n]; 
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int largest1 = largestElement1(arr);
        int largest2 = largestElement2(arr);
        System.out.println(" The largest element is " + largest1);
        System.out.println(" The largest element is " + largest2);
        sc.close();
        
    }
}