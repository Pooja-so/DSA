package Step3_Array.Easy;

import java.util.Scanner;

public class MaximumConsecutiveOnes {
    public static int consecutiveOnes(int arr[], int n){
        int max1 = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==1){
                count++;
            } else {
                count = 0;
            }
            max1 = Math.max(max1, count);
        }
        return max1;
    }
    

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int x = consecutiveOnes(arr, n);
        System.out.println(" Maximum consecutive ones are: " + x) ;
        sc.close();
    }
}
