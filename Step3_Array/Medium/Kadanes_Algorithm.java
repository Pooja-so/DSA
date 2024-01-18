package Step3_Array.Medium;

import java.util.Scanner;


public class Kadanes_Algorithm {

    public static int maximumSumSubarray1(int arr[], int n){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            sum=0;
            for(int j=i; j<n; j++){
                sum +=arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static long maximumSumSubarray2(int arr[], int n){
        long maxi = Long.MIN_VALUE;
        long sum=0;

        for(int i=0; i<n; i++){
            sum += arr[i];

            if(sum>maxi){
                maxi = sum;
            }

            System.out.println("Sum: " + sum + " Maxi: " + maxi);


             // If sum < 0: discard the sum calculated
            if(sum<0){
                sum=0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:
        if(maxi<0){
            maxi=0;
        }

        return maxi;
    }

    public static long maximumSumSubarray3(int arr[], int n){
        long maxi = Long.MIN_VALUE;
        long sum=0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for(int i=0; i<n; i++){
            if(sum==0){
                start = i;
            }
            sum += arr[i];

            if(sum>maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            System.out.println("Sum: " + sum + " Maxi: " + maxi);


             // If sum < 0: discard the sum calculated
            if(sum<0){
                sum=0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:
        if(maxi<0){
            maxi=0;
        }

        System.out.println(" The subarray: ");
        for(int i=ansStart; i<=ansEnd; i++){
            System.out.print(" " + arr[i]);
        }

        return maxi;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        long sum = maximumSumSubarray2(arr,n);

        System.out.println(" The maximum sum is: " + sum);

        sc.close();
    }
}
