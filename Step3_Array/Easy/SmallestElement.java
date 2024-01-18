package Step3_Array.Easy;

import java.util.Scanner;

public class SmallestElement {

    // ------------------1.Brute Approach-------------------
    public static int smallestElement1(int arr[]) {
        int n = arr.length;
        int temp =0;

        //Sorting the array in ascending order
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        } // end

        return arr[0];    
    }

    // --------------2. Optimal Approach------------------
    public static int smallestElement2(int arr[]) {
        int smallest = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i]<smallest){
                smallest = arr[i];
            }
        }
        return smallest;
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
        int smallest1 = smallestElement1(arr);
        int smallest2 = smallestElement2(arr);
        System.out.println(" The smallest element is " + smallest1);
        System.out.println(" The smallest element is " + smallest2);
        sc.close();
        
    }
    
}
